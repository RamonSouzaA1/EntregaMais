/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author victor.domingos
 */
public class EditarPedidoAction implements Action {

    public EditarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String dataPedido = request.getParameter("txtDataPedido");
        
        boolean bacon = request.getParameter("bacon");
        boolean tomate = request.getParameter("tomate");
        boolean peperone = request.getParameter("peperone");
        
        Float valorPedido;
        String hora = request.getParameter("txtHora");

        if (dataPedido.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = new Pedido();
                
                if(bacon)
                    pedido.adicionarItem(new Item("bacon"));
                if(tomate)
                    pedido.adicionarItem(new Item("tomate"));
                if(peperone)
                    pedido.adicionarItem(new Item("peperone"));
                
                pedido.fechar();
                
                pedido = pedidoDAO.obterPedido(id);
                pedidoDAO.editar(pedido, dataPedido, pedido.getValorPedido(), hora);
                response.sendRedirect("sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}

