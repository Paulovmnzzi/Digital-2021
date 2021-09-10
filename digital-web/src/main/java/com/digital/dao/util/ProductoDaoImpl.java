package com.digital.dao.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.digital.dao.JDBCBaseDaoImpl;
import com.digital.dao.ProductoDao;
import com.digital.domain.Producto;
import com.digital.exception.GenericException;

public class ProductoDaoImpl extends JDBCBaseDaoImpl<Producto> implements ProductoDao {

	public ProductoDaoImpl() {
		super("productos");
	}

	@Override
	public Producto getEntityFromResultSet(ResultSet res) throws SQLException {
		
		int id = res.getInt(1);
		String titulo = res.getString(2);
		int codigo = res.getInt(3);
		int precio = res.getInt(4);
		
		Producto productoNuevo = new Producto(id, titulo, codigo, precio);
		
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
		return "(titulo, codigo, precio) values(?,?,?)";
	}

	@Override
	public void save(PreparedStatement pst, Producto entity) throws SQLException {
		pst.setString(1, entity.getTitulo());
		pst.setInt(2, entity.getCodigo());
		pst.setInt(3, entity.getPrecio());
		

	}
	
	public List<Producto> findAllBy(String titulo, String columna) throws GenericException {
		String sql = columna +" like '%"+titulo+"%'";
		return super.findAllBy(sql);
	}

}
