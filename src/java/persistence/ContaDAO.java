package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.usuario.Conta;


public class ContaDAO {

    private static ContaDAO instance = new ContaDAO();

    public static ContaDAO getInstance() {
        return instance;
    }

    private ContaDAO() {

    }

    public Conta save(Conta conta) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        String query = ("INSERT INTO conta (login, senha, idTipoConta) VALUES "
                    + "('" + conta.getLogin() + "', "
                    + "'" + conta.getSenha() + "', "
                    + "'" + conta.getIdTipo() + "');");
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            conta.setId(key);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return conta;
        }

    }


    public Conta get(String login) throws ClassNotFoundException, SQLException {
        Conta conta = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conta WHERE login = '" + login + "'");
            rs.first();

            conta = new Conta();
            conta.setId(rs.getLong("conta.idConta")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipoConta(rs.getString("tipoConta.tipo"));
           
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return conta;

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
            System.out.println(e);
        }
    }
}
