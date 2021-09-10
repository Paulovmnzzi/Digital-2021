package com.digital.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.digital.domain.Entity;
import com.digital.exception.DuplicatedException;
import com.digital.exception.GenericException;

public abstract class JDBCBaseDaoImpl<T> implements GenericDao<T> {

	protected String tabla;
	
	public JDBCBaseDaoImpl(String tabla) {
		this.tabla = tabla;
	}
	
	@Override
	public T getOne(Long id) throws GenericException {
		
		T entity = null;
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "select * from " +  this.tabla  +" where id = " +id;
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				
				try(ResultSet res = pst.executeQuery()) {
					
					//encontro algo?
					if(res.next()) {
						
						entity = this.getEntityFromResultSet(res);
					}					
				}				
			}			
		} catch (SQLException e) {			
			throw new GenericException("No se ha podido obtener articulo con id= " + id, e);
		}		
		
		return entity;
	}

	public abstract T getEntityFromResultSet(ResultSet res) throws SQLException;
	
	public List<T> findAll() throws GenericException {
		
		List<T> list = new ArrayList<T>();
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "select * from " +  this.tabla;
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				
				try(ResultSet res = pst.executeQuery()) {
					
					//encontro algo?
					while(res.next()) {
						
						T entity = this.getEntityFromResultSet(res);
						
						list.add(entity);
					}					
				}				
			}			
		} catch (SQLException e) {			
			throw new GenericException("No se ha podido obtener la lista de = " + this.tabla, e);
		}		
		
		return list;	
	}
	
	public void delete(Long id) throws GenericException {
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {
			String sql = "DELETE from " +  this.tabla+ " WHERE ID=?";
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setLong(1, id);
				pst.executeUpdate();
			}
		} catch (SQLException e) {			
			throw new GenericException("No se ha podido eliminar de la tabla" + this.tabla + " el id="+id, e);
		}		
	}
	
	@Override
	public void save(T entity) throws DuplicatedException, GenericException {
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			String sql = "INSERT INTO " + this.tabla + this.getSaveSQL();
			
			try(PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				this.save(pst,entity);
				
				//insert into articulos (titulo, etc) values(?,?,?,?...)
				pst.execute();
				
				try(ResultSet resultSet = pst.getGeneratedKeys()) {
					
					if(resultSet.next()) {
						((Entity)entity).setId((long) resultSet.getLong(1));
					}
				}
			}
		}catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException(tabla, e);
			}
			throw new GenericException("No se ha podido crear el registro en" + tabla, e);
		}	
	}
	
	@Override
	public void update(T entity) throws DuplicatedException, GenericException {
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			String sql = "UPDATE " +  this.tabla  + " SET " + this.getUpdateSQL() + " WHERE id=?";
			
			long lastWildcardidPosition = sql.chars().filter(c-> c=='?').count();
					
			try(PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				this.update(pst,entity);
				
				pst.setLong((int)lastWildcardidPosition, ((Entity)entity).getId());
				
				pst.execute();
			}
		}catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException(tabla, e);
			}
			throw new GenericException("No se ha podido crear el registro en" + tabla, e);
		}	
	}
	
	public List<T> findAllBy(String sqlWhere) throws GenericException {
		
		List<T> list = new ArrayList<>();

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "SELECT * FROM " + this.tabla + " where " + sqlWhere;

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				try (ResultSet res = pst.executeQuery()) {
					while(res.next()) {
						T entity = getEntityFromResultSet(res);
						list.add(entity);
					}
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se ha podido consultar la lista", e);
		}

		return list;
	}
	
	public T findByUsername(String sqlWhere) throws GenericException, SQLException {
		T entity = null;
		
		Connection conex = AdministradorDeConexiones.obtenerConexion();
		String sql = "Select * from " + this.tabla + " " + sqlWhere;
		PreparedStatement pst = conex.prepareStatement(sql);
		ResultSet result = pst.executeQuery();
		if(result.next()) {
			entity = getEntityFromResultSet(result);
		}
		return entity;
	}

	protected abstract String getUpdateSQL();
	protected abstract void update(PreparedStatement pst, T entity) throws SQLException;

	public abstract String getSaveSQL();
	public abstract void save(PreparedStatement pst, T entity) throws SQLException;
}
