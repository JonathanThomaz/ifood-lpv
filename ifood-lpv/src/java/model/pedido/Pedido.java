/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

import java.util.ArrayList;
import model.Carrinho;
import model.Consumidor;
import model.Loja;

/**
 *
 * @author Artur
 */
public class Pedido {
    
    private long id;
    private String valor;
    private PedidoEstado estado;
    private ArrayList<Carrinho> carrinho;

    private Loja loja;
    private Consumidor consumidor;

}
