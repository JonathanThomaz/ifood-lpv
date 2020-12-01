package model.pedido;

import model.MainFactory;

public class PedidoEstadoAprovado implements PedidoEstado {

    public PedidoEstadoAprovado() {
    }

    @Override
    public boolean sairParaEntrega(Pedido pedido) {
        return false;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Cancelado"));
        return true;
    }

    @Override
    public String getEstado() {
        return "Aprovado";
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
    public boolean concluir(Pedido pedido) {
        return false;
    }

}
