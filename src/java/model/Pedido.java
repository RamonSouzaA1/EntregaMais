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
public class Pedido {

    int id;
    String dataPedido;
    String valorPedido;
    String hora;

    public Pedido(int id, String dataPedido, String valorPedido, String hora) {
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

    public Pedido(String dataPedido, String valorPedido, String hora) {
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.hora = hora;
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
