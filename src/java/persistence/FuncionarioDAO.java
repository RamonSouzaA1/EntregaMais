/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author victor.domingos
 */
public class FuncionarioDAO {

    private static FuncionarioDAO instance = new FuncionarioDAO();

    public FuncionarioDAO() {
    }

    public static FuncionarioDAO getInstance() {
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

    public void save(Funcionario funcionario) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute("insert into funcionario (nome, logradouro, numero, bairro, cep, telefone, celular, cpf)"
                    + " values ('" + funcionario.getNome() + "', '" + funcionario.getLogradouro() + "', " + funcionario.getNumero() + ", '" + funcionario.getBairro() + "',"
                    + " '" + funcionario.getCep() + "', '" + funcionario.getTelefone() + "', '" + funcionario.getCelular() + "', '" + funcionario.getCpf() + "')");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM funcionario");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("logradouro"), rs.getInt("numero"),
                        rs.getString("bairro"), rs.getString("cep"), rs.getString("telefone"), rs.getString("celular"),
                        rs.getString("cpf"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return funcionarios;
    }

    public void delete(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM funcionario WHERE id = " + funcionario.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Funcionario obterFuncionario(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Funcionario funcionario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from funcionario where id = " + id);
            rs.first();
            funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("logradouro"), rs.getInt("numero"),
                    rs.getString("bairro"), rs.getString("cep"), rs.getString("telefone"), rs.getString("celular"),
                    rs.getString("cpf"));

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return funcionario;
    }

    public void editar(Funcionario funcionario, String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String cpf) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE funcionario SET nome = ?, logradouro = ?, numero = ?, bairro = ?, cep = ?, telefone = ?, celular = ?, cpf = ? WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setString(2, logradouro);
            comando.setInt(3, numero);
            comando.setString(4, bairro);
            comando.setString(5, cep);
            comando.setString(6, telefone);
            comando.setString(7, celular);
            comando.setString(8, cpf);
            comando.setInt(9, funcionario.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

}
