package com.digitalers.dao;

import com.digitalers.domain.User;
import com.digitalers.exception.GenericException;

public interface UserDao extends GenericDao<User>{

	public User getByUserName(String username) throws GenericException;
}
