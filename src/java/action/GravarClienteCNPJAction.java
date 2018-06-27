package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteCNPJ;
import persistence.ClienteCnpjDAO;

public class GravarClienteCNPJAction implements Action {

    public GravarClienteCNPJAction() {
    
    }
    
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        String nome = request.getParameter("txtNome");
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String telefone = request.getParameter("txtTelefone");
        String celular = request.getParameter("txtCelular");
        String doc = request.getParameter("txtDoc");
        if(nome.equals("")){
            response.sendRedirect("index.jsp");
        } else{
            try{
                ClienteCNPJ cliente = new ClienteCNPJ(nome, logradouro, numero, bairro, cep, telefone, celular, doc);
                ClienteCnpjDAO.getInstance().save(cliente);
                response.sendRedirect("sucessoCadastroCliente.jsp");
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        }
    }
}
