package model.pedido;


public class PedidoEstadoConcluido implements PedidoEstado {

    public PedidoEstadoConcluido() {
    }

    @Override
    public String getEstado() {
        return "Concluido";
    }

    @Override
    public boolean aprovar(Pedido pedido) {
        return false;
    }

    @Override
    public boolean naoAprovar(Pedido pedido) {
        return false;
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
        pedido.setEstado(new PedidoEstadoConcluido());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }
     
}
