package com.example.Desafio2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Desafio2.model.entities.Cliente;
import com.example.Desafio2.model.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public void atualizarReembolsado(String idPedido, boolean reembolsado) {
        Cliente cliente = clienteRepository.findByIdPedido(Integer.parseInt(idPedido))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        cliente.setReembolsado(reembolsado);
        clienteRepository.save(cliente);
    }
}

