package com.vitorlucas.firstbootcampjob.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlucas.firstbootcampjob.entities.Client;
import com.vitorlucas.firstbootcampjob.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	
	public List<Client> findAll(){
		return repository.findAll();
	}
}
