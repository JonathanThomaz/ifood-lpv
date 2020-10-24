/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.login;

import java.util.ArrayList;

/**
 *
 * @author Artur
 */
public abstract class TipoConta {
    
    ArrayList listaPermissao = new ArrayList();
    
    public abstract String getDescricaoConta();

}
