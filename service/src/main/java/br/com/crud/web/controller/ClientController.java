package br.com.crud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.web.domain.dto.ClientDTO;
import br.com.crud.web.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
		
	}
}
