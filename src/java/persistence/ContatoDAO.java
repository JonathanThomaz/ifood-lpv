package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Contato;
import model.usuario.Conta;


public class ContatoDAO {

    private static ContatoDAO instance = new ContatoDAO();

    public static ContatoDAO getInstance() {
        return instance;
    }

    private ContatoDAO() {
    }
    
    public Contato save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        String query = ("INSERT INTO contato (telefone, ddd, email, telefoneComplementar, idConta)" + " VALUES "
                    + "('" + contato.getTelefone() + "', "
                    + "'" + contato.getDdd() + "', "
                    + "'" + contato.getEmail() + "', "
                    + "'" + contato.getTelefoneComplementar() + "', "
                    + "'" + contato.getIdConta() + "');");
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            contato.setId(key);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return contato;
        }

    }

    
    public Contato get(String login) throws ClassNotFoundException, SQLException {
        Contato contato = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conta WHERE login = '" + login + "'");
            rs.first();

            
            
            contato = new Contato();
            contato.setId(rs.getLong("contato.telefone"));
            contato.setId(rs.getLong("contato.id"));
            contato.setDdd("contato.ddd");
            contato.setId(rs.getLong("contato.email"));
            contato.setId(rs.getLong("contato.telefoneComplementar"));
                        
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id"));
            conta.setLogin(rs.getString("conta.login"));
            conta.setSenha(rs.getString("conta.senha"));
            conta.setIdTipoConta(rs.getLong("conta.idTipoConta"));

            
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return contato;

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
