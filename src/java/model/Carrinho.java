package model;

import model.pedido.Pedido;

public class Carrinho {
    
    private long id;
    private Produto produto;
    private int quantidade;
    
    private Pedido pedido;

    public Carrinho() {
    }

    public Carrinho setId(long id) {
        this.id = id;
        return this;
    }

    public Carrinho setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Carrinho setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Carrinho setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

}
