package model.pedido;

import model.MainFactory;


public class PedidoEstadoAprovado implements PedidoEstado {

    public PedidoEstadoAprovado() {
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
   
    @Override
    public String getEstado() {
        return null;
    }

    @Override
    public void aprovar(Pedido pedido) {
        
    }

    @Override
    public void naoAprovar(Pedido pedido) {
        
    }

    @Override
    public void aguardar(Pedido pedido) {
        
    }

 
    @Override
    public void concluir(Pedido pedido) {
        
    }


}
