/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.flyweight;

/**
 *
 * @author rwspa
 */
class Contato {

    protected String conteudo;

    public Contato(String contato) {
        this.conteudo = contato;
    }

    public String enviarMensagem() {
        return conteudo + "!";
    }
}
