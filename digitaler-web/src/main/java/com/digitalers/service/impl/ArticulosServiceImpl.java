package com.digitalers.service.impl;

import com.digitalers.dao.impl.ArticulosDaoImpl;
import com.digitalers.domain.Articulos;
import com.digitalers.service.ArticulosService;

public class ArticulosServiceImpl extends AbstractBaseService<Articulos> implements ArticulosService {
	
	public ArticulosServiceImpl() {
		super(new ArticulosDaoImpl());
	}

}
