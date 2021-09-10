package com.digital.domain;

public class User implements Entity{

	private String usuario;
	private String contrase�a;
	private int id;
	
	public User() {
	}

	public User(String usuario, String contrase�a) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public User(int id, String usuario, String contrase�a) {
		this.id = id;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [usuario=" + usuario + ", contrase�a=" + contrase�a + ", id=" + id + "]";
	}

	
	
}
