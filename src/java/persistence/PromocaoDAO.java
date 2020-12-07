/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.MainFactory;
import model.promocao.Promocao;

/**
 *
 * @author admin
 */
public class PromocaoDAO {
     private static PromocaoDAO instance = new PromocaoDAO();

    public static PromocaoDAO getInstance() {
        return instance;
    }

    private PromocaoDAO() {
    }

    public ArrayList<Promocao> getPromocoes() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao");

            while (rs.next()) {
                Promocao promocao
                        = (Promocao) MainFactory.getObject(Promocao.class.getName() + rs.getString("nome"));
                promocoes.add(promocao);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return promocoes;
    }

    public Promocao getPromocao(int promocaoId) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Promocao promocao = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao where promocao.id ='" + promocaoId + "'");

            while (rs.next()) {
                promocao = (Promocao) MainFactory.getObject(Promocao.class.getName() + rs.getString("nome"));

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return promocao;
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

}
