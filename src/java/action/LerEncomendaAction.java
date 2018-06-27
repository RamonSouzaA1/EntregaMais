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
import model.Encomenda;
import persistence.EncomendaDAO;

public class LerEncomendaAction implements Action{
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
            try{
                List<Encomenda> encomendas = new ArrayList<Encomenda>();
                encomendas = EncomendaDAO.getInstance().obterEncomendas();
                request.setAttribute("encomendas", encomendas);
                RequestDispatcher view = request.getRequestDispatcher("encomendaConsulta.jsp");
                view.forward(request, response);
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerEncomendaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
