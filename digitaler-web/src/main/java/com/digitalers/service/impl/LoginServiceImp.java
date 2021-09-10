package com.digitalers.service.impl;

import java.util.List;

import com.digitalers.dao.impl.UserDaoImpl;
import com.digitalers.domain.User;
import com.digitalers.exception.GenericException;
import com.digitalers.service.LoginService;
import com.digitalers.service.ServiceException;

public class LoginServiceImp extends AbstractBaseService<User> implements LoginService {

	public LoginServiceImp() {
		super(new UserDaoImpl("user"));
	}

	@Override
	public User getUserByUserName(String username) throws ServiceException {		
		try {
			List<User> users = this.dao.findAllBy("username='"+username+"'");
			if(users.isEmpty()) {
				throw new ServiceException("Usuario/Password invalidos" , null);
			}
			return users.get(0);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}


}
