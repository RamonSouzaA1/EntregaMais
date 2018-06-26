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
import model.Pizza;
import persistence.ClienteDAO;
import persistence.PizzaDAO;

public class PrepararAdicionarPedidoAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                // Mantem o cliente logado na pagina
                Cliente cliente = ClienteDAO.getInstance().obterCliente(idCliente);
                request.setAttribute("cliente", cliente);

                List<Pizza> pizzas = PizzaDAO.getInstance().obterPizzas();
                request.setAttribute("pizzas", pizzas);
                
                RequestDispatcher view = request.getRequestDispatcher("pedidoAdicionar.jsp");
                view.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PrepararEditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(PrepararEditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
