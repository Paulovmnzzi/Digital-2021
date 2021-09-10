package com.digital.dao;

import java.sql.SQLException;
import java.util.List;

import com.digital.exception.DuplicatedException;
import com.digital.exception.GenericException;

public interface GenericDao<T> {

	//metodos que van a tener todas las interfaces ej: ArticulosDaoImpl y CategoriaDaoImpl
	
	public List<T> findAll() throws GenericException;
	
	public T getOne(Long id) throws GenericException;
	
	public void delete(Long id) throws GenericException;
	
	public void save(T entity) throws DuplicatedException, GenericException;
	
	public void update(T entity) throws DuplicatedException, GenericException;

	public List<T> findAllBy(String criteria, String columna) throws GenericException;
	
	public T findByUsername(String sqlWhere) throws GenericException, SQLException;
}
