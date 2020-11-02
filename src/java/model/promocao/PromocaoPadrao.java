package model.promocao;


public class PromocaoPadrao implements Promocao{
        
    public int id;

    public PromocaoPadrao() {
        this.id = 2;
    }

    @Override
    public String getNome() {
        return "Padrao";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public float getDesconto() {
        return 10;
    }

}
