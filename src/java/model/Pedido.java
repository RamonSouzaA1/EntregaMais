/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import padraoDecorator.Coquetel;

/**
 *
 * @author victor.domingos
 */
public class Pedido {

    int id;
    String dataPedido;
    float valorPedido;
    String hora;
    String drink;
    Coquetel meuCoquetel;
    private float massaPizza = 2;

    List<Item> itens;

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void fechar() {
        this.setValorPedido(massaPizza);
        for (Item item : itens) {
            this.setValorPedido(valorPedido + item.getValor());
        }
    }
    
    public float getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(float valorPedido) {
        this.valorPedido = valorPedido;
    }
    
    public Coquetel getMeuCoquetel() {
        return meuCoquetel;
    }

    public void setMeuCoquetel(Coquetel meuCoquetel) {
        this.meuCoquetel = meuCoquetel;
    }
    
    

    public Pedido(int id, String dataPedido, float valorPedido, String hora) {
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

    public Pedido(String hora, String dataPedido, float valorPedido) {
        this.hora = hora;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        
    }

    public Pedido(int id, String dataPedido, float valorPedido, String hora, String drink) {
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
