package model.pedido;


public class PedidoEstadoCancelado extends PedidoEstado {

    public PedidoEstadoCancelado() {
        this.estadoNome = "Cancelado";
        this.estadoMsg = "cancelado";
        this.nome = "cancelado";

    }
}
