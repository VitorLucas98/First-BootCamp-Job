package com.vitorlucas.firstbootcampjob.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitorlucas.firstbootcampjob.entities.Client;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		Client cli1 = new Client(1L, "Vitor Lucas","066.369.785-96", 1200.00, Instant.now(), 2);
		Client cli2 = new Client(2L, "Luisa Guedes","125.375.063-24", 2500.00, Instant.now(), 2);
		list.addAll(Arrays.asList(cli1, cli2));
		return ResponseEntity.ok().body(list);
	}

}
