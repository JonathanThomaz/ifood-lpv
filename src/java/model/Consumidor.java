package model;

import model.usuario.Conta;
import java.util.Observable;
import java.util.Observer;

public class Consumidor implements Observer {

    private long id;
    private String nome;
    private String cpf;
    private String nascimento;

    private Conta conta;
  
    @Override
    public void update(Observable o, Object arg) {
       
    }
}
