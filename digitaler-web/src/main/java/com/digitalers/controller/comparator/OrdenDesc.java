package com.digitalers.controller.comparator;

import java.util.Comparator;

import com.digitalers.domain.Articulos;

public class OrdenDesc implements Comparator<Articulos> {

	@Override
	public int compare(Articulos o1, Articulos o2) {
		return o2.getPrecio().compareTo(o1.getPrecio());
	}
}
