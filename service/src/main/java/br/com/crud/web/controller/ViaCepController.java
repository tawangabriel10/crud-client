package br.com.crud.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.web.domain.dto.DataCepDTO;
import br.com.crud.web.domain.exception.BadRequestException;
import br.com.crud.web.service.ViaCepService;

@RestController
@RequestMapping("/api/cep")
public class ViaCepController {

	private ViaCepService viaCepService;
	
	public ViaCepController(ViaCepService viaCepService) {
		this.viaCepService = viaCepService;
	}
	
	@GetMapping("/:cep")
	public ResponseEntity<DataCepDTO> findByCep(@PathVariable("cep") String cep) throws BadRequestException {
		DataCepDTO data = viaCepService.findCep(cep);
		return ResponseEntity.ok(data);
	}
}
