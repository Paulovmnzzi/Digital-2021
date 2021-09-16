package com.digital.enums;

public enum ViewEnums {

	LOGIN("/views/login.jsp"),
	LOGIN_SUCCESS("/views/LoginSucces.jsp"),
	UPLOAD("/views/upload.jsp"),
	LISTADO_GENERAL("/views/listadoGeneral.jsp"),
	NUEVO_PRODUCTO("/views/productoNuevo.jsp"), 
	EDITAR_PRODUCTO("/views/editarProducto.jsp"), 
	UPLOAD_PREVIEW("/views/preview.jsp"), 
	RESULTADO_PREVIEW("/views/resultadoPreview.jsp"), 
	REGISTRO("/views/Registro.jsp"), 
	INICIO("/index.jsp");
	
	private String view;
	
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}
	
}
