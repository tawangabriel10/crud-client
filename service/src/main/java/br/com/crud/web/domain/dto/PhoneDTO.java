package br.com.crud.web.domain.dto;

import java.io.Serializable;

import br.com.crud.web.domain.enums.TypePhone;
import lombok.Data;

@Data
public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = -6453163567706565982L;

	private Long id;
	
	private TypePhone type;
	
	private String number;
}
