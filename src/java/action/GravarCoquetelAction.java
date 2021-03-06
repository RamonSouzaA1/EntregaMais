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
import model.Pedido;
import persistence.ClienteDAO;
import persistence.CoquetelDAO;
import persistence.PedidoDAO;

/**
 *
 * @author victor.domingos
 */
public class GravarCoquetelAction  implements Action {

    public GravarCoquetelAction() {
    
    }
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        String hora = request.getParameter("txtHora");
        String dataPedido = request.getParameter("txtDataPedido");
        float valorPedido = Float.parseFloat(request.getParameter("txtNumero")); 
        int numero = Integer.parseInt(request.getParameter("txtNumero"));  
        if(hora.equals("") || nome.equals("")){
            response.sendRedirect("index.jsp");
        } else{
            try{
                // Mantem o cliente logado na pagina
                Cliente clienteLogado = ClienteDAO.getInstance().obterCliente(idCliente);
                request.setAttribute("cliente", clienteLogado);
                
                Pedido pedido = new Pedido(hora, dataPedido, valorPedido);
                CoquetelDAO.getInstance().save(pedido, numero);
                
                RequestDispatcher view = request.getRequestDispatcher("sucesso.jsp");
                view.forward(request, response);
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }   catch (ServletException ex) {
                Logger.getLogger(GravarCoquetelAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}