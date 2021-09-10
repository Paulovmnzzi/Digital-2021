package com.digitalers.service;

import com.digitalers.domain.User;

public interface LoginService extends GenericService<User>{

	public User getUserByUserName(String username) throws ServiceException;
}
