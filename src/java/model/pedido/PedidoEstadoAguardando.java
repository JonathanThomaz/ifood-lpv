package model.pedido;

import model.MainFactory;


public class PedidoEstadoAguardando implements PedidoEstado {

    public PedidoEstadoAguardando() {
    }

   
        
    @Override
    public void aprovar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Aprovado"));
    }
    
    @Override
    public void naoAprovar(Pedido pedido){
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "NaoAprovado"));
    }
   

    @Override
    public String getEstado() {
     return null;
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

}
