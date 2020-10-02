package com.vitorlucas.firstbootcampjob.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.firstbootcampjob.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
