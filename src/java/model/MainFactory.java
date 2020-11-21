/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.pedido.Pedido;
import model.pedido.PedidoEstado;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.usuario.Conta;

/**
 *
 * @author mathe
 */
public class MainFactory {

    public static Object getObject(String state) {
        Object actionObject = null;
        String nomeClasse = state;

        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }

        actionObject = objeto;
        return actionObject;
    }

    public static Boolean invocarMetodoFactory(Pedido carrinho, String nomeMetodo) {
        Boolean alteracao = false;
        try {
            Method metodo = PedidoEstado.class.getMethod(nomeMetodo, Pedido.class);
            alteracao = (Boolean) metodo.invoke(carrinho.getEstado(), carrinho);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MainFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alteracao;
    }


}