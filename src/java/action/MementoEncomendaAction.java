/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteCNPJ;
import model.Encomenda;
import model.Entregador;
import State.Veiculo;
import persistence.ClienteCnpjDAO;
import persistence.ClienteDAO;
import persistence.EncomendaDAO;
import persistence.EntregadorDAO;
import persistence.VeiculoDAO;

/**
 *
 * @author Ramon
 */
public class MementoEncomendaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("encomendaId"));

        EncomendaDAO encomendaDAO = new EncomendaDAO();
        Encomenda encomenda = new Encomenda();

        try {
            encomenda = encomendaDAO.obterEncomenda(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MementoEncomendaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MementoEncomendaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        String arrayMemento[] = encomenda.getMemento().split(" -> ");
        String situacao = "";
        String newMemento = "";

        if (arrayMemento.length == 1) {
            response.sendRedirect("index.jsp");
        } else {
            if (arrayMemento.length == 2) {
                situacao = arrayMemento[0];
                newMemento = situacao;
            }

            if (arrayMemento.length > 2) {
                situacao = arrayMemento[arrayMemento.length - 2];
                newMemento = arrayMemento[0];
                for (int i = 1; i < arrayMemento.length - 1; i++) {
                    newMemento = newMemento + " -> " + arrayMemento[i];
                }
            }

            try {
                encomendaDAO.editar(encomenda, encomenda.getDescricao(), encomenda.getPeso(), encomenda.getId_cliente(),
                        encomenda.getLogradouro(), encomenda.getNumero(), encomenda.getValor(), encomenda.getBairro(),
                        encomenda.getCep(), encomenda.getId_entregador(), situacao, encomenda.getData_pedido(),
                        encomenda.getData_entrega(), newMemento);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MementoEncomendaAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect("sucessoCadastroCliente.jsp");
        }
    }
}
