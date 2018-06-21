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
import State.Veiculo;
import persistence.VeiculoDAO;

/**
 *
 * @author victor.domingos
 */
public class EditarVeiculoAction implements Action {

    public EditarVeiculoAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String placa = request.getParameter("txtPlaca");
        String marca = request.getParameter("txtMarca");
        String modelo = request.getParameter("txtModelo");
        String situacao = request.getParameter("txtSituacao");
        if (placa.equals("") || marca.equals((""))) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                VeiculoDAO veiculoDAO = new VeiculoDAO();
                Veiculo veiculo = new Veiculo();
                veiculo = veiculoDAO.obterVeiculo(id);
                //(situacao.equals(veiculo.estado.getEstado()) && !situacao.equals(veiculo.estado.getEstado()))

                switch (situacao) {
                    case "Disponível":
                        if (veiculo.estado.getEstado().equals("Disponível") || veiculo.estado.getEstado().equals("Em desuso")) {
                            response.sendRedirect("sucessoComRestricao.jsp");
                        } else {
                            veiculoDAO.editar(veiculo, placa, marca, modelo, situacao);

                            response.sendRedirect("sucesso.jsp");
                        }
                        break;
                    case "Em desuso":
                        if (veiculo.estado.getEstado().equals("Em desuso")) {
                            response.sendRedirect("sucessoComRestricao.jsp");
                        }                         
                        else {
                            veiculoDAO.editar(veiculo, placa, marca, modelo, situacao);
                            response.sendRedirect("sucesso.jsp");
                        }
                        break;
                    case "Em serviço":
                        if (veiculo.estado.getEstado().equals("Em serviço") || veiculo.estado.getEstado().equals("Em desuso") || veiculo.estado.getEstado().equals("Oficina")) {
                            response.sendRedirect("sucessoComRestricao.jsp");
                        } else {
                            veiculoDAO.editar(veiculo, placa, marca, modelo, situacao);
                            response.sendRedirect("sucesso.jsp");
                        }
                        break;
                    case "Oficina":

                        if (veiculo.estado.getEstado().equals("Oficina")|| veiculo.estado.getEstado().equals("Em desuso")) {
                            response.sendRedirect("sucessoComRestricao.jsp");
                        } else {
                            veiculoDAO.editar(veiculo, placa, marca, modelo, situacao);
                            response.sendRedirect("sucesso.jsp");
                        }

                        break;
                }

//                if (situacao.equals("Disponível")) {
//                    // veiculo.estado.getEstado().equals("Disponível")
//                    if (veiculo.estado.disponivel(veiculo).equals("Não é possível executar função.")) {
//                        response.sendRedirect("sucessoComRestricao.jsp");
//                    } else if (situacao.equals("Em desuso")) {
//                        //veiculo.estado.getEstado().equals("Em desuso")
//                        if (veiculo.estado.getEstado().equals("Em desuso")) {
//                            response.sendRedirect("sucessoComRestricao.jsp");
//                        }
//                    }
//                } else {
//                    response.sendRedirect("sucesso.jsp");
//                }
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}
