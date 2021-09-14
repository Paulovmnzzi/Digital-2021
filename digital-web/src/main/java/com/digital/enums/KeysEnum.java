package com.digital.enums;

public enum KeysEnum {
	
	USUARIO("usuario"), 
	USUARIO_PASSWORD_INVALIDO("Usuario/Password Invalido"),
	USUARIO_SESSION_INVALIDA("Debe iniciar sesion"),
	ERROR_GENERAL("error"), 
	WARNING_GENERAL("warning"),
	EXITO("exito"), 
	LISTADO("listado"),
	
	//clave de busqueda
	CLAVE_BUSQUEDA("claveBusqueda"), 
	CLAVE_BUSQUEDA_PRECIO("claveBusquedaPrecio"),
	ID_PRODUCTO("id"),
	PRODUCTO_EDITAR("producto_editar"), 
	UPLOAD_PREVIEW_KEY("upload_preview_key"), 
	LISTADO_FAIL("listadoFail"),
	LISTADO_OK("listadoOk"), 
	TOTAL("total"), 
	FILE_NAME("file_name"),
	ALREADY_LOGGED("Usted ya se encuentra logueado")
	;
	
	private String viewKey;
	
	private KeysEnum(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getViewKey() {
		return viewKey;
	}
}
