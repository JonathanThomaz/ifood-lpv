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
public class PromocaoFimdeSemana implements Promocao{
    
    public int id;

    public PromocaoFimdeSemana() {
        this.id = 3;
    }

    @Override
    public String getNome() {
        return "Fim de Semana";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public float getDesconto() {
        return 15;
    }

}
