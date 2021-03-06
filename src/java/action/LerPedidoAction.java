/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;
import persistence.ClienteDAO;
import persistence.PedidoDAO;

/**
 *
 * @author victor.domingos
 */
public class LerPedidoAction implements Action {

    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                // Mantem o cliente logado na pagina
                Cliente cliente = ClienteDAO.getInstance().obterCliente(idCliente);
                request.setAttribute("cliente", cliente);
                
                List<Pedido> pedidos = new ArrayList<Pedido>();
                pedidos = PedidoDAO.getInstance().obterPedidos();
                request.setAttribute("pedidos", pedidos);
                RequestDispatcher view = request.getRequestDispatcher("pedidoConsulta.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
