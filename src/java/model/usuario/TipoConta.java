package model.usuario;

import java.util.ArrayList;


public abstract class TipoConta {
    
    long id;
    String tipo;
    ArrayList listaPermissao = new ArrayList();
    
    public abstract String getDescricaoConta();

    public TipoConta() {
    }
    
    
    
    public long getId(){
        return this.id;
    }
    
    public String getTipo(){
        return this.tipo;
    }

}
