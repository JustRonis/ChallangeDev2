package com.example.Desafio2.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Desafio2.model.entities.Cliente;  
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
