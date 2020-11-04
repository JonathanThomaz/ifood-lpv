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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneComplementar() {
        return telefoneComplementar;
    }

    public void setTelefoneComplementar(String telefoneComplementar) {
        this.telefoneComplementar = telefoneComplementar;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public long getIdConta() {
        return conta.getId();
    }

    public void setIdConta(Conta conta) {
        this.idConta = conta.getId();
    }
    
}
