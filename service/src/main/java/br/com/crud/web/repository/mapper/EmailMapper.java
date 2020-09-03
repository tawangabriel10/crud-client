package br.com.crud.web.repository.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crud.web.domain.dto.EmailDTO;
import br.com.crud.web.domain.dto.PhoneDTO;
import br.com.crud.web.domain.entity.Email;
import br.com.crud.web.domain.entity.Phone;

@Component
public class EmailMapper {

	public EmailDTO toDTO(Email email) {
		if (email != null) {
			EmailDTO dto = new EmailDTO();
			dto.setId(email.getId());
			dto.setEmail(email.getEmail());
			return dto;
		}
		return null;
	}
	
	public Email toEntity(EmailDTO dto) {
		if (dto != null) {
			Email entity = new Email();
			entity.setId(dto.getId());
			entity.setEmail(dto.getEmail());
			return entity;
		}
		return null;
	}
	
	public List<EmailDTO> toListDTO(List<Email> list) {
		if (list != null) {
			return list.stream().map(this::toDTO)
						.collect(Collectors.toList());
		}
		return null;
	}
	
	public List<Email> toListEntity(List<EmailDTO> listDTO) {
		if (listDTO != null) {
			return listDTO.stream().map(this::toEntity)
						.collect(Collectors.toList());
		}
		return null;
	}
}
