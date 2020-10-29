/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import java.util.ArrayList;

/**
 *
 * @author Artur
 */
public abstract class TipoConta {
    
    private long id;
    private String tipo;
    ArrayList listaPermissao = new ArrayList();
    
    public abstract String getDescricaoConta();

}
