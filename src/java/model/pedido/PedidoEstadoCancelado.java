package model.pedido;


public class PedidoEstadoCancelado implements PedidoEstado {

    public PedidoEstadoCancelado() {
    }

    @Override
    public String getEstado() {
        return "Cancelado";
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
        return false;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }
}
