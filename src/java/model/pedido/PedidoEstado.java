package model.pedido;


public interface PedidoEstado {
    
    public String getEstado();
    
    public boolean aprovar(Pedido pedido);
    
    public boolean naoAprovar(Pedido pedido);
    
    public boolean aguardar(Pedido pedido);
    
    public boolean sairParaEntrega(Pedido pedido);
    
    public boolean concluir(Pedido pedido);
    
    public boolean cancelar(Pedido pedido);
    
    
//    protected String estadoNome;
//    protected String estadoMsg;
//    protected String nome;
//     
//    
//    public boolean aprovar(Pedido pedido){
//        return false;
//    }
//    
//    public boolean naoAprovar(Pedido pedido){
//        return false;
//    }
//
//    public boolean aguardar(Pedido pedido){
//        return false;
//    }
//    
//    public boolean sairParaEntrega(Pedido pedido){
//        return false;
//    }
//    
//    public boolean concluir(Pedido pedido){
//        return false;
//    }
//    
//    public boolean cancelar(Pedido pedido){
//        return false;
//    }
//   
//    public String getEstadoNome() {
//        return estadoNome;
//    }
//
//    public String getEstadoMsg() {
//        return estadoMsg;
//    }
//    
//    public String getNome(){
//        return nome;
//    }
}
