package com.digital.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.digital.dao.JDBCBaseDaoImpl;
import com.digital.dao.UserDao;
import com.digital.domain.User;
import com.digital.exception.GenericException;

public class UserDaoImpl extends JDBCBaseDaoImpl<User> implements UserDao{

	public UserDaoImpl() {
		super("users");
	}

	public User getUserByUserName(String user) {
		return null;
	}

	@Override
	public User getEntityFromResultSet(ResultSet res) throws SQLException {
		
		Long id = (long) res.getInt(1);
		String nombre = res.getString(2);
		String Password = res.getString(3);
		
		User usuario = new User(id, nombre, Password);
		
		return usuario;
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

	@Override
	public List<User> findAllBy(String criteria, String columna) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
