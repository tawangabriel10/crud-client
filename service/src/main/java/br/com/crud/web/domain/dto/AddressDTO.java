package br.com.crud.web.domain.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = -7805561786425130852L;
	
	private Long id;
	
	private String cep;
	
	private String address;
	
	private String number;
	
	private String complement;
	
	private String burgh;
	
	private String city;
	
	private String uf;
	
}
