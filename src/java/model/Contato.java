package model;

import model.usuario.Conta;


public class Contato {
    
    private long id;
    private String telefone;
    private String ddd;
    private String email;
    private String telefoneComplementar;

    private long idConta;
    private Conta conta;

    public Contato() {
    }

    
    public long getId() {
        return id;
    }

    public Contato setId(long id) {
        this.id = id;
        return this;

    }

    public String getTelefone() {
        return telefone;
    }

    public Contato setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public Contato setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contato setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefoneComplementar() {
        return telefoneComplementar;
    }

    public Contato setTelefoneComplementar(String telefoneComplementar) {
        this.telefoneComplementar = telefoneComplementar;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public Contato setConta(Conta conta) {
        this.conta = conta;
        this.setIdConta(conta.getId());
        return this;
        
    }

    public long getIdConta() {
        return conta.getId();
    }
    private void setIdConta(long idConta) {
        this.idConta = idConta;
    }
  
}
