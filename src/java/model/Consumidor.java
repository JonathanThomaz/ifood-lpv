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

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public long getIdConta() {
        return conta.getId();
    }

    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
      
}
