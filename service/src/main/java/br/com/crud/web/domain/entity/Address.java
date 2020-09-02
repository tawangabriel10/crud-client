package br.com.crud.web.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_address")
@Data
@NoArgsConstructor
public class Address implements Serializable {

	private static final long serialVersionUID = 3321755912273995671L;
	
	private Long id;
	
	@Column(name = "cep")
	private String cep;

	@Column(name = "address")
	private String address;

	@Column(name = "number")
	private String number;

	@Column(name = "complement")
	private String complement;

	@Column(name = "burgh")
	private String burgh;

	@Column(name = "city")
	private String city;

	@Column(name = "uf")
	private String uf;
	

}
