package br.com.crud.web.domain.dto;

import java.io.Serializable;

import br.com.crud.web.domain.enums.TypePhone;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = -6453163567706565982L;

	private Long id;
	
	private TypePhone type;
	
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypePhone getType() {
		return type;
	}

	public void setType(TypePhone type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
