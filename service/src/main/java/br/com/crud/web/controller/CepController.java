package br.com.crud.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.web.service.CepService;

@RestController
@RequestMapping("/api/cep")
public class CepController {

	private CepService cepService;
	
	public CepController(CepService cepService) {
		this.cepService = cepService;
	}
}
