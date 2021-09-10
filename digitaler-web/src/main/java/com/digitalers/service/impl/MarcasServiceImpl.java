package com.digitalers.service.impl;

import com.digitalers.dao.impl.MarcasJDBCDaoImpl;
import com.digitalers.domain.Marcas;
import com.digitalers.service.MarcasService;

public class MarcasServiceImpl extends AbstractBaseService<Marcas> implements MarcasService{

	public MarcasServiceImpl() {
		super(new MarcasJDBCDaoImpl());
	}

}
