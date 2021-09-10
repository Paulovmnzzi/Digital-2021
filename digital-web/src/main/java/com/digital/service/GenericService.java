package com.digital.service;

import java.sql.SQLException;
import java.util.List;

import com.digital.dao.impl.ColumnEnum;
import com.digital.exception.GenericException;

public interface GenericService<T> {

	public List<T> findAll() throws ServiceException;
	
	public List<T> findAllBy(String criteria, String columna) throws ServiceException;
	
	public T getOne(Long id) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public void save(T entity) throws ServiceException;
	
	public void update(T entity) throws ServiceException;
	
	public T findByUsername(String sqlWhere) throws GenericException, SQLException;

}
