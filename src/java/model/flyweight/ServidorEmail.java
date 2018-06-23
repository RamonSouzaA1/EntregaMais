/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.flyweight;

import model.Cliente;

/**
 *
 * @author rwspa
 */
public class ServidorEmail {

    public String Anuncia(String conteudo, Cliente cliente) {
        FlyweightFactory factory = new FlyweightFactory();
        return factory.getFlyweight(factory.selecionaConteudo(conteudo)).enviarMensagem(new Destinatario(cliente.getNome(), cliente.getCelular()));
    }

}
