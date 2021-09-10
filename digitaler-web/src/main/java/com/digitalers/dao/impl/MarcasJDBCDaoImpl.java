package com.digitalers.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digitalers.dao.JDBCBaseDaoImpl;
import com.digitalers.dao.MarcasDao;
import com.digitalers.domain.Marcas;


public class MarcasJDBCDaoImpl extends JDBCBaseDaoImpl<Marcas> implements MarcasDao {

	public MarcasJDBCDaoImpl() {
		super("marcas");
	}
	
	@Override
	public String getSaveSQL() {
		return "(descripcion,codigo,habilitada) VALUES (?,?,?)";
	}
	
	@Override
	public void save(PreparedStatement pst, Marcas entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getCodigo());
		pst.setLong(3, entity.getHabilitada());
	}

	@Override
	protected String getUpdateSQL() {
		return "descripcion=?, habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Marcas entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setLong(2, entity.getHabilitada());
	}

	@Override
	public Marcas getEntityFromResultSet(ResultSet res) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}

