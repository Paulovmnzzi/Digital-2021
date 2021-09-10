package com.digital.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.digital.dao.GenericDao;
import com.digital.dao.impl.ColumnEnum;
import com.digital.exception.DuplicatedException;
import com.digital.exception.GenericException;
import com.digital.service.GenericService;
import com.digital.service.ServiceException;

public class AbstractBaseService<T> implements GenericService<T> {

	protected GenericDao<T> dao;
	
	public AbstractBaseService(GenericDao<T> dao) {
		this.dao = dao;
	}
	
	public AbstractBaseService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("No se han podido consultar los datos", e);
		}
	}

	@Override
	public T getOne(Long id) throws ServiceException {		
		try {
			return this.dao.getOne(id);
		} catch (GenericException e) {			
			throw new ServiceException("No se ha podido obtener la entidad con id:" + id, e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		try {
			this.dao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("Error eliminando entidad", e);
		}
	}
	
	@Override
	public void save(T entity) throws ServiceException {
		try {
			this.dao.save(entity);
		} catch (DuplicatedException | GenericException e ) {
			throw new ServiceException("No se ha podido crear la entidad", e);
		} 	
	}
	
	@Override
	public void update(T entity) throws ServiceException {
		try {
			this.dao.update(entity);
		} catch (DuplicatedException | GenericException e) {			
			throw new ServiceException("No se pudo actulizar", e);
		}
	}
	
	public List<T> findAllBy(String criteria, String columna) throws ServiceException {
		try {
			return this.dao.findAllBy(criteria, columna);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido consultar todos", e); 
		}
	}

	@Override
	public T findByUsername(String sqlWhere) throws GenericException, SQLException {
		return this.dao.findByUsername(sqlWhere);
	}



	
	
}
