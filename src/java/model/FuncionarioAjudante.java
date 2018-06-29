/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class FuncionarioAjudante extends FuncionarioCozinha{
    private List<Entregador> entregadores;

    public List<Entregador> getEntregadores() {
        return entregadores;
    }

    public void setEntregadores(List<Entregador> entregadores) {
        this.entregadores = entregadores;
    }
    
    
    public FuncionarioAjudante(FuncionarioCozinha proximoFuncionario){
        listaFuncao.add(RolTarefas.getInstance().getFuncaoEntregar());
        this.setProximoFuncionario(proximoFuncionario);
        this.descricaoCargo = this.getDescricaoCargo();
    }

    @Override
    public String getDescricaoCargo() {
        return "Ajuda o chefe no preparo dos alimentos.";
    }
}
