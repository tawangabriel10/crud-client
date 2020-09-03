package br.com.crud.web.domain.dto;

import java.io.Serializable;
import java.util.List;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 8660132679124525925L;

	private Long id;
	
	private String name;

	private String cpf;

	private List<EmailDTO> emails;
	
	private AddressDTO address;
	
	private List<PhoneDTO> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<EmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

}
