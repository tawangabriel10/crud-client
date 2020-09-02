package br.com.crud.web.domain.enums;

public enum Role {

	ADMIN("Admin"),
	COMUM("Comum");

	private String name;
	
	Role(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
