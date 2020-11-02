package model.pedido;


public class PedidoEstadoSaiuParaEntrega extends PedidoEstado {

    public PedidoEstadoSaiuParaEntrega() {
        this.estadoNome = "SaiuParaEntrega";
        this.estadoMsg = "Pedido saiu para entrega";
        this.nome = "saiu para entrega";

    }
}
