package org.moshe.arad.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.moshe.arad.repositories.UserSecurityRepository;
import org.moshe.arad.repositories.dao.data.AuthorityRepository;
import org.moshe.arad.repositories.dao.data.BasicUserRepository;
import org.moshe.arad.repositories.dao.data.GameUserRepository;
import org.moshe.arad.repositories.dao.data.RepositoryUtils;
import org.moshe.arad.repositories.entities.Authority;
import org.moshe.arad.repositories.entities.BasicUser;
import org.moshe.arad.repositories.entities.GameUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:persistence-context-test.xml",
						"classpath:user-security-context-test.xml"})
public class UserSecurityRepositoryTest {

private final Logger logger = LogManager.getLogger(UserSecurityRepositoryTest.class);
	
	@Autowired
	UserSecurityRepository userSecurityRepo;
	@Autowired
	GameUserRepository gameUserRepository;
	@Autowired
	BasicUserRepository basicUserRepository;
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Resource
	GameUser gameUser1;
	@Resource
	GameUser gameUser2;
	@Resource
	GameUser gameUser3;
	@Resource
	BasicUser basicUser;
	
	@Before
	public void setup(){
		logger.info("Initializing test DB.");
		
		RepositoryUtils.setCreateAndUpdateSys(basicUser);
		RepositoryUtils.setCreateAndUpdateSys(gameUser1);
		gameUser1.setUserId(null);
		
		basicUser.setGameUser(gameUser1);
		gameUser1.setBasicUser(basicUser);
		
		basicUserRepository.save(basicUser);
	}
	
	@After
	public void cleanup(){
		gameUserRepository.deleteAllInBatch();
	}
	
	@Test
	public void loadUserByUserNameTest(){
		GameUser expected = gameUser1;
		GameUser actual = userSecurityRepo.loadUserByUsername("userName1");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void loadUserByUserNameNotInDBTest(){
		GameUser actual = userSecurityRepo.loadUserByUsername("userNotInDB");
		
		assertNull(actual);
	}
	
	@Test
	public void registerNewUserTest(){
		gameUserRepository.deleteAll();
		GameUser gameUser = gameUser1;
		userSecurityRepo.registerNewUser(gameUser);
		List<GameUser> users = gameUserRepository.findAll();
		
		assertEquals(1, users.size());
		assertEquals(gameUser.getUsername(), users.get(0).getUsername());
	}
	
	@Test
	public void registerNewUserNullValueTest(){
		try{
			userSecurityRepo.registerNewUser(null);
		}
		catch (NullPointerException e) {
			fail("Null pointer exception thrown");
		}
	}
	
	@Test
	public void getAllUserNamesTest(){
		Set<String> userNames = userSecurityRepo.getAllUserNames();
		
		assertTrue(userNames.contains(gameUser1.getUsername()));
		assertTrue(userNames.contains(gameUser2.getUsername()));
		assertTrue(userNames.contains(gameUser3.getUsername()));
		assertEquals(3, userNames.size());
	}
	
	@Test
	public void getAllUserNamesEmptySetTest(){
		gameUserRepository.deleteAll();
		Set<String> userNames = userSecurityRepo.getAllUserNames();
		
		assertEquals(0, userNames.size());
	}
	
	@Test
	public void getAllEmailsTest(){
		Set<String> emails = userSecurityRepo.getAllEmails();
		
		assertTrue(emails.contains(gameUser1.getEmail()));
		assertTrue(emails.contains(gameUser2.getEmail()));
		assertTrue(emails.contains(gameUser3.getEmail()));
		assertEquals(3, emails.size());
	}
	
	@Test
	public void getAllEmailsEmptySetTest(){
		gameUserRepository.deleteAll();
		Set<String> emails = userSecurityRepo.getAllEmails();
		
		assertEquals(0, emails.size());
	}
	
	@Test
	@WithMockUser(username = "userName1", password = "password1")
	public void isHasLoggedInUserTest(){
		gameUserRepository.save(gameUser1);
		
		assertTrue(userSecurityRepo.isHasLoggedInUser());
	}
	
	@Test
	@WithAnonymousUser
	public void isHasLoggedInUserAnonymousTest(){
		assertFalse(userSecurityRepo.isHasLoggedInUser());
	}
	
	@Test
	public void setAuthorityToTest(){
		
		userSecurityRepo.setAuthorityTo(basicUser, "WATCHER");
		assertEquals(1, authorityRepository.findByBasicUser(basicUser)
				.stream()
				.filter(item -> !item.equals("WATCHER"))
				.count());                                 
	}
}
