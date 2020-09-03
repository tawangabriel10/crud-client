package br.com.crud.web.repository.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crud.web.domain.dto.PhoneDTO;
import br.com.crud.web.domain.entity.Phone;

@Component
public class PhoneMapper {

	public PhoneDTO toDTO(Phone phone) {
		if (phone != null) {
			PhoneDTO dto = new PhoneDTO();
			dto.setId(phone.getId());
			dto.setType(phone.getType());
			dto.setNumber(phone.getNumber());
			return dto;
		}
		return null;
	}
	
	public Phone toEntity(PhoneDTO dto) {
		if (dto != null) {
			Phone entity = new Phone();
			entity.setId(dto.getId());
			entity.setType(dto.getType());
			entity.setNumber(dto.getNumber());
			return entity;
		}
		return null;
	}
	
	public List<PhoneDTO> toListDTO(List<Phone> list) {
		if (list != null) {
			return list.stream().map(this::toDTO)
						.collect(Collectors.toList());
		}
		return null;
	}
	
	public List<Phone> toListEntity(List<PhoneDTO> listDTO) {
		if (listDTO != null) {
			return listDTO.stream().map(this::toEntity)
						.collect(Collectors.toList());
		}
		return null;
	}
}
