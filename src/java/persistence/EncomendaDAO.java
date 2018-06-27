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
import model.Encomenda;

/**
 *
 * @author Ramon
 */
public class EncomendaDAO {
    private static EncomendaDAO instance = new EncomendaDAO();

    public  Encomenda obterEncomenda(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Encomenda encomenda = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from encomenda where id = " + id);
            rs.first();
            encomenda = new Encomenda
                          (rs.getInt("id"), rs.getString("descricao"), rs.getInt("peso"), rs.getInt("id_cliente"),
                                     rs.getString("logradouro"), rs.getInt("numero"), rs.getDouble("valor"), rs.getString("bairro"),
                                     rs.getString("cep"), rs.getInt("id_entregador"),  rs.getString("situacao"), rs.getString("data_pedido"), 
                                     rs.getString("data_entrega"), rs.getString("memento"));
            
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return encomenda;
    }

    public void editar(Encomenda encomenda, String descricao, int peso, int id_cliente, String logradouro, int numero, double valor, String bairro, String cep, int id_entregador, String situacao, String data_pedido, String data_entrega, String memento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE encomenda SET descricao = ?, peso = ?, id_cliente = ?, logradouro = ?, numero = ?, valor = ?, bairro = ?, cep = ?, id_entregador = ?, situacao = ?, data_pedido = ?, data_entrega = ?, memento = ? WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, descricao);
            comando.setInt(2, peso);
            comando.setInt(3, id_cliente);
            comando.setString(4, logradouro);
            comando.setInt(5, numero);
            comando.setDouble(6, valor);
            comando.setString(7, bairro);
            comando.setString(8, cep);
            comando.setInt(9, id_entregador);
            comando.setString(10, situacao);
            comando.setString(11, data_pedido);
            comando.setString(12, data_entrega);
            comando.setString(13, memento);
            comando.setInt(14, encomenda.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public EncomendaDAO(){
    }
    
    public static EncomendaDAO getInstance(){
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
    
    public void save(Encomenda encomenda) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO encomenda (id, descricao, peso, id_cliente, logradouro, numero, valor, bairro, cep, id_entregador, situacao, data_pedido, data_entrega, memento)"
                    + " VALUES ('" + encomenda.getId() + "', '" + encomenda.getDescricao() + "', '" + encomenda.getPeso() + "', '" 
                    + encomenda.getId_cliente() + "', '" + encomenda.getLogradouro() + "', '" + encomenda.getNumero() + "', '" 
                    + encomenda.getValor() + "', '" + encomenda.getBairro() + "', '" + encomenda.getCep() + "', '" + encomenda.getId_entregador() + "', '"
                    + encomenda.getDados() + "', '" + encomenda.getData_pedido() + "', '" + encomenda.getData_entrega() + "', '" + encomenda.getMemento() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public List<Encomenda> obterEncomendas() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        List<Encomenda> encomendas = new ArrayList<Encomenda>();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM encomenda");
            while (rs.next()){
                
                Encomenda encomenda = new Encomenda
                                    (rs.getInt("id"), rs.getString("descricao"), rs.getInt("peso"), rs.getInt("id_cliente"),
                                     rs.getString("logradouro"), rs.getInt("numero"), rs.getDouble("valor"), rs.getString("bairro"),
                                     rs.getString("cep"), rs.getInt("id_entregador"),  rs.getString("situacao"), rs.getString("data_pedido"), 
                                            rs.getString("data_entrega"), rs.getString("memento"));
                encomendas.add(encomenda);
            }
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return encomendas;
    }
    
    public void delete(Encomenda encomenda) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM encomenda WHERE id = " + encomenda.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    
}
