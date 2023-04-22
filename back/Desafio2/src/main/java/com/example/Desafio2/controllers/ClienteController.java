package com.example.Desafio2.controllers;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Desafio2.model.entities.Cliente;
import com.example.Desafio2.model.repositories.ClienteRepository;
import com.example.Desafio2.model.repositories.Encrypt;

@RestController
public class ClienteController {
  @Autowired
  private ClienteRepository clienteRepository;

  @PostMapping("/api/cliente")
  public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) throws InvalidAlgorithmParameterException{

    Encrypt encrypt;

    String nome = cliente.getNome();
    String telefone = cliente.getTelefone();
    String cpf = cliente.getCpf();
    int idPedido = cliente.getIdPedido();
    String chavePix = cliente.getChavePix() != null ? cliente.getChavePix() : null;
    String numeroConta = cliente.getNumeroConta() != null ? cliente.getNumeroConta() : null;
    String agencia = cliente.getAgencia() != null ? cliente.getAgencia() : null;
    String banco = cliente.getBanco() != null ? cliente.getBanco() : null;
    boolean reembolsado = false;

    Cliente novoCliente = new Cliente(nome, telefone, cpf, idPedido, chavePix, numeroConta, agencia, banco, reembolsado);

    encrypt = new Encrypt(novoCliente);
    encrypt.converterCliente(true);

    Cliente salvarCliente = clienteRepository.save(encrypt.getCliente());
    return ResponseEntity.ok(salvarCliente);
  }

  @GetMapping("/api/cliente")
    public ResponseEntity<ArrayList<Cliente>> getAll() throws InvalidAlgorithmParameterException {
    ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteRepository.findAll();
    ArrayList clientesDescritografado = new ArrayList();
    Encrypt encrypt;        

    for (Cliente  cliente: clientes) {
      encrypt = new Encrypt(cliente);
      encrypt.converterCliente(false);
      clientesDescritografado.add(cliente);      
    }
    
    
    return ResponseEntity.ok(clientesDescritografado);
}
}



