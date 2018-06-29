/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Ramon
 */
public class FuncionarioEstagiario extends FuncionarioCozinha{
    private List<Estagiario> montadores;

    public List<Estagiario> getMontadores() {
        return montadores;
    }

    public void setMontadores(List<Estagiario> montadores) {
        this.montadores = montadores;
    }
    
    public FuncionarioEstagiario(FuncionarioCozinha proximoFuncionario){
        listaFuncao.add(RolTarefas.getInstance().getFuncaoDescascarAlimento());
        this.setProximoFuncionario(proximoFuncionario);
        this.descricaoCargo = this.getDescricaoCargo();
    }

    @Override
    public String getDescricaoCargo() {
        return "Descasca os alimentos.";
    }
}
