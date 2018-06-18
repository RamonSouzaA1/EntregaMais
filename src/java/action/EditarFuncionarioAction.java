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
public class EditarFuncionarioAction implements Action {

    public EditarFuncionarioAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String telefone = request.getParameter("txtTelefone");
        String celular = request.getParameter("txtCelular");
        String cpf = request.getParameter("txtCpf");
        if (nome.equals("") || logradouro.equals((""))) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionario = new Funcionario();
                funcionario = funcionarioDAO.obterFuncionario(id);
                funcionarioDAO.editar(funcionario, nome, logradouro, numero, bairro, cep, telefone, celular, cpf);
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
