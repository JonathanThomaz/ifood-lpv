package model.usuario;


public class TipoContaConsumidor extends TipoConta {

    @Override
    public String getDescricaoConta() {
        return "Conta para consumidores";
    }
    
    @Override
    public long getId(){
        return 2;
    }
    
    @Override
    public String getTipo(){
        return "Consumidor";
    }
}
