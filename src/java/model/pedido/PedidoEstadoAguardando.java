package model.pedido;

import model.MainFactory;


public class PedidoEstadoAguardando extends PedidoEstado {

    public PedidoEstadoAguardando() {
        this.estadoNome = "Aguardando";
        this.estadoMsg = "Aguardando aprovação";
        this.nome = "aguardando";
    }
   
        
    @Override
    public boolean aprovar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Aprovado"));
        return true;
    }
    
    @Override
    public boolean naoAprovar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "NaoAprovado"));
        return true;
    }
   
}
