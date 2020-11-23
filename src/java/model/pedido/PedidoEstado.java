package model.pedido;


public interface PedidoEstado {
    
    public String getEstado();
    
    public void aprovar(Pedido pedido);
    
    public void naoAprovar(Pedido pedido);
    
    public void aguardar(Pedido pedido);
    
    public void sairParaEntrega(Pedido pedido);
    
    public void concluir(Pedido pedido);
    
    public void cancelar(Pedido pedido);
    
    
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
