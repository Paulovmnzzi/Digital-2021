package com.digitalers.service.impl;

import com.digitalers.dao.impl.CuponesDaoImpl;
import com.digitalers.domain.Cupones;
import com.digitalers.service.CuponesService;

public class CuponesServiceImpl extends AbstractBaseService<Cupones> implements CuponesService {

	public CuponesServiceImpl() {
		super(new CuponesDaoImpl());
	}

}
