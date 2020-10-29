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
public class PromocaoNenhuma implements Promocao{
    
    public int id;

    public PromocaoNenhuma() {
        this.id = 1;
    }

    @Override
    public String getNome() {
        return "Nenhuma";
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public float getDesconto() {
        return 0;
    }

}
