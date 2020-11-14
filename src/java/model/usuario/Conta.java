package model.usuario;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conta {
    
    private long id;
    private String login;
    private String senha;
    private long idTipo;
    
    private TipoConta tipoConta;   

    public Conta(){
        
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Conta setTipoConta(TipoConta tipo) {
         try {
            Class c = Class.forName("model.conta.TipoConta" + tipo);
                this.tipoConta = (TipoConta) c.newInstance();
            } catch (IllegalAccessException | ClassNotFoundException | IllegalArgumentException | SecurityException ex) {
                System.out.println(ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    public long getIdTipo() {
        return idTipo;
    }

    public String getTipoConta(){
        return this.tipoConta.getTipo();
    }

    public void setIdTipoConta(long idTipo) {   
        this.idTipo = idTipo;
        if(idTipo==1){
            TipoContaLoja tipoConta = new TipoContaLoja();
            this.setTipoConta(tipoConta);
        }else{            
            TipoContaConsumidor tipoConta = new TipoContaConsumidor();
            this.setTipoConta(tipoConta);
        }
        
    }

}
