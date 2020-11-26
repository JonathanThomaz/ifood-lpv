package model.pedido;


public class PedidoEstadoConcluido implements PedidoEstado {

    public PedidoEstadoConcluido() {
    }

    @Override
    public String getEstado() {
        return "Concluido";
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
        pedido.setEstado(new PedidoEstadoConcluido());
    }

    @Override
    public void cancelar(Pedido pedido) {
        
    }
     
}
