package model.pedido;

import model.MainFactory;


public class PedidoEstadoSaiuParaEntrega extends PedidoEstado {

    public PedidoEstadoSaiuParaEntrega() {
        this.estadoNome = "SaiuParaEntrega";
        this.estadoMsg = "Pedido saiu para entrega";
        this.nome = "saiu para entrega";

    }
    
    @Override
    public boolean cancelar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Cancelado"));
        return true;
    }
    
    @Override
    public boolean concluir(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Concluido"));
        return true;
    }
}
