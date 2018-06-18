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
public class GravarPedidoAction  implements Action {

    public GravarPedidoAction() {
    
    }
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        String dataPedido = request.getParameter("txtDataPedido");
        String valorPedido = request.getParameter("txtValorPedido");
        String hora = request.getParameter("txtHora");
        if(dataPedido.equals("")){
            response.sendRedirect("index.jsp");
        } else{
            try{
                Pedido pedido = new Pedido(dataPedido, valorPedido, hora);
                PedidoDAO.getInstance().save(pedido);
                response.sendRedirect("sucesso.jsp");
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        }
    }
}