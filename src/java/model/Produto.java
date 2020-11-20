package model;

import java.sql.SQLException;
import model.categoria.Categoria;
import model.promocao.Promocao;
import persistence.ProdutoDAO;

public class Produto {

    private long id;
    private String nome;
    private double preco;
    private boolean disponivel;
    private double valor_desconto;
    private String descricao;
    private String imagem;

    private Categoria categoria;
    private Loja loja;

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

    public double getPreco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        preco = this.preco * (1 - this.valor_desconto);
        this.preco = preco;
        return this;

    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public Produto setDisponivel(boolean disponivel) {
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

    public double getValor_desconto() {
        return valor_desconto;
    }

    public Produto setValor_desconto(double valor_desconto) {
        this.valor_desconto = valor_desconto;
        this.preco = this.preco * (1 - this.valor_desconto);
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
