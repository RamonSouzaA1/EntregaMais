/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rwspa
 */
public class Item {

    private String op;
    private float valor;

    public Item() {

    }

    public Item(String op) {
        this.op = op;
        this.setValor(this.retornaPrecos(op));
    }

    /**
     * @return the op
     */
    public String getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(String op) {
        this.op = op;
    }

    private float retornaPrecos(String produto) {
        switch (produto) {
            case "bacon":
                return 2;
            case "tomate":
                return (float) 1.5;
            default:
                return 1;
        }
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
}