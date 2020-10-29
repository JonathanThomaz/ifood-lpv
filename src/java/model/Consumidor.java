/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.usuario.Conta;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mathe
 */
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
