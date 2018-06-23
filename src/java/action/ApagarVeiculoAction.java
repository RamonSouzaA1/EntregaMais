package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import State.Veiculo;
import persistence.VeiculoDAO;

/**
 *
 * @author victor.domingos
 */
public class ApagarVeiculoAction implements Action {

    public ApagarVeiculoAction() {
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
            Veiculo veiculo = new Veiculo(Integer.parseInt(id));
            try {
                VeiculoDAO.getInstance().delete(veiculo);
                response.sendRedirect("sucesso.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }
    }
}
