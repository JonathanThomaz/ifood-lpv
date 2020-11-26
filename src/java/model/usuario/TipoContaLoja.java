package model.usuario;


public class TipoContaLoja  extends TipoConta {

    public TipoContaLoja() {
        this.id = 1;
        this.tipo = "Loha";
    }
    @Override
    public String getDescricaoConta() {
        return "Conta para usuários lojistas";
    }
}