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

    public FuncaoFinalizarAlimento getFuncaoFinalizarAlimento() {
        return funcaoFinalizarAlimento;
    }

    public void setFuncaoFinalizarAlimento(FuncaoFinalizarAlimento funcaoFinalizarAlimento) {
        this.funcaoFinalizarAlimento = funcaoFinalizarAlimento;
    }
    
    public static RolTarefas getInstance() {
        return rolTarefas;
    }

    public static void setRolTarefas(RolTarefas rolTarefas) {
        RolTarefas.rolTarefas = rolTarefas;
    }

    public FuncaoDescascarAlimento getFuncaoDescascarAlimento() {
        return funcaoDescascarAlimento;
    }

    public void setFuncaoDescascarAlimento(FuncaoDescascarAlimento funcaoDescascarAlimento) {
        this.funcaoDescascarAlimento = funcaoDescascarAlimento;
    }

    public FuncaoAjudarPreparoAlimento getFuncaoPreparoAlimento() {
        return funcaoAjudarPreparoAlimento;
    }

    public void setFuncaoPreparoAlimento(FuncaoAjudarPreparoAlimento funcaoAjudarPreparoAlimento) {
        this.funcaoAjudarPreparoAlimento = funcaoAjudarPreparoAlimento;
    }

    public RolTarefas() {
        this.funcaoDescascarAlimento = new FuncaoDescascarAlimento();
        this.funcaoAjudarPreparoAlimento = new FuncaoAjudarPreparoAlimento();
        this.funcaoFinalizarAlimento = new FuncaoFinalizarAlimento();
    }
    
    
    
}
