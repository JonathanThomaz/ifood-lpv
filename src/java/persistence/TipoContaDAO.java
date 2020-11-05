
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.usuario.TipoConta;
import persistence.DatabaseLocator;

public class TipoContaDAO {
    
private static TipoContaDAO instance = new TipoContaDAO();

    public static TipoContaDAO getInstance() {
        return instance;
    }

    public void save(TipoConta tipoConta) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into tipoconta(tipo)"
                    + " values ('" + tipoConta.getTipo() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
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
}

