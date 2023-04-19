package com.example.Desafio2.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Desafio2.model.entities.Cliente;

// @Repository
// public interface ClienteRepository {
//     public interface UserRepository extends MongoRepository<Cliente, Integer> {
    
    //     }
    
    public interface ClienteRepository extends MongoRepository<Cliente, String> {
        
        @Autowired
        public BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    
    public void salvarCliente(Cliente novoCliente);
   /* {
        String senhaCriptografada = passwordEncoder.encode(novoCliente.getSenha());
        novoCliente.setSenha(senhaCriptografada);
        clienteRepository.save(novoCliente);    
    }*/
    
}
