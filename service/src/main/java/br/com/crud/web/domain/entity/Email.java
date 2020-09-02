package br.com.crud.web.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_email")
@Data
public class Email implements Serializable {

	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
}
