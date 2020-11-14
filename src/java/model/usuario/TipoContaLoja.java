package model.usuario;


public class TipoContaLoja  extends TipoConta {
    
    @Override
    public String getDescricaoConta() {
        return "Conta para lojas";
    }
    
    @Override
    public long getId(){
        return 1;
    }
    
    @Override
    public String getTipo(){
        return "Loja";
    }
}
