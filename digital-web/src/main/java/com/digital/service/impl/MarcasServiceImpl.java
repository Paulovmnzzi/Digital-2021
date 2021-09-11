package com.digital.service.impl;

import com.digital.dao.impl.MarcasDaoImpl;
import com.digital.domain.Marcas;
import com.digital.service.MarcasService;

public class MarcasServiceImpl extends AbstractBaseService<Marcas> implements MarcasService {

	public MarcasServiceImpl() {
		super(new MarcasDaoImpl());
	}
	
}
