package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Consumidor;
import model.usuario.Conta;
import model.Contato;
import model.Endereco;
import persistence.ContaDAO;
import persistence.DatabaseLocator;

public class ConsumidorDAO {

    private static ConsumidorDAO instance = new ConsumidorDAO();

    public static ConsumidorDAO getInstance() {
        return instance;
    }

    private ConsumidorDAO() {
    }

    public Consumidor get(long id) {
        Consumidor consumidor = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.*, endereco.* "
                    + "FROM consumidor "
                    + "INNER JOIN contato ON contato.id = consumidor.contato_id "
                    + "INNER JOIN conta ON conta.id = consumidor.conta_id "
                    + "INNER JOIN endereco ON endereco.id = consumidor.endereco_id "
                    + "WHERE consumidor.id = " + id + ";");

            rs.first();
            
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id"));
            conta.setLogin(rs.getString("conta.login"));
            conta.setSenha(rs.getString("conta.senha"));
            conta.setIdTipo(rs.getLong("conta.idtipoConta"));
            

            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id")));
            contato.setTelefone(rs.getString("contato.telefone"));
            contato.setDdd(rs.getString("contato.ddd"));
            contato.setEmail((rs.getString("contato.email")));
            contato.setTelefoneComplementar(rs.getString("contato.telefoneComplementar"));
            contato.setIdConta(conta);
            contato.setConta(conta);
            
            Endereco endereco = new Endereco();
            endereco.setId(rs.getLong("endereco.id"));
            endereco.setBairro(rs.getString("endereco.bairro"));
            endereco.setCep(rs.getString("endereco.cep"));
            endereco.setCidade(rs.getString("endereco.cidade"));
            endereco.setComplemento(rs.getString("endereco.complemento"));
            endereco.setEstado(rs.getString("endereco.estado"));
            endereco.setRua(rs.getString("endereco.rua"));
            endereco.setNumero(rs.getString("endereco.numero"));
            endereco.setPais(rs.getString("endereco.pais"));
            endereco.setIdConta(conta);
            endereco.setConta(conta);
            
            consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id"));
            consumidor.setNome(rs.getString("consumidor.nome"));
            consumidor.setCpf(rs.getString("consumidor.cpf"));
            consumidor.setNascimento(rs.getString("consumidor.nascimento"));
            consumidor.setIdConta(conta.getId());
            consumidor.setConta(conta);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidor;
    }
    public void save(Consumidor consumidor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String query = ("INSERT INTO consumidor ( nome, cpf, nascimento, idConta) VALUES "
                    + "('" + consumidor.getNome() + "', "
                    + "'" + consumidor.getCpf() + "', "
                    + "'" + consumidor.getNascimento() + "', "
                    + "" + consumidor.getIdConta()+ ");");
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            System.out.println(e);;
        } finally {
            closeResources(conn, st);
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
