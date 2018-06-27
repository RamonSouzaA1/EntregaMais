package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Encomenda;
import persistence.EncomendaDAO;

public class ApagarEncomendaAction implements Action{
    
    public ApagarEncomendaAction(){
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("textId");
        if (id.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            Encomenda encomenda = new Encomenda(Integer.parseInt(id));
            try {
                EncomendaDAO.getInstance().delete(encomenda);
                response.sendRedirect("sucessoCadastroCliente.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }
    }
}
