package model.usuario;

import java.util.ArrayList;


public abstract class TipoConta {
    
    private long id;
    private String tipo;
    ArrayList listaPermissao = new ArrayList();
    
    public abstract String getDescricaoConta();

}
