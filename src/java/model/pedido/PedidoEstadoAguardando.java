package model.pedido;


public class PedidoEstadoAguardando extends PedidoEstado {

    public PedidoEstadoAguardando() {
        this.estadoNome = "Aguardando";
        this.estadoMsg = "Aguardando aprovação";
        this.nome = "aguardando";
    }
   
    
}
