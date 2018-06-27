/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ramon
 */
public class ClienteCNPJ extends BaseCliente implements Frete{
    
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public ClienteCNPJ() {
    }

    public ClienteCNPJ(int id) {
        this.id = id;
    }

    public ClienteCNPJ(int id, String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.cnpj = cnpj;
    }

    public ClienteCNPJ(String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String cnpj) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.cnpj = cnpj;
    }
    
    @Override
    public int obterDesconto() {
        return 20;
    }

    @Override
    public double obterCalculoFrete(int peso) {
        double valor = 7.50 + (3.00 * peso);
        
        return valor + (valor*(this.obterDesconto()/100));
    }
    
}
