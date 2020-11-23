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
    
    public Pedido(Long id, String valor, PedidoEstado estado,ArrayList<Carrinho> carrinho, Loja loja, Consumidor consumidor ) {
        this.id = id;
        this.valor = valor;
        this.estado = new PedidoEstadoAguardando();
        this.consumidor = consumidor;
        this.loja = loja;
        this.carrinho = carrinho;
    }

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

    public ArrayList<Carrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Carrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }
    
    
}
