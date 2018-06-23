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
import model.Funcionario;
import persistence.FuncionarioDAO;

/**
 *
 * @author victor.domingos
 */
public class ApagarFuncionarioAction implements Action {

    public ApagarFuncionarioAction() {
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
            Funcionario funcionario = new Funcionario(Integer.parseInt(id));
            try {
                FuncionarioDAO.getInstance().delete(funcionario);
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
