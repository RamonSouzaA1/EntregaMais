package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pizza;
import persistence.ClienteDAO;
import persistence.PizzaDAO;

public class GravarPizzaAction implements Action {

    public GravarPizzaAction() {
    
    }
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        String nome = request.getParameter("txtNome");
        String ingrediente = request.getParameter("txtIngrediente");
        double precoMedia = Double.parseDouble(request.getParameter("txtPrecoMedia"));
        double precoFamilia = Double.parseDouble(request.getParameter("txtPrecoFamilia"));
        
        if(nome.equals("")){
            response.sendRedirect("index.jsp");
        } else{
            try{
                Pizza pizza = new Pizza(nome, ingrediente, precoMedia, precoFamilia);
                PizzaDAO.getInstance().save(pizza);
                response.sendRedirect("sucessoCadastroCliente.jsp");
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
