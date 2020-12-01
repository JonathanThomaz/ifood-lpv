package testesExecucao;

import java.lang.reflect.InvocationTargetException;
import model.usuario.Conta;

public class Teste {
    public static void main(String[] args){
        
        Conta c = new Conta();
        c.setTipoConta("Consumidor");
        System.out.println(c.getIdTipo());        
        System.out.println(c.getTipoConta());

    }
}
