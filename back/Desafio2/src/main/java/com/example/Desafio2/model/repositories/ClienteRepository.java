package com.example.Desafio2.model.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.Desafio2.model.entities.Cliente;  

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    @Query("{ 'idPedido' : ?0 }")
    Optional<Cliente> findByIdPedido(int idPedido);
}
