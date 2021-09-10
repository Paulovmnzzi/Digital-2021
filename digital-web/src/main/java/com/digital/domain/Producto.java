package com.digital.domain;

public class Producto implements Entity {

	private int id;
	private String titulo;
	private int codigo;
	private int precio;

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int id, String titulo, int codigo, int precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
	}
	
	public Producto(String titulo, int codigo, int precio) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub

	}

}
