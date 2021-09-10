package com.digitalers.enums;

public enum ViewEnums {

	LOGIN("/views/login.jsp"),
	LOGIN_SUCCESS("/views/loginSuccess.jsp"),
	UPLOAD("/views/upload.jsp"),
	LISTADO_GENERAL("/views/listadoGeneral.jsp"),
	NUEVO_PRODUCTO("/views/nuevo.jsp"), 
	EDITAR_PRODUCTO("/views/editar.jsp"), 
	UPLOAD_PREVIEW("/views/preview.jsp"), 
	RESULTADO_PREVIEW("/views/resultadoPreview.jsp");
	
	private String view;
	
	//ctrl+spce
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}
}
