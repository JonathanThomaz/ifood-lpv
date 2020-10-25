/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

/**
 *
 * @author Artur
 */
public class PedidoEstadoAprovado extends PedidoEstado {

    public PedidoEstadoAprovado() {
        this.estadoNome = "Aprovado";
        this.estadoMsg = "Pedido aprovado";
        this.nome = "aprovado";

    }   
}
