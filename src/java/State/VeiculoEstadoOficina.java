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
public class VeiculoEstadoOficina implements VeiculoEstado {

    @Override
    public String getEstado() {
        return "Oficina";
    }

    @Override
    public String disponivel(Veiculo v) {
        v.setEstado(new VeiculoEstadoDisponivel());
        return "Veiculo está disponível.";
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
        v.setEstado(new VeiculoEstadoEmDesuso());
        return "Veiculo está em desuso.";
    }

}
