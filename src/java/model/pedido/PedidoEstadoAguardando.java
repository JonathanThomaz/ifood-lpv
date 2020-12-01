package model.pedido;

import model.MainFactory;


public class PedidoEstadoAguardando implements PedidoEstado {

    public PedidoEstadoAguardando() {
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
   

    @Override
    public String getEstado() {
     return "Aguardando";
    }

    @Override
    public boolean aguardar(Pedido pedido) {
        return false;
    }

    @Override
    public boolean sairParaEntrega(Pedido pedido) {
        return false;
    }

    @Override
    public boolean concluir(Pedido pedido) {
        return false;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }

}
