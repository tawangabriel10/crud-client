package br.com.crud.web.domain.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmailDTO implements Serializable {

	private static final long serialVersionUID = 8936955120426118945L;

	private Long id;
	
	private String email;
	
}
