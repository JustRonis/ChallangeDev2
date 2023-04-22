package com.example.Desafio2.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "clientes")
public class Cliente {
    private String nome;
    private String telefone;
    private String cpf;
    private int idPedido;
    private String chavePix;
    private String numeroConta;
    private String agencia;
    private String banco;
    private boolean reembolsado;

    public Cliente(String nome, String telefone, String cpf, int idPedido, String chavePix, String numeroConta, String agencia, String banco, boolean reembolsado) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.idPedido = idPedido;
        this.chavePix = chavePix;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.banco = banco;
        this.reembolsado = reembolsado;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getChavePix() {
        return this.chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


    public boolean getReembolsado() {
        return this.reembolsado;
    }

    public void setReembolsado(boolean reembolsado) {
        this.reembolsado = reembolsado;
    }
}