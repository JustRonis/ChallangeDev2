package com.example.Desafio2.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Desafio2.model.entities.Cliente;

// @Repository
// public interface ClienteRepository {
//     public interface UserRepository extends MongoRepository<Cliente, Integer> {

//     }
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
