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
import model.Pedido;
import padraoDecorator.Cachaca;
import padraoDecorator.Coquetel;
import padraoDecorator.Refrigerante;

/**
 *
 * @author victor.domingos
 */
public class CoquetelDAO {
    private static CoquetelDAO instance = new CoquetelDAO();
    
    public CoquetelDAO(){
    }
    
    public static CoquetelDAO getInstance(){
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
    
    public void save(Pedido pedido, int numero) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        Coquetel meuCoquetel = new Cachaca();
        
        for(int i = 0; i< numero; i++){
            
            meuCoquetel = new Refrigerante(meuCoquetel);
            
        }
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into pedido (hora, dataPedido, valorPedido, drink)"
                    + " values ('" + pedido.getHora() + "', '"+ pedido.getDataPedido() +"', '"+ pedido.getValorPedido()+ "', '"+ meuCoquetel.getNome() + "')");
           
                        
                        
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
  
    public List<Pedido> obterPedidos() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            ResultSet rs = st.executeQuery("SELECT * FROM pedido");
            while (rs.next()){
                Pedido pedido = new Pedido
                                    (rs.getInt("id"), rs.getString("dataPedido"), rs.getFloat("valorPedido"),
                                    rs.getString("hora"), rs.getString("drink"));
                pedidos.add(pedido);
            }
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
    }
    
    public void delete(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM pedido WHERE id = " + pedido.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public   Pedido obterPedido(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Pedido pedido = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido where id = " + id);
            rs.first();
            pedido = new Pedido
                          (rs.getInt("id"), rs.getString("dataPedido"), rs.getFloat("valorPedido"),
                                    rs.getString("hora"), rs.getString("drink"));
            
        }catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }
    
    public void editar(Pedido pedido, String dataPedido, String valorPedido, String hora, String drink) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE pedido SET dataPedido = ?, valorPedido = ?, hora = ?, drink = ? WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, dataPedido);
            comando.setString(2, valorPedido);
            comando.setString(3, hora);
            comando.setString(4, drink);
            comando.setInt(5, pedido.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
}
