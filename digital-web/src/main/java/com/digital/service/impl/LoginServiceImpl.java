package com.digital.service.impl;

import java.sql.SQLException;

import com.digital.dao.GenericDao;
import com.digital.dao.JDBCBaseDaoImpl;
import com.digital.dao.impl.UserDaoImpl;
import com.digital.domain.User;
import com.digital.exception.GenericException;
import com.digital.service.LoginService;
import com.digital.service.ServiceException;

public class LoginServiceImpl extends AbstractBaseService<User> implements LoginService {

	public LoginServiceImpl() {
		super(new UserDaoImpl());
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public User getUserByUserName(String user) throws ServiceException, SQLException {
		try {
			User usuario = this.dao.findByUsername("where usuario='" + user + "'");
			if(usuario == null) {
				throw new ServiceException("Usuario/Password incorrectos", null);
			}
			return usuario;
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}



}
