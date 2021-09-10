package com.digitalers.domain;

import java.util.Date;

public class Cupones implements Entity {

	private Long id;
	private String nombre;
	private String codigo;
	private Date fechaVigenciaDesde;
	private Date fechaVigenciaHasta;
	private Double descuento;
	
	public Cupones() {
		
	}

	public Cupones(Long id, String nombre, String codigo, Date fechaVigenciaDesde, Date fechaVigenciaHasta,
			Double descuento) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.fechaVigenciaDesde = fechaVigenciaDesde;
		this.fechaVigenciaHasta = fechaVigenciaHasta;
		this.descuento = descuento;
	}

	public Cupones(String nombre, String codigo, Date fechaVigenciaDesde, Date fechaVigenciaHasta, Double descuento) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.fechaVigenciaDesde = fechaVigenciaDesde;
		this.fechaVigenciaHasta = fechaVigenciaHasta;
		this.descuento = descuento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(Date fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	public Date getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(Date fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Cupones [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", fechaVigenciaDesde="
				+ fechaVigenciaDesde + ", fechaVigenciaHasta=" + fechaVigenciaHasta + ", descuento=" + descuento + "]";
	}
}
