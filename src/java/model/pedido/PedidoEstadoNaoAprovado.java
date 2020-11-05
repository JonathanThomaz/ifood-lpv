package model.pedido;


public class PedidoEstadoNaoAprovado extends PedidoEstado {

    public PedidoEstadoNaoAprovado() {
        this.estadoNome = "NaoAprovado";
        this.estadoMsg = "Pedido não aprovado";
        this.nome = "não aprovado";

    }
}
