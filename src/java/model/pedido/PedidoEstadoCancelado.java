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
public class PedidoEstadoCancelado extends PedidoEstado {

    public PedidoEstadoCancelado() {
        this.estadoNome = "Cancelado";
        this.estadoMsg = "cancelado";
        this.nome = "cancelado";

    }
    
}
