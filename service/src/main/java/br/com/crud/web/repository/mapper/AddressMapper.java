package br.com.crud.web.repository.mapper;

import org.springframework.stereotype.Component;

import br.com.crud.web.domain.dto.AddressDTO;
import br.com.crud.web.domain.entity.Address;

@Component
public class AddressMapper {
	
	public AddressDTO toDTO(Address entity) {
		if (entity != null) {
			AddressDTO dto = new AddressDTO();
			dto.setId(entity.getId());
			dto.setCep(entity.getCep());
			dto.setAddress(entity.getAddress());
			dto.setNumber(entity.getNumber());
			dto.setComplement(entity.getComplement());
			dto.setBurgh(entity.getBurgh());
			dto.setCity(entity.getCity());
			dto.setUf(entity.getUf());
			return dto;
		}
		return null;
	}
	
	public Address toEntity(AddressDTO dto) {
		if (dto != null) {
			Address entity = new Address();
			entity.setId(dto.getId());
			entity.setCep(dto.getCep());
			entity.setAddress(dto.getAddress());
			entity.setNumber(dto.getNumber());
			entity.setComplement(dto.getComplement());
			entity.setBurgh(dto.getBurgh());
			entity.setCity(dto.getCity());
			entity.setUf(dto.getUf());
			return entity;
		}
		return null;
	}
}
