package com.digital.domain;

public class User implements Entity {

	private String usuario;
	private String password;
	private Long id;

	public User() {
	}

	public User(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public User(Long id, String usuario, String password) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [usuario=" + usuario + ", Password=" + password + ", id=" + id + "]";
	}

}
