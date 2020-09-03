package br.com.crud.web.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.crud.web.domain.dto.DataCepDTO;
import br.com.crud.web.domain.exception.BadRequestException;

@Service
public class ViaCepService {

	private final static String URL_API = "https://viacep.com.br/ws/%s/json/";
	
	public DataCepDTO findCep(String cep) throws BadRequestException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<DataCepDTO> response = restTemplate.getForEntity(String.format(URL_API, cep), DataCepDTO.class);
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody();
		}
		throw new BadRequestException("Erro ao consultar CEP.");
	}
}
