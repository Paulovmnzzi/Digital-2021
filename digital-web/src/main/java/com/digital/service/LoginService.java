package com.digital.service;

import java.sql.SQLException;

import com.digital.domain.User;

public interface LoginService extends GenericService<User> {

	public User getUserByUserName(String user) throws ServiceException, SQLException;
	
}
