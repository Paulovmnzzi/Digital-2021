package com.digitalers.service;

import java.util.List;

public interface GenericService<T> {

	public List<T> findAll() throws ServiceException;
	
	public List<T> findAllBy(String criteria) throws ServiceException;
	
	public T getOne(Long id) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public void save(T entity) throws ServiceException;
	
	public void update(T entity) throws ServiceException;
}
