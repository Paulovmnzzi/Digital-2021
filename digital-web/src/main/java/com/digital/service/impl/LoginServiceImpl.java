package com.digital.service.impl;

import java.sql.SQLException;

import com.digital.dao.GenericDao;
import com.digital.dao.impl.JDBCBaseDaoImpl;
import com.digital.dao.impl.UserDaoImpl;
import com.digital.domain.User;
import com.digital.exception.GenericException;
import com.digital.service.LoginService;
import com.digital.service.ServiceException;

public class LoginServiceImpl extends AbstractBaseService<User> implements LoginService {

	public LoginServiceImpl() {
		super(new UserDaoImpl());
	}
	
	@Override
	public User findByUsername(String sqlWhere) throws GenericException, SQLException {
		return super.findByUsername(sqlWhere);
	}

	
	


}
