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
public class GravarPedidoAction  implements Action {

    public GravarPedidoAction() {
    
    }
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        String hora = request.getParameter("txtHora");
        String dataPedido = request.getParameter("txtDataPedido");
        
        boolean bacon = request.getParameter("bacon");
        boolean tomate = request.getParameter("tomate");
        boolean peperone = request.getParameter("peperone");
        
        Float valorPedido;
        if(hora.equals("")){
            response.sendRedirect("index.jsp");
        } else{
            try{
                Pedido pedido = new Pedido();
                
                if(bacon)
                    pedido.adicionarItem(new Item("bacon"));
                if(tomate)
                    pedido.adicionarItem(new Item("tomate"));
                if(peperone)
                    pedido.adicionarItem(new Item("peperone"));
                
                pedido.fechar();
                pedido.setDataPedido(dataPedido);
                pedido.setHora(hora);
                
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