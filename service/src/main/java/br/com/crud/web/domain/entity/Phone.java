package br.com.crud.web.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.crud.web.domain.enums.TypePhone;
import lombok.Data;

@Entity
@Table(name = "tb_phone")
@Data
public class Phone implements Serializable {

	private static final long serialVersionUID = -4236244026847674028L;

	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TypePhone type;
	
	@Column(name = "number")
	private String number;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
}
