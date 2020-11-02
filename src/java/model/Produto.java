package model;

import model.categoria.Categoria;
import model.promocao.Promocao;

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
