/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.categoria.Categoria;
import model.promocao.Promocao;

/**
 *
 * @author Artur
 */
public class Produto {

    private long id;
    private String nome;
    private String preco;
    private String disponivel;
    private String descricao;
    private String imagem;
    
    private Categoria categoria;
    private Promocao promocao;
    private Loja loja;

    
}
