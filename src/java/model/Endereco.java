package model;

import model.usuario.Conta;


public class Endereco {

    private long id;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    private long idConta;
    private Conta conta;

    
    public Endereco() {
    }

    public long getId() {
        return id;
    }

    public Endereco setId(long id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }
    
    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getRua() {
        return rua;
    }
    
    public Endereco setRua(String cep) {
        this.cep = cep;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;

    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;

    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;

    }
    
    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Endereco setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getPais() {
        return pais;
    }
    public Endereco setPais(String pais) {
        this.pais = pais;
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

    public Endereco setConta(Conta conta) {
        this.conta = conta;
        this.setIdConta(conta.getId());
        return this;
    }
    
}