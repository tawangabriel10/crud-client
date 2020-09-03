package br.com.crud.web.repository.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crud.web.domain.dto.ClientDTO;
import br.com.crud.web.domain.entity.Client;

@Component
public class ClientMapper {
	
	private AddressMapper addressMapper;
	
	private PhoneMapper phoneMapper;
	
	private EmailMapper emailMapper;
	
	@Autowired
	public ClientMapper(AddressMapper addressMapper, PhoneMapper phoneMapper, EmailMapper emailMapper) {
		this.addressMapper = addressMapper;
		this.phoneMapper = phoneMapper;
		this.emailMapper = emailMapper;
	}

	public ClientDTO toDTO(Client client) {
		if (client != null) {	
			ClientDTO dto = new ClientDTO();
			dto.setId(client.getId());
			dto.setName(client.getName());
			dto.setCpf(client.getCpf());
			dto.setEmails(emailMapper.toListDTO(client.getEmails()));
			dto.setAddress(addressMapper.toDTO(client.getAddress()));
			dto.setPhones(phoneMapper.toListDTO(client.getPhones()));
			return dto;
		}
		return null;
	}
	
	public Client toEntity(ClientDTO dto) {
		if (dto != null) {
			Client client = new Client();
			client.setId(dto.getId());
			client.setName(dto.getName());
			client.setCpf(dto.getCpf());
			client.setEmails(emailMapper.toListEntity(dto.getEmails()));
			client.setAddress(addressMapper.toEntity(dto.getAddress()));
			client.setPhones(phoneMapper.toListEntity(dto.getPhones()));
			return client;
		}
		return null;
	}
}
