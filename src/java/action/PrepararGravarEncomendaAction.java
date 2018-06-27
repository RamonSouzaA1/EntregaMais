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
import model.Cliente;
import model.ClienteCNPJ;
import model.Entregador;
import State.Veiculo;
import persistence.ClienteCnpjDAO;
import persistence.ClienteDAO;
import persistence.EntregadorDAO;
import persistence.VeiculoDAO;

/**
 *
 * @author Ramon
 */
public class PrepararGravarEncomendaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String tipoCliente = request.getParameter("tipoCliente");
            List<Cliente> clientesCpf = new ArrayList<Cliente>();
            List<ClienteCNPJ> clientesCnpj = new ArrayList<ClienteCNPJ>();

            if (tipoCliente.equals("CPF")) {
                clientesCpf = ClienteDAO.getInstance().obterClientes();
                request.setAttribute("clientes", clientesCpf);
            } else {
                clientesCnpj = ClienteCnpjDAO.getInstance().obterClientes();
                request.setAttribute("clientes", clientesCnpj);
            }
            List<Entregador> entregadores = new ArrayList<Entregador>();
            entregadores = EntregadorDAO.getInstance().obterEntregadores();
            List<Entregador> entregadoresDisponiveis = new ArrayList<Entregador>();
            for (int i = 0; i < entregadores.size(); i++) {
                Entregador e = entregadores.get(i);
                if (e.getSituacao().equals("Disponível")) {
                    entregadoresDisponiveis.add(e);
                }
            }

            request.setAttribute("entregadores", entregadoresDisponiveis);
            request.setAttribute("tipoCliente", tipoCliente);
            RequestDispatcher view = request.getRequestDispatcher("/encomendaAdicionar.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
