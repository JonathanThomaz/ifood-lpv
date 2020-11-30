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
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.*, endereco.*, tipoConta.* "
                    + "FROM conta "
                    + "INNER JOIN consumidor  ON conta.idConta = consumidor.idConta "
                    + "INNER JOIN contato ON conta.idConta = contato.idConta "
                    + "INNER JOIN endereco ON conta.idConta = endereco.idConta "
                    + "INNER JOIN tipoConta ON conta.idTipoConta = tipoConta.idTipoConta "
                    + "WHERE consumidor.idConsumidor = " + id + ";");
            rs.first();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.idConta")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipoConta(rs.getString("tipoConta.tipo"));

            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.idContato"))).setTelefone(rs.getString("contato.telefone")).
                    setDdd(rs.getString("contato.ddd")).setEmail((rs.getString("contato.email"))).
                    setTelefoneComplementar(rs.getString("contato.telefoneComplementar")).setConta(conta);

            Endereco endereco = new Endereco();
            endereco.setId(rs.getLong("endereco.id")).setRua(rs.getString("endereco.rua"))
                    .setBairro(rs.getString("endereco.bairro")).setCep(rs.getString("endereco.cep"))
                    .setNumero(rs.getString("endereco.numero")).setComplemento(rs.getString("endereco.complemento"))
                    .setCidade(rs.getString("endereco.cidade")).setEstado(rs.getString("endereco.estado"))
                    .setPais(rs.getString("endereco.pais")).setConta(conta);

            consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.idConsumidor")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.CPF")).setNascimento(rs.getString("consumidor.nascimento"))
                    .setConta(conta);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidor;
    }

    public void save(Consumidor consumidor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        System.out.println(consumidor.getNome());
        System.out.println(consumidor.getCpf());
        System.out.println(consumidor.getNascimento());
        System.out.println(consumidor.getIdConta());
        String query = ("INSERT INTO consumidor (nome, CPF, nascimento, idConta) VALUES "
                + "('" + consumidor.getNome() + "', "
                + "'" + consumidor.getCpf() + "', "
                + "'" + consumidor.getNascimento() + "', "
                + "" + consumidor.getIdConta() + ");");

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeResources(conn, st);
        }

    }

    public void update(Consumidor consumidor) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "UPDATE loja SET nome = '" + consumidor.getNome() + "', "
                    + "CPF = '" + consumidor.getCpf() + "', "
                    + "nascimento = '" + consumidor.getNascimento() + "', "
                    + "WHERE idLoja = " + consumidor.getId() + ";";
            st.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(long id) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM consumidor WHERE idConsumidor= " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
