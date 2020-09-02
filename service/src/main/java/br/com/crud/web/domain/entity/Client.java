package br.com.crud.web.domain.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_client")
@Data
@NoArgsConstructor
public class Client implements Serializable {

	private static final long serialVersionUID = -3697077832894859668L;

	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "name")
	private String username;

	@Column(name = "name")
	private String password;
	
	@OneToMany(orphanRemoval = true, mappedBy = "client")
	private Set<Email> emails;
	
	@OneToOne
	@JoinColumn(name = "id_address")
	private Address address;
	
	@OneToMany(orphanRemoval = true, mappedBy = "client")
	private List<Phone> phones;
}
