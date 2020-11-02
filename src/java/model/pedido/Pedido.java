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

}
