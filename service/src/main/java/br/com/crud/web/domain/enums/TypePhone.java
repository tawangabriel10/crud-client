package br.com.crud.web.domain.enums;

public enum TypePhone {

	RESIDENTIAL("Residencial"),
	COMERCIAL("Comercial"),
	CELL("Celular");
	
	private String name;
	
	TypePhone(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
