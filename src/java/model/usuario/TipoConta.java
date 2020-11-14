package model.usuario;

import java.util.ArrayList;

public abstract class TipoConta {

    long id;
    String tipo;
    ArrayList listaPermissao = new ArrayList();

    public abstract String getDescricaoConta();

    public TipoConta() {
    }

    public abstract long getId();

    public abstract String getTipo();

}
