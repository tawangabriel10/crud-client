package br.com.crud.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		ClientDTO result = clientService.save(clientDTO);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> getAll() {
		List<ClientDTO> clients = clientService.findAll();
		return ResponseEntity.ok(clients);
	}
}
