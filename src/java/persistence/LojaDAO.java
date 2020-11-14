package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.categoria.Categoria;
import model.usuario.Conta;
import model.Contato;
import model.Endereco;
import model.Loja;
import model.MainFactory;
import model.usuario.TipoContaLoja;

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
            ResultSet rs = st.executeQuery("SELECT loja.*, conta.*, contato.*, endereco.*, categoria.* "
                    + "FROM loja "
                    + "LEFT JOIN conta ON loja.conta_id = conta.id "
                    + "LEFT JOIN contato ON loja.contato_id = contato.id "
                    + "LEFT JOIN endereco ON loja.endereco_id = endereco.id "
                    + "LEFT JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE loja.id =" + id + "");
            rs.first();

            TipoContaLoja tipoConta = new TipoContaLoja();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id"));
            conta.setLogin(rs.getString("conta.login"));
            conta.setSenha(rs.getString("conta.senha"));
            conta.setTipoConta(tipoConta);

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

            loja = new Loja();
            loja.setId(rs.getLong("loja.id"));
            loja.setNome(rs.getString("loja.nome"));
            loja.setCnpj(rs.getString("loja.cnpj"));
            loja.setDescricao(rs.getString("loja.descricao"));
            loja.setImagem(rs.getString("loja.imagem"));
            loja.setIdConta(conta.getId());
            loja.setConta(conta);

        } finally {
            closeResources(conn, st);
        }
        return loja;
    }

    public Loja getByConta(long contaId) throws SQLException, ClassNotFoundException {
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "SELECT loja.*, conta.*, contato.*, endereco.*, categoria.* "
                    + "FROM loja "
                    + "LEFT JOIN conta ON loja.conta_id = conta.id "
                    + "LEFT JOIN contato ON loja.contato_id = contato.id "
                    + "LEFT JOIN endereco ON loja.endereco_id = endereco.id "
                    + "LEFT JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE loja.conta_id =" + contaId + "";
            ResultSet rs = st.executeQuery(query);
            rs.first();

            TipoContaLoja tipoConta = new TipoContaLoja();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id"));
            conta.setLogin(rs.getString("conta.login"));
            conta.setSenha(rs.getString("conta.senha"));
            conta.setTipoConta(tipoConta);

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

            loja = new Loja();
            loja.setId(rs.getLong("loja.id"));
            loja.setNome(rs.getString("loja.nome"));
            loja.setCnpj(rs.getString("loja.cnpj"));
            loja.setDescricao(rs.getString("loja.descricao"));
            loja.setImagem(rs.getString("loja.imagem"));
            loja.setIdConta(conta.getId());
            loja.setConta(conta);

        } finally {
            closeResources(conn, st);
        }
        return loja;
    }

    public ArrayList<Loja> getAll() {
        ArrayList<Loja> lojas = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, conta.*, contato.*, endereco.*, categoria.* "
                    + "FROM loja "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id;");
            while (rs.next()) {

                TipoContaLoja tipoConta = new TipoContaLoja();

                Conta conta = new Conta();
                conta.setId(rs.getLong("conta.id"));
                conta.setLogin(rs.getString("conta.login"));
                conta.setSenha(rs.getString("conta.senha"));
                conta.setTipoConta(tipoConta);

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

                Loja loja = new Loja();
                loja.setId(rs.getLong("loja.id"));
                loja.setNome(rs.getString("loja.nome"));
                loja.setCnpj(rs.getString("loja.cnpj"));
                loja.setDescricao(rs.getString("loja.descricao"));
                loja.setImagem(rs.getString("loja.imagem"));
                loja.setIdConta(conta.getId());
                loja.setConta(conta);

                lojas.add(loja);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
        return lojas;
    }

    public void update(Loja loja) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        String query = "UPDATE loja SET nome = '" + loja.getNome() + "', "
                    + "cnpj = '" + loja.getCnpj() + "', "
                    + "descricao = '" + loja.getDescricao() + "', "
                    + "imagem = '" + loja.getImagem() + "', "
                    + "WHERE idLoja = " + loja.getId() + ";";
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

    public void delete(long id) {
        Connection conn = null;
        Statement st = null;
        String query = ("DELETE FROM loja WHERE idLoja = " + id + "");
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate(query);
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
        String query = ("INSERT INTO loja (nome, cnpj, descricao, imagem, idConta) "
                + "VALUES (" + loja.getNome() + "', "
                + "'" + loja.getCnpj() + "', "
                + "'" + loja.getDescricao() + "', "
                + "'" + loja.getImagem() + "', "
                + +loja.getIdConta() + ");");
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
}
