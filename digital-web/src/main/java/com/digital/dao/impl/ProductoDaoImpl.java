package com.digital.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.digital.dao.JDBCBaseDaoImpl;
import com.digital.dao.ProductoDao;
import com.digital.domain.Producto;
import com.digital.exception.GenericException;

public class ProductoDaoImpl extends JDBCBaseDaoImpl<Producto> implements ProductoDao {

	public ProductoDaoImpl() {
		super("articulos");
	}

	@Override
	public Producto getEntityFromResultSet(ResultSet res) throws SQLException {
		
		Long idAux = res.getLong(1);//id->long->1
		String titulo = res.getString(2);
		String codigo = res.getString(3);
		Date fechaCreacion = res.getDate(4);
		Double precio = res.getDouble(5);
		Long stock = res.getLong(6);
		Long marcasId = res.getLong(7);
		Long categoriasId = res.getLong(8);
		Producto productoNuevo = new Producto(idAux, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
		
		return productoNuevo;
	}

	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void update(PreparedStatement pst, Producto entity) throws SQLException {
		
	}

	@Override
	public String getSaveSQL() {
		return "(titulo, codigo, fecha_creacion, precio, stock, marcas_id, categorias_id) values(?,?,?,?,?,?,?)";
	}

	@Override
	public void save(PreparedStatement pst, Producto entity) throws SQLException {
		pst.setString(1,entity.getTitulo());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));
		pst.setDouble(4, entity.getPrecio());
		pst.setLong(5, entity.getStock());
		pst.setLong(6, entity.getMarcasId());
		pst.setLong(7, entity.getCategoriasId());
		

	}
	
	public List<Producto> findAllBy(String titulo, String columna) throws GenericException {
		String sql = columna +" like '%"+titulo+"%'";
		return super.findAllBy(sql);
	}

}
