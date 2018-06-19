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
import model.flyweight.ServidorEmail;
import persistence.ClienteDAO;

/**
 *
 * @author rwspa
 */
public class FlyWeigth  implements Action{
    
    
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
            try{
                List<Cliente> clientes = new ArrayList<Cliente>();
                clientes = ClienteDAO.getInstance().obterClientes();
                
                ServidorEmail serv = new ServidorEmail();
                
                for(Cliente cliente : clientes){
                    serv.Anuncia(conteudo, cliente);
                }
                
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
