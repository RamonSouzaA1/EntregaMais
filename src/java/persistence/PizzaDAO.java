package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pizza;

public class PizzaDAO {
    private static PizzaDAO instance = new PizzaDAO();
    
    public static PizzaDAO getInstance() {
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
    
    public void save(Pizza pizza) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO pizza (id, nome, ingrediente, precoMedia, precoFamilia)"
                    + " VALUES ('" + pizza.getId() + "', '" + pizza.getNome() + "', '" + pizza.getIngrediente() + "', '"
                    + pizza.getPrecoMedia() + "', '" + pizza.getPrecoFamilia() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public List<Pizza> obterPizzas() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        List<Pizza> pizzas = new ArrayList<Pizza>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pizza");
            while (rs.next()) {
                Pizza pizza = new Pizza(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("ingrediente"), rs.getDouble("precoMedia"), rs.getDouble("precoFamilia"));
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pizzas;
    }
    
    public void delete(Pizza pizza) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM pizza WHERE id = " + pizza.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Pizza obterPizza(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Pizza pizza = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pizza where id = " + id);
            rs.first();
            pizza = new Pizza(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("ingrediente"),
                    rs.getDouble("precoMedia"),
                    rs.getDouble("precoFamilia"));

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pizza;
    }
    
    public void editar(Pizza pizza, String nome, String ingredidente, double precoMedia, double precoFamilia) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE pizza SET nome = ?, ingredidente = ?, precoMedia = ?, precoFamilia = ?  WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setString(2, ingredidente);
            comando.setDouble(3, precoMedia);
            comando.setDouble(4, precoFamilia);
            comando.setInt(5, pizza.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
}
