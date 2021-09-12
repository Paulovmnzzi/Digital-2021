package com.digital.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.digital.dao.CategoriaDao;
import com.digital.domain.Categorias;
import com.digital.exception.GenericException;

public class CategoriasDaoImpl extends JDBCBaseDaoImpl<Categorias> implements CategoriaDao {

	public CategoriasDaoImpl() {
		super("categorias");
	}

	@Override
	public List<Categorias> findAllBy(String titulo, String columna) throws GenericException {
		String sql = columna + " like '%" + titulo + "%'"; 
		return super.findAllBy(sql);
	}

	@Override
	public Categorias getEntityFromResultSet(ResultSet res) throws SQLException {
		
		Long id = res.getLong(1);
		String descripcion = res.getString(2);
		String codigo = res.getString(3);
		Long habilitada = res.getLong(4);
		
		return new Categorias(id, descripcion, codigo, habilitada);
	}

	@Override
	protected String getUpdateSQL() {
		return null;
	}

	@Override
	protected void update(PreparedStatement pst, Categorias entity) throws SQLException {
		
	}

	@Override
	public String getSaveSQL() {
		return "(descripcion, codigo, habilitada) values (?,?,?)";
	}

	@Override
	public void save(PreparedStatement pst, Categorias entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getCodigo());
		pst.setLong(3, entity.getHabilitada());
		
	}
	
	

}
