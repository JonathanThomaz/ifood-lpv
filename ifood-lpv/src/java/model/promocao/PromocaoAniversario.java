/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.promocao;

/**
 *
 * @author Artur
 */
public class PromocaoAniversario implements Promocao{
    
    public int id;

    public PromocaoAniversario() {
        this.id = 4;
    }

    @Override
    public String getNome() {
        return "Aniversario";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public float getDesconto() {
        return 20;
    }

}
