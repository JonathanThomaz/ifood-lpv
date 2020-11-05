package model.promocao;


public class PromocaoFimdeSemana implements Promocao{
    
    public int id;

    public PromocaoFimdeSemana() {
        this.id = 3;
    }

    @Override
    public String getNome() {
        return "Fim de Semana";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public float getDesconto() {
        return 15;
    }

}
