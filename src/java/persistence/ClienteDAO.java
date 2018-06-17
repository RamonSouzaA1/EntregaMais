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
import model.Cliente;

/**
 *
 * @author Ramon
 */
public class ClienteDAO {
    private static ClienteDAO instance = new ClienteDAO();
    
    public ClienteDAO(){
    }
    
    public static ClienteDAO getInstance(){
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
    
    
    public void save(Cliente cliente) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into cliente (nome, logradouro, numero, bairro, cep, telefone, celular, cpf)"
                    + " values ('" + cliente.getNome() + "', '"+ cliente.getLogradouro() +"', "+ cliente.getNumero() +", '"+ cliente.getBairro() +"',"
                    + " '"+ cliente.getCep() +"', '"+ cliente.getTelefone() +"', '"+ cliente.getCelular() +"', '"+ cliente.getCpf()+"')");
                        
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }  
    
    public List<Cliente> obterClientes() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");
            while (rs.next()){
                Cliente cliente = new Cliente
                                    (rs.getInt("id"), rs.getString("nome"), rs.getString("logradouro"), rs.getInt("numero"),
                                    rs.getString("bairro"), rs.getString("cep"), rs.getString("telefone"),rs.getString("celular"),
                                    rs.getString("cpf"));
                clientes.add(cliente);
            }
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return clientes;
    }
    
    public void delete(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM cliente WHERE id = " + cliente.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public   Cliente obterCliente(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Cliente cliente = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente where id = " + id);
            rs.first();
            cliente = new Cliente
                          (rs.getInt("id"), rs.getString("nome"), rs.getString("logradouro"), rs.getInt("numero"),
                            rs.getString("bairro"), rs.getString("cep"), rs.getString("telefone"),rs.getString("celular"),
                            rs.getString("cpf"));
            
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }
    
    public void editar(Cliente cliente, String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String doc) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE cliente SET nome = ?, logradouro = ?, numero = ?, bairro = ?, cep = ?, telefone = ?, celular = ?, cpf = ? WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setString(2, logradouro);
            comando.setInt(3, numero);
            comando.setString(4, bairro);
            comando.setString(5, cep);
            comando.setString(6, telefone);
            comando.setString(7, celular);
            comando.setString(8, doc);
            comando.setInt(9, cliente.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
}
