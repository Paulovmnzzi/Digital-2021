package com.digital.domain;

public class User implements Entity{

	private String usuario;
	private String contraseña;
	private int id;
	
	public User() {
	}

	public User(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public User(int id, String usuario, String contraseña) {
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [usuario=" + usuario + ", contraseña=" + contraseña + ", id=" + id + "]";
	}

	
	
}
