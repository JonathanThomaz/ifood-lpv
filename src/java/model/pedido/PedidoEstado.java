package model.pedido;


public interface PedidoEstado {
    
    public String getEstado();
    
    public boolean aprovar(Pedido pedido);
    
    public boolean naoAprovar(Pedido pedido);
    
    public boolean aguardar(Pedido pedido);
    
    public boolean sairParaEntrega(Pedido pedido);
    
    public boolean concluir(Pedido pedido);
    
    public boolean cancelar(Pedido pedido);

}
