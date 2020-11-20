package model;


public class Cartao {

    private long id;
    private String numero;
    private String titular;
    private String validade;
    private boolean aprovado;
    private boolean ativo;

    Consumidor consumidor;
    public long getId() {
        return id;
    }

    public Cartao setId(long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Cartao setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getTitular() {
        return titular;
    }

    public Cartao setTitular(String titular) {
        this.titular = titular;
        return this;

    }

    public String getValidade() {
        return validade;
    }

    public Cartao setValidade(String validade) {
        this.validade = validade;
        return this;

    }

    public boolean getAprovado() {
        return aprovado;
    }

    public Cartao setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
        return this;
    }
     
    public boolean getAtivo() {
        return ativo;
    }

    public Cartao setAtivo(boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    
    public Consumidor getConsumidor() {
        return consumidor;
    }

    public Cartao setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;
    }

}
