/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.flyweight;

import java.util.ArrayList;

/**
 *
 * @author rwspa
 */
public class FlyweightFactory {
    
    protected ArrayList<ConteudoFlyweight> flyweights;

        public Conteudos selecionaConteudo(String conteudo){
            if(conteudo=="promocao"){
                return Conteudos.PROMOCAO_CARDAPIO;
            }else{
                return Conteudos.CARDAPIO_SEMANA;
            }
        }
        
	public enum Conteudos {
		PROMOCAO_CARDAPIO, CARDAPIO_SEMANA
	}
        
        public FlyweightFactory() {
		flyweights = new ArrayList<ConteudoFlyweight>();
		flyweights.add(new Conteudo("Promoção no cardápio! Corre lá e confira!"));
		flyweights.add(new Conteudo("Saiu o cardápio da semana feito especialmente para os nossos clientes! Vá e confira"));
	}
        
        public ConteudoFlyweight getFlyweight(Conteudos conteudo) {
		switch (conteudo) {
		case PROMOCAO_CARDAPIO:
                    return flyweights.get(0);
		case CARDAPIO_SEMANA:
                    return flyweights.get(1);
                default:
                    return null;
		}
	}
}
