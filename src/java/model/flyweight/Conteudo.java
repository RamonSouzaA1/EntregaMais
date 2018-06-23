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
class Conteudo extends ConteudoFlyweight {

    protected Contato contato;

    public Conteudo(String conteudoDoEmail) {
        this.contato = new Contato(conteudoDoEmail);
    }

    @Override
    public String enviarMensagem(Destinatario dest) {
        return contato.enviarMensagem() + "Para o destinatario (" + dest.nome + "," + dest.email + ")!";
    }

}
