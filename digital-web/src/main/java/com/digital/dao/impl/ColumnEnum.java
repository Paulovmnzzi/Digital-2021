package com.digital.dao.impl;

public enum ColumnEnum {

	TITULO("titulo"),
	CODIGO("codigo"),
	PRECIO("precio");
	
	private String column;
	
	private ColumnEnum(String column) {
		this.column = column;
	}
	
	public String getColumn() {
		return column;
	}
	
}
