package model.pedido;


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
     
}
