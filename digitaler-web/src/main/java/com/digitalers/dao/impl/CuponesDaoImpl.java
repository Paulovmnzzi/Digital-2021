package com.digitalers.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.digitalers.dao.CuponesDao;
import com.digitalers.dao.JDBCBaseDaoImpl;
import com.digitalers.domain.Cupones;
import com.digitalers.exception.DuplicatedException;
import com.digitalers.exception.GenericException;

public class CuponesDaoImpl extends JDBCBaseDaoImpl<Cupones> implements CuponesDao {

	public CuponesDaoImpl() {
		super("cupones");
	}
	
	@Override
	public Cupones getEntityFromResultSet(ResultSet res) throws SQLException {
		Long idAux = res.getLong(1);//id->long->1
		String nombre = res.getString(2);
		String codigo = res.getString(3);
		Date fechaVigenciaDesde = res.getDate(4);
		Date fechaVigenciaHasta= res.getDate(5);
		Double descuento = res.getDouble(6);
		
		return new Cupones(idAux, nombre, codigo, fechaVigenciaDesde, fechaVigenciaHasta, descuento);
	}
	
	@Override
	public String getSaveSQL() {
		return "(nombre,codigo,fecha_vigencia_desde,fecha_vigencia_hasta,descuento) values(?,?,?,?,?)";
	}
	
	@Override
	public void save(PreparedStatement pst, Cupones entity) throws SQLException {
		pst.setString(1,entity.getNombre());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new java.sql.Date(entity.getFechaVigenciaDesde().getTime()));
		pst.setDate(4, new java.sql.Date(entity.getFechaVigenciaHasta().getTime()));
		pst.setDouble(5,entity.getDescuento());
	}
	
	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void update(PreparedStatement pst, Cupones entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
