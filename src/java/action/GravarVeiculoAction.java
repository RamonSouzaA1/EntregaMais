package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import State.Veiculo;
import persistence.VeiculoDAO;

/**
 *
 * @author victor.domingos
 */
public class GravarVeiculoAction implements Action {

    public GravarVeiculoAction() {

    }

    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String placa = request.getParameter("txtPlaca");
        String marca = request.getParameter("txtMarca");
        String modelo = request.getParameter("txtModelo");
        String nomeFuncionario = request.getParameter("txtNomeFuncionario");
        if (placa.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {

                Veiculo veiculo = new Veiculo(placa, marca, modelo);

                VeiculoDAO.getInstance().save(veiculo);
                response.sendRedirect("sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
