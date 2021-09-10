package com.digitalers.enums;

public enum ViewKeyEnums {

	USUARIO("usuario"), 
	USUARIO_PASSWORD_INVALIDO("Usuario/Password Inválido"),
	USUARIO_SESSION_INVALIDA("Su sesión ha finalizado"),
	ERROR_GENERAL("error"), 
	WARNING_GENERAL("warning"),
	EXITO("exito"), 
	LISTADO("listado"),
	
	//clave de busqueda
	CLAVE_BUSQUEDA("claveBusqueda"), 
	ID_PRODUCTO("id"),
	PRODUCTO_EDITAR("producto_editar"), 
	UPLOAD_PREVIEW_KEY("upload_preview_key"), 
	LISTADO_FAIL("listadoFail"),
	LISTADO_OK("listadoOk"), 
	TOTAL("total"), 
	FILE_NAME("file_name"),
	;
	
	private String viewKey;
	
	private ViewKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getViewKey() {
		return viewKey;
	}
}
