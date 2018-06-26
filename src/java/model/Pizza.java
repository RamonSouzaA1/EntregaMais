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
public class Pizza {
    int id;
    String nome;
    String ingrediente;
    double precoMedia;
    double precoFamilia;

    public Pizza() {
    }

    public Pizza(int id) {
        this.id = id;
    }

    public Pizza(int id, String nome, String ingrediente, double precoMedia, double precoFamilia) {
        this.id = id;
        this.nome = nome;
        this.ingrediente = ingrediente;
        this.precoMedia = precoMedia;
        this.precoFamilia = precoFamilia;
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

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getPrecoMedia() {
        return precoMedia;
    }

    public void setPrecoMedia(double precoMedia) {
        this.precoMedia = precoMedia;
    }

    public double getPrecoFamilia() {
        return precoFamilia;
    }

    public void setPrecoFamilia(double precoFamilia) {
        this.precoFamilia = precoFamilia;
    }
    
    
}
