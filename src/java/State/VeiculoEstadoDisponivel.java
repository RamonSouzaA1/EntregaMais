/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import model.*;

/**
 *
 * @author victor.domingos
 */
public class VeiculoEstadoDisponivel implements VeiculoEstado {

    @Override
    public String getEstado() {
        return "Disponível";
    }

    @Override
    public String disponivel(Veiculo v) {
        return "Não é possível executar função.";
    }

    @Override
    public String emServico(Veiculo v) {
        v.setEstado(new VeiculoEstadoEmServico());
        return "Veículo está em serviço";
    }

    @Override
    public String oficina(Veiculo v) {
        v.setEstado(new VeiculoEstadoOficina());
        return "Veículo está na oficina";
    }

    @Override
    public String emDesuso(Veiculo v) {
        v.setEstado(new VeiculoEstadoEmDesuso());
        return "Veículo está em desuso";
    }

}
