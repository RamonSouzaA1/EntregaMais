/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ramon
 */
public class RolTarefas {
    private static RolTarefas rolTarefas = new RolTarefas();
    private FuncaoDescascarAlimento funcaoDescascarAlimento;
    private FuncaoAjudarPreparoAlimento funcaoAjudarPreparoAlimento;
    private FuncaoFinalizarAlimento funcaoFinalizarAlimento;

    public FuncaoFinalizarAlimento getFuncaoProjetar() {
        return funcaoFinalizarAlimento;
    }

    public void setFuncaoProjetar(FuncaoFinalizarAlimento funcaoFinalizarAlimento) {
        this.funcaoFinalizarAlimento = funcaoFinalizarAlimento;
    }
    
    public static RolTarefas getInstance() {
        return rolTarefas;
    }

    public static void setRolTarefas(RolTarefas rolTarefas) {
        RolTarefas.rolTarefas = rolTarefas;
    }

    public FuncaoDescascarAlimento getFuncaoEntregar() {
        return funcaoDescascarAlimento;
    }

    public void setFuncaoEntregar(FuncaoDescascarAlimento funcaoDescascarAlimento) {
        this.funcaoDescascarAlimento = funcaoDescascarAlimento;
    }

    public FuncaoAjudarPreparoAlimento getFuncaoMontar() {
        return funcaoAjudarPreparoAlimento;
    }

    public void setFuncaoMontar(FuncaoAjudarPreparoAlimento funcaoAjudarPreparoAlimento) {
        this.funcaoAjudarPreparoAlimento = funcaoAjudarPreparoAlimento;
    }

    public RolTarefas() {
        this.funcaoDescascarAlimento = new FuncaoDescascarAlimento();
        this.funcaoAjudarPreparoAlimento = new FuncaoAjudarPreparoAlimento();
        this.funcaoFinalizarAlimento = new FuncaoFinalizarAlimento();
    }
    
    
    
}
