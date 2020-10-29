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
public class PedidoEstadoSaiuParaEntrega extends PedidoEstado {

    public PedidoEstadoSaiuParaEntrega() {
        this.estadoNome = "SaiuParaEntrega";
        this.estadoMsg = "Pedido saiu para entrega";
        this.nome = "saiu para entrega";

    }
}
