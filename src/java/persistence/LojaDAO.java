package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;
import model.Endereco;
import model.Loja;
import model.categoria.Categoria;
import model.usuario.Conta;

public class LojaDAO {

    private static LojaDAO instance = new LojaDAO();

    public static LojaDAO getInstance() {
        return instance;
    }

    private LojaDAO() {
    }

    public Loja get(long id) throws SQLException, ClassNotFoundException {
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, contato.*, conta.*, endereco.*, tipoConta.* "
                    + "FROM conta "
                    + "INNER JOIN loja  ON conta.idConta = loja.idConta "
                    + "INNER JOIN contato ON conta.idConta = contato.idConta "
                    + "INNER JOIN endereco ON conta.idConta = endereco.idConta "
                    + "INNER JOIN tipoConta ON conta.idTipoConta = tipoConta.idTipoConta "
                    + "WHERE loja.idLoja = " + id + ";");
            rs.first();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.idConta")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipoConta(rs.getString("tipoConta.tipo"));

            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.idContato"))).setTelefone(rs.getString("contato.telefone")).
                    setDdd(rs.getString("contato.ddd")).setEmail((rs.getString("contato.email"))).
                    setTelefoneComplementar(rs.getString("contato.telefoneComplementar")).setConta(conta);

            Endereco endereco = new Endereco();
            endereco.setId(rs.getLong("endereco.idEndereco")).setRua(rs.getString("endereco.rua"))
                    .setBairro(rs.getString("endereco.bairro")).setCep(rs.getString("endereco.cep"))
                    .setNumero(rs.getString("endereco.numero")).setComplemento(rs.getString("endereco.complemento"))
                    .setCidade(rs.getString("endereco.cidade")).setEstado(rs.getString("endereco.estado"))
                    .setPais(rs.getString("endereco.pais")).setConta(conta);

            loja = new Loja();
            loja.setId(rs.getLong("loja.idLoja")).setNome(rs.getString("loja.nome"))
                    .setCnpj(rs.getString("loja.CNPJ")).setDescricao(rs.getString("loja.descricao"))
                    .setImagem(rs.getString("loja.imagem")).setConta(conta);

        } finally {
            closeResources(conn, st);
        }
        return loja;
    }

    public ArrayList<Loja> getAll() {
        ArrayList<Loja> lojas = new ArrayList();
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, contato.*, conta.*, endereco.*, tipoConta.* "
                    + "FROM conta "
                    + "INNER JOIN loja  ON conta.idConta = loja.idConta "
                    + "INNER JOIN contato ON conta.idConta = contato.idConta "
                    + "INNER JOIN endereco ON conta.idConta = endereco.idConta "
                    + "INNER JOIN tipoConta ON conta.idTipoConta = tipoConta.idTipoConta;");
            while (rs.next()) {

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

                loja = new Loja();
                loja = loja.setId(rs.getLong("loja.idLoja")).setNome(rs.getString("loja.nome"))
                        .setCnpj(rs.getString("loja.CNPJ")).setDescricao(rs.getString("loja.descricao"))
                        .setImagem(rs.getString("loja.imagem")).setConta(conta);
            }
            lojas.add(loja);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
        return lojas;
    }

    public void update(Loja loja) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "UPDATE loja SET nome = '" + loja.getNome() + "', "
                    + "CNPJ = '" + loja.getCnpj() + "', "
                    + "descricao = '" + loja.getDescricao() + "', "
                    + "imagem = '" + loja.getImagem() + "', "
                    + "WHERE idLoja = " + loja.getId() + ";";
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
            st.executeUpdate("DELETE FROM loja WHERE idLoja = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Loja loja) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String query = ("INSERT INTO loja (nome, cnpj, descricao, imagem, idConta) VALUES "
                + "('" + loja.getNome() + "', "
                + "'" + loja.getCnpj() + "', "
                + "'" + loja.getDescricao() + "', "
                + "'" + loja.getImagem() + "', "
                + "" + loja.getIdConta() + ");");
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

    public Loja getByConta(long id) throws SQLException, ClassNotFoundException {
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, contato.*, conta.*, endereco.*, tipoConta.* "
                    + "FROM conta "
                    + "INNER JOIN loja  ON conta.idConta = loja.idConta "
                    + "INNER JOIN contato ON conta.idConta = contato.idConta "
                    + "INNER JOIN endereco ON conta.idConta = endereco.idConta "
                    + "INNER JOIN tipoConta ON conta.idTipoConta = tipoConta.idTipoConta "
                    + "WHERE conta.idConta = " + id + ";");
            rs.first();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.idConta")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipoConta(rs.getString("tipoConta.tipo"));

            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.idContato"))).setTelefone(rs.getString("contato.telefone")).
                    setDdd(rs.getString("contato.ddd")).setEmail((rs.getString("contato.email"))).
                    setTelefoneComplementar(rs.getString("contato.telefoneComplementar")).setConta(conta);

            Endereco endereco = new Endereco();
            endereco.setId(rs.getLong("endereco.idEndereco")).setRua(rs.getString("endereco.rua"))
                    .setBairro(rs.getString("endereco.bairro")).setCep(rs.getString("endereco.cep"))
                    .setNumero(rs.getString("endereco.numero")).setComplemento(rs.getString("endereco.complemento"))
                    .setCidade(rs.getString("endereco.cidade")).setEstado(rs.getString("endereco.estado"))
                    .setPais(rs.getString("endereco.pais")).setConta(conta);

            loja = new Loja();
            loja.setId(rs.getLong("loja.idLoja")).setNome(rs.getString("loja.nome"))
                    .setCnpj(rs.getString("loja.CNPJ")).setDescricao(rs.getString("loja.descricao"))
                    .setImagem(rs.getString("loja.imagem")).setConta(conta);

        } finally {
            closeResources(conn, st);
        }
        return loja;
    }
}
