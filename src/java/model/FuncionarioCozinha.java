/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Ramon
 */
public abstract class FuncionarioCozinha {
    protected ArrayList listaFuncao = new ArrayList();
    private FuncionarioCozinha proximoFuncionario;
    public String tarefa;
    public String descricaoCargo;

    public ArrayList getListaFuncao() {
        return listaFuncao;
    }

    public void setListaFuncao(ArrayList listaFuncao) {
        this.listaFuncao = listaFuncao;
    }

    public FuncionarioCozinha getProximoFuncionario() {
        return proximoFuncionario;
    }

    public void setProximoFuncionario(FuncionarioCozinha proximoFuncionario) {
        this.proximoFuncionario = proximoFuncionario;
    }
    
    public abstract String getDescricaoCargo();
    
    public String realizaTarefa(Tarefa tarefa){
        if(this.listaFuncao.contains(tarefa.getFuncao())){
            return getDescricaoCargo();
        }
        else{
            if(this.proximoFuncionario != null)
                return this.proximoFuncionario.realizaTarefa(tarefa);
            else return "Sem mais etapas.";
        }
    }
}
