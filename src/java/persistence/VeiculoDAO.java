/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;

/**
 *
 * @author Ramon
 */
public class VeiculoDAO {

    private static VeiculoDAO instance = new VeiculoDAO();

    public VeiculoDAO() {
    }

    public static VeiculoDAO getInstance() {
        return instance;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }

    public void save(Veiculo veiculo) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO veiculo (id, placa, marca, modelo, situacao)"
                    + " VALUES ('" + veiculo.getId() + "', '" + veiculo.getPlaca() + "', '" + veiculo.getMarca() + "', '"
                    + veiculo.getModelo() + "', '" + veiculo.estado.getEstado() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Veiculo> obterVeiculos() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM veiculo");
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("placa"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("situacao"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return veiculos;
    }

    public void delete(Veiculo veiculo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM veiculo WHERE id = " + veiculo.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Veiculo obterVeiculo(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Veiculo veiculo = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from veiculo where id = " + id);
            rs.first();
            veiculo = new Veiculo(rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("situacao"));

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return veiculo;
    }

    public void editar(Veiculo veiculo, String placa, String marca, String modelo, String situacao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE veiculo SET placa = ?, marca = ?, modelo = ?,situacao = ?  WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            situacao = veiculo.mudarEstado(veiculo, situacao); // bloquear mudança de estado indevida
            comando.setString(1, placa);
            comando.setString(2, marca);
            comando.setString(3, modelo);
            comando.setString(4, situacao);
            comando.setInt(5, veiculo.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

}
