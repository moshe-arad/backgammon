package org.moshe.arad.repositories.dao.hibernate.interfaces;

import java.util.List;

import org.moshe.arad.repositories.entities.GameUser;


public interface HibernateGameUserDao extends HibernateDao<GameUser,Long> {

	public List<GameUser> findByFirstName(String firstName);
	
	public GameUser findByUserName(String userName);
	
	public List<String> getAllUserNames();

	public List<String> getAllEmails();
}
