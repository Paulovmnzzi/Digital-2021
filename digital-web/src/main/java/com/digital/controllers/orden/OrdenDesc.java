package com.digital.controllers.orden;

import java.util.Comparator;

import com.digital.domain.Producto;

public class OrdenDesc implements Comparator<Producto> {

	public int compare(Producto o1, Producto o2) {
		return o2.getPrecio().compareTo(o1.getPrecio());
	}

}
