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
import model.Entregador;

/**
 *
 * @author Ramon
 */
public class EntregadorDAO {
    private static EntregadorDAO instance = new EntregadorDAO();
    
    public EntregadorDAO(){
    }
    
    public static EntregadorDAO getInstance(){
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
    
    public void save(Entregador entregador) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO entregador (nome, situacao, id_veiculo)"
                    + " VALUES ('" + entregador.getNome() + "', '" + entregador.getDados() + "', '" 
                    + entregador.getId_veiculo() +"')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public List<Entregador> obterEntregadores() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        List<Entregador> entregadores = new ArrayList<Entregador>();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM entregador");
            while (rs.next()){
                Entregador entregador = new Entregador
                                    (rs.getInt("id"),
                                     rs.getString("nome"), 
                                     rs.getString("situacao"),
                                     rs.getInt("id_veiculo"));
                entregadores.add(entregador);
            }
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return entregadores;
    }
    
    public void delete(Entregador entregador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM entregador WHERE id = " + entregador.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public   Entregador obterEntregador(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Entregador entregador = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from entregador where id = " + id);
            rs.first();
            entregador = new Entregador
                          (rs.getInt("id"),
                                     rs.getString("nome"), 
                                     rs.getString("situacao"),
                                     rs.getInt("id_veiculo"));
            
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return entregador;
    }
    
    public  void editar(Entregador entregador, String nome, String situacao, int id_veiculo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE entregador SET nome = ?, situacao = ?, id_veiculo = ?  WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setString(2, situacao);
            comando.setInt(3, id_veiculo);
            comando.setInt(4, entregador.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
}
