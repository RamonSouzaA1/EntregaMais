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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Item;
import model.Pedido;
import persistence.ClienteDAO;
import persistence.PedidoDAO;

/**
 *
 * @author victor.domingos
 */
public class GravarPedidoAction implements Action {

    public GravarPedidoAction() {

    }

    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String hora = request.getParameter("txtHora");
        String dataPedido = request.getParameter("txtDataPedido");
        
        String chkbacon = String.valueOf(request.getParameter("bacon"));
        String chktomate = String.valueOf(request.getParameter("tomate"));
        String chkpeperone = String.valueOf(request.getParameter("peperone"));

        boolean bacon = !chkbacon.equals("null");
        boolean tomate = !chktomate.equals("null");
        boolean peperone = !chkpeperone.equals("null");

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");

        if (hora.equals("") || nome.equals("")) {
            response.sendRedirect("erro.jsp");
        } else {
            try {
                Pedido pedido = new Pedido();

                if (bacon) {
                    pedido.adicionarItem(new Item("bacon"));
                }
                if (tomate) {
                    pedido.adicionarItem(new Item("tomate"));
                }
                if (peperone) {
                    pedido.adicionarItem(new Item("peperone"));
                }

                pedido.fechar();
                pedido.setDataPedido(dataPedido);
                pedido.setHora(hora);
                
                PedidoDAO.getInstance().savePedido(pedido);
                // Mantem o cliente logado na pagina
                Cliente clienteLogado = ClienteDAO.getInstance().obterCliente(idCliente);
                request.setAttribute("cliente", clienteLogado);

                RequestDispatcher view = request.getRequestDispatcher("sucesso.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
