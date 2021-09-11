package com.digital.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.digital.dao.JDBCBaseDaoImpl;
import com.digital.dao.MarcasDao;
import com.digital.domain.Marcas;
import com.digital.exception.GenericException;

public class MarcasDaoImpl extends JDBCBaseDaoImpl<Marcas> implements MarcasDao {

	public MarcasDaoImpl() {
		super("marcas");
	}

	@Override
	public List<Marcas> findAllBy(String titulo, String columna) throws GenericException {
		String sql = columna + " like '%" + titulo + "%'"; 
		return super.findAllBy(sql);
	}

	@Override
	public Marcas getEntityFromResultSet(ResultSet res) throws SQLException {
		Long id = res.getLong(1);
		String descripcion = res.getString(2);
		String codigo = res.getString(3);
		Long habilitada = res.getLong(4);
		
		Marcas marca = new Marcas(id, descripcion, codigo, habilitada);
		
		return marca;
	}

	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void update(PreparedStatement pst, Marcas entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSaveSQL() {
		return "(descripcion, codigo, habilitada) values (?,?,?)";
	}

	@Override
	public void save(PreparedStatement pst, Marcas entity) throws SQLException {

		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getCodigo());
		pst.setLong(3, entity.getHabilitada());
		
	}

}
