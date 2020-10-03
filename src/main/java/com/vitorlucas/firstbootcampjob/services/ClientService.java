package com.vitorlucas.firstbootcampjob.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.firstbootcampjob.dto.ClientDTO;
import com.vitorlucas.firstbootcampjob.entities.Client;
import com.vitorlucas.firstbootcampjob.repositories.ClientRepository;
import com.vitorlucas.firstbootcampjob.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequet){
		Page<Client> list = repository.findAll(pageRequet);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional <Client> cli = repository.findById(id);
		Client entity = cli.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO cliDTO) {
		Client cli = new Client();
		copyEntity(cliDTO, cli);
		cli = repository.save(cli);
		return new ClientDTO(cli);
	}
	
	public void copyEntity(ClientDTO cliDTO, Client cli) {
		cli.setName(cliDTO.getName());
		cli.setCpf(cliDTO.getCpf());
		cli.setBirthDate(cliDTO.getBirthDate());
		cli.setChildren(cliDTO.getChildren());
		cli.setIncome(cliDTO.getIncome());
	}
}
