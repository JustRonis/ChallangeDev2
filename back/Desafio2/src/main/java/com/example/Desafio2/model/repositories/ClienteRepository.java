package com.example.Desafio2.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Desafio2.model.entities.Cliente;
  
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
