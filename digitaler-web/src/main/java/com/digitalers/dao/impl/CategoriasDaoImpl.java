package com.digitalers.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digitalers.dao.CategoriasDao;
import com.digitalers.dao.JDBCBaseDaoImpl;
import com.digitalers.domain.Categorias;

public class CategoriasDaoImpl extends JDBCBaseDaoImpl<Categorias> implements CategoriasDao {

	public CategoriasDaoImpl() {
		super("categorias");
	}

	@Override
	public Categorias getEntityFromResultSet(ResultSet res) throws SQLException {
		Long idAux = res.getLong(1);//id->long->1
		String descripcion = res.getString(2);
		String codigo = res.getString(3);
		Long habilitada = res.getLong(4);
		
		//??
		return new Categorias(idAux, descripcion, codigo, habilitada);
	}
	
	@Override
	public String getSaveSQL() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(PreparedStatement pst, Categorias entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void update(PreparedStatement pst, Categorias entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
