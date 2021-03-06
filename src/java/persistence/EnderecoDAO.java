package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Endereco;

public class EnderecoDAO {

    private static EnderecoDAO instance = new EnderecoDAO();

    public static EnderecoDAO getInstance() {
        return instance;
    }

    private EnderecoDAO() {
    }

    public Endereco get(long id) throws ClassNotFoundException, SQLException {
        Endereco endereco = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM endereco WHERE id =" + id + "");
            rs.first();
            endereco = new Endereco();
            endereco.setId(rs.getInt("id"));
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            endereco.setPais(rs.getString("pais"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return endereco;

    }

    public Endereco save(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1;
        String  query = ("INSERT INTO endereco (rua, bairro, numero, cep, complemento, cidade, estado, pais, idConta) VALUES "
                    + "('" + endereco.getRua() + "', "
                    + "'" + endereco.getBairro() + "', "
                    + "'" + endereco.getNumero() + "', "
                    + "'" + endereco.getCep() + "', "
                    + "'" + endereco.getComplemento() + "', "
                    + "'" + endereco.getCidade() + "', "
                    + "'" + endereco.getEstado() + "', "
                    + "'" + endereco.getPais()  + "', "
                    + "'" + endereco.getIdConta() + "');");
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            endereco.setId(key);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return endereco;
        }

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
