package br.com.crud.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.crud.web.domain.dto.ClientDTO;
import br.com.crud.web.domain.entity.Client;
import br.com.crud.web.repository.ClientRepository;
import br.com.crud.web.repository.mapper.ClientMapper;

@Service
public class ClientService {

	private ClientRepository clientRepository;
	
	private ClientMapper clientMapper;
	
	@Autowired
	public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public ClientDTO save(ClientDTO clientDTO) {
		Client client = clientMapper.toEntity(clientDTO);
		return clientMapper.toDTO(clientRepository.save(client));
	}
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		return clientRepository.findAll()
				.stream().map(clientMapper::toDTO)
				.collect(Collectors.toList());
	}
}
