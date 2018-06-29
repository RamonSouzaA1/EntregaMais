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
public class Estagiario extends Situacao{
    private int id;
    private String nome;
    private String refrigerante;



    public Estagiario(int id, String nome, String situacao, String refrigerante) {
        this.id = id;
        this.nome = nome;
        this.setSituacao(situacao);
        this.refrigerante = refrigerante;
    }

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

    public Estagiario() {
    }

    public Estagiario(int id) {
        this.id = id;
    }

    public Estagiario(String nome) {
        this.nome = nome;
        this.setSituacao("Disponível");
    }

    public Estagiario(int id, String nome, String situacao) {
        this.id = id;
        this.nome = nome;
        this.setSituacao(situacao);
    }

    @Override
    public String getDados() {
        return this.getSituacao();
    }
    
}
