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
import model.ClienteCNPJ;

/**
 *
 * @author Ramon
 */
public class ClienteCnpjDAO {
    private static ClienteCnpjDAO instance = new ClienteCnpjDAO();
    
    public ClienteCnpjDAO(){
    }
    
    public static ClienteCnpjDAO getInstance(){
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
    
    
    public void save(ClienteCNPJ cliente) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into clientecnpj (nome, logradouro, numero, bairro, cep, telefone, celular, cnpj)"
                    + " values ('" + cliente.getNome() + "', '"+ cliente.getLogradouro() +"', "+ cliente.getNumero() +", '"+ cliente.getBairro() +"',"
                    + " '"+ cliente.getCep() +"', '"+ cliente.getTelefone() +"', '"+ cliente.getCelular() +"', '"+ cliente.getCnpj() +"')");
                        
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }  
    
    public List<ClienteCNPJ> obterClientes() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        List<ClienteCNPJ> clientes = new ArrayList<ClienteCNPJ>();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            ResultSet rs = st.executeQuery("SELECT * FROM clientecnpj");
            while (rs.next()){
                ClienteCNPJ cliente = new ClienteCNPJ
                                    (rs.getInt("id"), rs.getString("nome"), rs.getString("logradouro"), rs.getInt("numero"),
                                    rs.getString("bairro"), rs.getString("cep"), rs.getString("telefone"),rs.getString("celular"),
                                    rs.getString("cnpj"));
                clientes.add(cliente);
            }
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return clientes;
    }
    
    public void delete(ClienteCNPJ cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM clientecnpj WHERE id = " + cliente.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public ClienteCNPJ obterCliente(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ClienteCNPJ cliente = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from clientecnpj where id = " + id);
            rs.first();
            cliente = new ClienteCNPJ
                          (rs.getInt("id"), rs.getString("nome"), rs.getString("logradouro"), rs.getInt("numero"),
                            rs.getString("bairro"), rs.getString("cep"), rs.getString("telefone"),rs.getString("celular"),
                            rs.getString("cnpj"));
            
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }
    
    public void editar(ClienteCNPJ cliente, String nome, String logradouro, int numero, String bairro, String cep, String telefone, String celular, String doc) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE clientecnpj SET nome = ?, logradouro = ?, numero = ?, bairro = ?, cep = ?, telefone = ?, celular = ?, cnpj = ? WHERE id = ?";
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
