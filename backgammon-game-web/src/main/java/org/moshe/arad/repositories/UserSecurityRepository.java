package org.moshe.arad.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

import org.moshe.arad.repositories.dao.data.AuthorityRepository;
import org.moshe.arad.repositories.dao.data.BasicUserRepository;
import org.moshe.arad.repositories.dao.data.GameUserRepository;
import org.moshe.arad.repositories.dao.data.RepositoryUtils;
import org.moshe.arad.repositories.entities.Authority;
import org.moshe.arad.repositories.entities.BasicUser;
import org.moshe.arad.repositories.entities.GameRoom;
import org.moshe.arad.repositories.entities.GameUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserSecurityRepository {

	@Autowired
	GameUserRepository gameUserRepository;
	@Autowired
	AuthorityRepository authorityRepository;
	@Autowired
	BasicUserRepository basicUserRepository;

	public GameUser loadUserByUsername(String userName){
		return basicUserRepository.findByUserName(userName).getGameUser();
	}

	public void registerNewUser(GameUser gameUser) {
		try{
			if(gameUser == null) throw new NullPointerException();
			setCreateAndUpdateDbInfo(gameUser);
			gameUserRepository.save(gameUser);
		}
		catch (NullPointerException e) {
		}
	}

	private void setCreateAndUpdateDbInfo(GameUser gameUser) {
		gameUser.setCreatedBy(-1L);
		gameUser.setCreatedDate(new Date());
		gameUser.setLastUpdatedBy(-1L);
		gameUser.setLastUpdatedDate(new Date());
	}
	
	public Set<String> getAllUserNames() {
		List<GameUser> users = gameUserRepository.findAll();
		List<String> userNames = users.parallelStream().map(user->user.getUsername()).collect(Collectors.toList());
		return new ConcurrentSkipListSet<String>(userNames);
	}
	
	public Set<String> getAllEmails() {
		List<GameUser> users = gameUserRepository.findAll();
		List<String> emails = users.parallelStream().map(user->user.getEmail()).collect(Collectors.toList());
		return new ConcurrentSkipListSet<String>(emails);
	}
	
	public boolean isHasLoggedInUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return basicUserRepository.findByUserName(userName) != null ? true : false;
	}

	public void setAuthorityTo(BasicUser basicUser, String auth) {
		Authority newAuth = new Authority(basicUser.getUserName(), auth);
		basicUser.setAuthorities(Arrays.asList(newAuth));
//		newAuth.setBasicUser(basicUser);
		
		RepositoryUtils.setCreateAndUpdateSys(newAuth);
		RepositoryUtils.setCreateAndUpdateSys(basicUser);
		
		authorityRepository.save(newAuth);
	}
}
