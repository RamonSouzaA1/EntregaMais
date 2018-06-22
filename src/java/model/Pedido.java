/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author victor.domingos
 */
public class Pedido {

    int id;
    String dataPedido;
    float valorPedido;
    String hora;

    private float massaPizza = 2;
    
    List<Item> itens;
    
    Pedido com(int quantidade, String nome) {
	itens.add(new Item(nome, quantidade));
	return this;
    }
    
    void fechar() {
        this.setValorPedido(massaPizza);
        for(Item item : itens){
            this.setValorPedido(valorPedido+(item.getQtd()*retornaPrecos(item.getOp())));
        }
    }
    
    private float retornaPrecos(String produto){
        switch(produto){
            case "bacon":
                return 2;
            case "tomate":
                return (float) 1.5;
            default:
                return 1;
        }
    }
    
    public Pedido(int id, String dataPedido, float valorPedido, String hora) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.hora = hora;
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

    public float getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(float valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
