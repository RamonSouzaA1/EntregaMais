/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author victor.domingos
 */
public class EditarClienteAction implements Action {

    public EditarClienteAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("txtNome");
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String telefone = request.getParameter("txtTelefone");
        String celular = request.getParameter("txtCelular");
        String doc = request.getParameter("txtDoc");
        if (nome.equals("") || logradouro.equals((""))) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = new Cliente();
                cliente = clienteDAO.obterCliente(id);
                clienteDAO.editar(cliente, nome, logradouro, numero, bairro, cep, telefone, celular, doc);
                
                // Mantem o cliente logado na pagina
                Cliente clienteLogado = ClienteDAO.getInstance().obterCliente(id);
                request.setAttribute("cliente", clienteLogado);
                
                RequestDispatcher view = request.getRequestDispatcher("sucesso.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
