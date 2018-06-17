/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ramon
 * 
 * Construtor vazio, somente com id e com todos os atributos.
 * Todos os getters e setters implementados
 * 
 */
public class Cliente extends BaseCliente{
    
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String cpf) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.cpf = cpf;
    }

    public Cliente(String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String cpf) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.cpf = cpf;
    }
}
