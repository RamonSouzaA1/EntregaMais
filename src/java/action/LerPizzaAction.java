package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pizza;
import persistence.PizzaDAO;

public class LerPizzaAction implements Action{
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
            try{
                List<Pizza> pizzas = PizzaDAO.getInstance().obterPizzas();
                request.setAttribute("pizzas", pizzas);

                RequestDispatcher view = request.getRequestDispatcher("pizzaConsulta.jsp");
                view.forward(request, response);
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerVeiculoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
