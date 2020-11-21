package model.pedido;

import model.MainFactory;


public class PedidoEstadoAprovado extends PedidoEstado {

    public PedidoEstadoAprovado() {
        this.estadoNome = "Aprovado";
        this.estadoMsg = "Pedido aprovado";
        this.nome = "aprovado";

    }   
    
    @Override
    public boolean sairParaEntrega(Pedido pedido){
        return false;
    
    }
    
    @Override
    public boolean cancelar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Cancelado"));
        return true;
    }
   
}
