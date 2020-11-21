package model.pedido;

import java.util.ArrayList;
import model.Carrinho;
import model.Consumidor;
import model.Loja;

public class Pedido {
    
    private long id;
    private String valor;
    private PedidoEstado estado;
    private ArrayList<Carrinho> carrinho;

    private Loja loja;
    private Consumidor consumidor;

    public Pedido(){
    
    }
    
    public Pedido setId(long id) {
        this.id = id;
        return this;
    }

    public Pedido setValor(String valor) {
        this.valor = valor;
        return this;
    }

    public Pedido setEstado(PedidoEstado estado) {
        this.estado = estado;
        return this;
    }

    public Pedido setCarrinho(ArrayList<Carrinho> carrinho) {
        this.carrinho = carrinho;
        return this;
    }

    public Pedido setLoja(Loja loja) {
        this.loja = loja;
        return this;
    }

    public Pedido setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getValor() {
        return valor;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public ArrayList<Carrinho> getCarrinho() {
        return carrinho;
    }

    public Loja getLoja() {
        return loja;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }
    
    public Pedido addItem(Carrinho item){
        this.carrinho.add(item);
        return this;
    }

}
