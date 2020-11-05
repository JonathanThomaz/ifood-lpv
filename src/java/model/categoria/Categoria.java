package model.categoria;


public abstract class Categoria {

    private long id;
    private String nome;
    
    public long getId() {
        return id;
    }

    public Categoria setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
        return this;
    }
}