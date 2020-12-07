package model;

import java.sql.SQLException;
import model.categoria.Categoria;
import model.promocao.Promocao;
import persistence.ProdutoDAO;

public class Produto {

    private long id;
    private String nome;
    private String preco;
    private String disponivel;
    private String descricao;
    private String imagem;
      
    private Promocao promocao;
    private Categoria categoria;
    private Loja loja;

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public Produto setId(long id) {
        this.id = id;
        return this;

    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getPreco() {
        return preco;
    }

    public Produto setPreco(String preco) {
        this.preco = preco;
        return this;

    }

    public String getDisponivel() {
        return disponivel;
    }

    public Produto setDisponivel(String disponivel) {
        this.disponivel = disponivel;
        return this;

    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;

    }

    public String getImagem() {
        return imagem;
    }

    public Produto setImagem(String imagem) {
        this.imagem = imagem;
        return this;

    }

    public Loja getLoja() {
        return loja;
    }

    public Produto setLoja(Loja loja) {
        this.loja = loja;
        return this;

    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public void save() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstance().save(this);
    }

    public void update() {
        ProdutoDAO.getInstance().update(this);
    }

    @Override
    public String toString() {
        return this.nome + " : R$" + this.preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
