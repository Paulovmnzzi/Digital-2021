package com.digital.dao;

import com.digital.domain.User;

public interface UserDao extends GenericDao<User> {

	public User getUserByUserName(String user);
	
}
