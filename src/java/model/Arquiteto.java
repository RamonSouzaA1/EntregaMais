/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victor.domingos
 */
public class Arquiteto extends Situacao{
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Arquiteto() {
    }

    public Arquiteto(int id) {
        this.id = id;
    }

    public Arquiteto(String nome) {
        this.nome = nome;
        this.setSituacao("Disponível");
    }

    public Arquiteto(int id, String nome, String situacao) {
        this.id = id;
        this.nome = nome;
        this.setSituacao(situacao);
    }

    @Override
    public String getDados() {
        return this.getSituacao();
    }
}
