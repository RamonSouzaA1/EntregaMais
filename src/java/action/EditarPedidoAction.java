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
        String valorPedido = request.getParameter("txtValorPedido");
        String hora = request.getParameter("txtHora");
        String drink = request.getParameter("txtDrink");

        if (dataPedido.equals("") || valorPedido.equals((""))) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = new Pedido();
                pedido = pedidoDAO.obterPedido(id);
                pedidoDAO.editar(pedido, dataPedido, valorPedido, hora, drink);
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

