package com.digitalers.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.digitalers.dao.ArticulosDao;
import com.digitalers.dao.JDBCBaseDaoImpl;
import com.digitalers.domain.Articulos;
import com.digitalers.exception.GenericException;

public class ArticulosDaoImpl extends JDBCBaseDaoImpl<Articulos> implements ArticulosDao {

	public ArticulosDaoImpl() {
		super("articulos");
	}
	
	@Override
	public Articulos getEntityFromResultSet(ResultSet res) throws SQLException{
		
		Long idAux = res.getLong(1);//id->long->1
		String titulo = res.getString(2);
		String codigo = res.getString(3);
		Date fechaCreacion = res.getDate(4);
		Double precio = res.getDouble(5);
		Long stock = res.getLong(6);
		Long marcasId = res.getLong(7);
		Long categoriasId = res.getLong(8);
		
		//??
		return new Articulos(idAux, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
	}
	
	@Override
	public String getSaveSQL() {
		return "(titulo, codigo,fecha_creacion,precio,stock,marcas_id,categorias_id) values(?,?,?,?,?,?,?)";
	}
	
	@Override
	public void save(PreparedStatement pst, Articulos entity) throws SQLException {
		pst.setString(1,entity.getTitulo());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));
		pst.setDouble(4, entity.getPrecio());
		pst.setLong(5, entity.getStock());
		pst.setLong(6, entity.getMarcasId());
		pst.setLong(7, entity.getCategoriasId());
	}
	
	@Override
	protected String getUpdateSQL() {		
		return "titulo=?, precio=?, stock=?, marcas_id=?,categorias_id=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Articulos entity) throws SQLException {
		pst.setString(1,entity.getTitulo());
		pst.setDouble(2, entity.getPrecio());
		pst.setLong(3, entity.getStock());
		pst.setLong(4, entity.getMarcasId());
		pst.setLong(5, entity.getCategoriasId());
	}
	
	@Override
	public List<Articulos> findAllBy(String titulo) throws GenericException {
		String sql = "titulo like '%"+titulo+"%'";
		return super.findAllBy(sql);
	}
}
