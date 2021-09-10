package com.digitalers.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digitalers.dao.JDBCBaseDaoImpl;
import com.digitalers.dao.UserDao;
import com.digitalers.domain.User;
import com.digitalers.exception.GenericException;

public class UserDaoImpl extends JDBCBaseDaoImpl<User> implements UserDao {

	public UserDaoImpl(String tabla) {
		super("users");
	}

	@Override
	public User getByUserName(String username) throws GenericException {
		return null;
	}

	@Override
	public User getEntityFromResultSet(ResultSet res) throws SQLException {
		return null;
	}

	@Override
	protected String getUpdateSQL() {
		return null;
	}

	@Override
	protected void update(PreparedStatement pst, User entity) throws SQLException {
		
	}

	@Override
	public String getSaveSQL() {
		return null;
	}

	@Override
	public void save(PreparedStatement pst, User entity) throws SQLException {
	
	}	

}
