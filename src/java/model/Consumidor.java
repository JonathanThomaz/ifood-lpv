package model;

import model.usuario.Conta;

public class Consumidor {

    private long id;
    private String nome;
    private String cpf;
    private String nascimento;

    private long idConta;
    private Conta conta;


    public Consumidor() {
    }
  
    public long getId() {
        return id;
    }

    public Consumidor setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Consumidor setNome(String nome) {
        this.nome = nome;
        return this;

    }

    public String getCpf() {
        return cpf;
    }

    public Consumidor setCpf(String cpf) {
        this.cpf = cpf;
        return this;

    }

    public String getNascimento() {
        return nascimento;
    }

    public Consumidor setNascimento(String nascimento) {
        this.nascimento = nascimento;
        return this;

    }

    public long getIdConta() {
        return conta.getId();
    }

    private void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    public Conta getConta() {
        return conta;
    }

    public Consumidor setConta(Conta conta) {
        this.conta = conta;
        this.setIdConta(conta.getId());
        return this;
    }
    
}
