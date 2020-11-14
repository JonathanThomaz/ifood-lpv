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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public ArrayList<Carrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Carrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

}
