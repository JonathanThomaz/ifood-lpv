package model.pedido;

import model.MainFactory;


public class PedidoEstadoNaoAprovado extends PedidoEstado {

    public PedidoEstadoNaoAprovado() {
        this.estadoNome = "NaoAprovado";
        this.estadoMsg = "Pedido não aprovado";
        this.nome = "não aprovado";

    }  
    
    @Override
    public boolean cancelar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Cancelado"));
        return true;
    }
   
}
