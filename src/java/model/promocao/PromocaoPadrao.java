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
public class PromocaoPadrao implements Promocao{
        
    public int id;

    public PromocaoPadrao() {
        this.id = 2;
    }

    @Override
    public String getNome() {
        return "Padrao";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public float getDesconto() {
        return 10;
    }

}
