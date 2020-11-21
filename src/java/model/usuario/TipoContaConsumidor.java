package model.usuario;


public class TipoContaConsumidor extends TipoConta {

    public TipoContaConsumidor() {
        this.id = 2;
        this.tipo = "Consumidor";
    }
    
    @Override
    public String getDescricaoConta() {
        return "Conta para usuários consumidores";
    }
}
