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
public class PedidoEstadoAguardando extends PedidoEstado {

    public PedidoEstadoAguardando() {
        this.estadoNome = "Aguardando";
        this.estadoMsg = "Aguardando aprovação";
        this.nome = "aguardando";
    }
   
    
}
