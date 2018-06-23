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
import model.Funcionario;
import persistence.FuncionarioDAO;

/**
 *
 * @author victor.domingos
 */
public class LerFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            funcionarios = FuncionarioDAO.getInstance().obterFuncionarios();
            request.setAttribute("funcionarios", funcionarios);
            RequestDispatcher view = request.getRequestDispatcher("funcionarioConsulta.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerFuncionarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
