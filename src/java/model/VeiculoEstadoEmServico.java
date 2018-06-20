/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victor.domingos
 */
public class VeiculoEstadoEmServico implements VeiculoEstado{

    @Override
    public String getEstado() {
        return "Em serviço";
    }

    @Override
    public String disponivel(Veiculo v) {
        v.setEstado(new VeiculoEstadoDisponivel());
        return "Veiculo está disponivel.";
    }

    @Override
    public String emServico(Veiculo v) {
        return "Não é possível executar função.";
        
    }

    @Override
    public String oficina(Veiculo v) {
        return "Não é possível executar função.";
        
    }

    @Override
    public String emDesuso(Veiculo v) {
        return "Não é possível executar função.";
        
    }
    
}
