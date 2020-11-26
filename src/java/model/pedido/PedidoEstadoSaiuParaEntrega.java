package model.pedido;

import model.MainFactory;


public class PedidoEstadoSaiuParaEntrega implements PedidoEstado {

    public PedidoEstadoSaiuParaEntrega() {
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
    public void sairParaEntrega(Pedido pedido) {
        
    }

    @Override
    public void concluir(Pedido pedido) {
        
    }

    @Override
    public void cancelar(Pedido pedido) {
        
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
