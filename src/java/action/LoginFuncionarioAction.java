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

public class LoginFuncionarioAction implements Action{
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        // Pega o campo txtNome da tela de login
        String nome = request.getParameter("txtNome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                // Crio o arraylist de clientes e o objeto cliente
                List<Funcionario> funcionarios = FuncionarioDAO.getInstance().obterFuncionarios();
                Funcionario funcionario = new Funcionario();
                int id;

                // percorre o arraylist de clientes procurando pelo nome
                for (int i = 0; i < funcionarios.size(); i++) {
                    // encontrando o nome, salva o id e busca o cliente pelo id
                    if (funcionarios.get(i).getNome().equals(nome)) {
                        id = funcionarios.get(i).getId();
                        funcionario = FuncionarioDAO.getInstance().obterFuncionario(id);
                    }
                }
                if (funcionario != null) {
                    // se encontrado o cliente, ele vai ser dispachado para a tela seguinte no objeto cliente
                    request.setAttribute("funcionario", funcionario);
                    RequestDispatcher view = request.getRequestDispatcher("funcionarioLogadoMenu.jsp");
                    view.forward(request, response);
                } else {
                    response.sendRedirect("erro.jsp");
                }
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LoginClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}