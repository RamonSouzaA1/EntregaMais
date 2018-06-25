/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import padraoDecorator.Coquetel;

/**
 *
 * @author victor.domingos
 */
public class Pedido {

    int id;
    String dataPedido;
    String valorPedido;
    String hora;
    String drink;
    Coquetel meuCoquetel;

    public Coquetel getMeuCoquetel() {
        return meuCoquetel;
    }

    public void setMeuCoquetel(Coquetel meuCoquetel) {
        this.meuCoquetel = meuCoquetel;
    }
    
    

    public Pedido(int id, String dataPedido, String valorPedido, String hora) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.hora = hora;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(String hora, String dataPedido, String valorPedido) {
        this.hora = hora;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        
    }

    public Pedido(int id, String dataPedido, String valorPedido, String hora, String drink) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.hora = hora;
        this.drink = drink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(String valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
