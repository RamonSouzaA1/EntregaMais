package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteCNPJ;
import model.Encomenda;
import model.Entregador;
import State.Veiculo;
import persistence.ClienteCnpjDAO;
import persistence.ClienteDAO;
import persistence.EncomendaDAO;
import persistence.EntregadorDAO;
import persistence.VeiculoDAO;

public class GravarEncomendaAction implements Action {

    public GravarEncomendaAction() {

    }

    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String descricao = request.getParameter("txtDescricao");
        int peso = Integer.parseInt(request.getParameter("txtPeso"));
        String tipoCliente = request.getParameter("tipoCliente");
        int id_cliente = Integer.parseInt(request.getParameter("txtId_cliente"));
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        int id_entregador = Integer.parseInt(request.getParameter("txtId_entregador"));
        String data_pedido = request.getParameter("txtData_pedido");
        String data_entrega = request.getParameter("txtData_entrega");
        double valor;

        if (descricao.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                if (tipoCliente.equals("CPF")) {
                    ClienteDAO clienteDAO = new ClienteDAO();
                    Cliente cliente = new Cliente();
                    cliente = clienteDAO.obterCliente(id_cliente);
                    valor = cliente.obterCalculoFrete(peso);
                } else {
                    ClienteCnpjDAO clienteDAO = new ClienteCnpjDAO();
                    ClienteCNPJ cliente = new ClienteCNPJ();
                    cliente = clienteDAO.obterCliente(id_cliente);
                    valor = cliente.obterCalculoFrete(peso);
                }
                
                //inicializa encomenda e calcula o valor <Strategy>
                Encomenda encomenda = new Encomenda(descricao, peso, id_cliente, logradouro, numero, valor, bairro,
                        cep, id_entregador, data_pedido, data_entrega);
                this.alocarEntregador(id_entregador);
                EncomendaDAO.getInstance().save(encomenda);
                this.alocarEntregador(id_entregador);
                
                response.sendRedirect("sucessoCadastroCliente.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void alocarEntregador(int id_entregador) throws ClassNotFoundException, SQLException
    {
        EntregadorDAO entregadorDAO = new EntregadorDAO();
        Entregador entregador = new Entregador();
        entregador = entregadorDAO.obterEntregador(id_entregador);
        if(entregador.getSituacao().equals("Disponível"))
        {
            entregadorDAO.editar(entregador, entregador.getNome(), "Em serviço", entregador.getId_veiculo());
        }
    }
    
    public void alocarVeiculo(int id_veiculo) throws ClassNotFoundException, SQLException
    {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = new Veiculo();
        veiculo = veiculoDAO.obterVeiculo(id_veiculo);
        if(veiculo.getEstado().equals("Disponível"))
        {
            veiculoDAO.editar(veiculo, veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo(), "Em serviço");
        }
    }
}
