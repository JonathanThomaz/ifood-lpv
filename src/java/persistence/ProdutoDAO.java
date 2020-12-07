package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Loja;
import model.Produto;

public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    public static ProdutoDAO getInstance() {
        return instance;
    }

    private ProdutoDAO() {
    }

    public Produto get(long id) {
        Produto produto = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from produto "
                    + "WHERE produto.idProduto = " + id + ";");
            rs.first();
            Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.idLoja"));
            produto = new Produto();
            produto.setId((rs.getLong("produto.idProduto"))).setNome(rs.getString("produto.nome"))
                    .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                    .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }

    public ArrayList<Produto> getAll() {
        ArrayList<Produto> produtos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM produto;");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.idLoja"));

                Produto produto = new Produto();
                produto.setId((rs.getLong("produto.idProduto"))).setNome(rs.getString("produto.nome"))
                        .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                        .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;
    }

    public ArrayList<Produto> getAllByLoja(long idLoja) {
        ArrayList<Produto> produtos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT produto.*, loja.* "
                    + "FROM produto "
                    + "INNER JOIN loja ON produto.idLoja = loja.idLoja "
                    + "WHERE produto.idLoja = '" + idLoja + "';");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.idLoja"));

                Produto produto = new Produto();
                produto.setId((rs.getLong("produto.idProduto"))).setNome(rs.getString("produto.nome"))
                        .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                        .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "INSERT INTO produto (`preco`, `nome`, `disponivel`, `descricao`, `imagem`, `idPromocao`, `idLoja`) "
                    + "VALUES (" + produto.getPreco() + ", "
                    + "'" + produto.getNome() + "', "
                    + produto.getDisponivel() + ", "
                    + "'" + produto.getDescricao() + "', "
                    + "'" + produto.getImagem() + "', "
                    + "" + produto.getPromocao().getId() + ", "
                    + produto.getLoja().getId() + ");";
            st.execute(query);
        } catch (SQLException e) {
            System.out.println(e);;
        } finally {
            closeResources(conn, st);
        }

    }

    public void update(Produto produto) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE produto SET preco = " + produto.getPreco() + ", "
                    + "nome = '" + produto.getNome() + "', "
                    + "disponivel = " + produto.getDisponivel() + ", "
                    + "descricao = '" + produto.getDescricao() + "', "
                    + "imagem = '" + produto.getImagem() + "', "
                    + "WHERE idProduto = " + produto.getId() + ";");

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
            st.executeUpdate("DELETE FROM produto WHERE idProduto = " + id + "");
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
