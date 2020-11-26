package model;

import model.usuario.Conta;


public class Loja {
    
    private long id;
    private String nome;
    private String cnpj;
    private String descricao;
    private String imagem;
    
    private long idConta;
    private Conta conta;

    public Loja() {
    }

    
    public long getId() {
        return id;
    }

    public Loja setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Loja setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Loja setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Loja setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getImagem() {
        return imagem;
    }

    public Loja setImagem(String imagem) {
        this.imagem = imagem;
        return this;
    }

    public long getIdConta() {
        return conta.getId();
    }

    private void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    public Loja setConta(Conta conta) {
        this.conta = conta;
        this.setIdConta(conta.getId());
        return this;
    }
}
