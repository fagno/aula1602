package pweb.aula1602.model.entity;

public class ItemVenda {

    private Long id;

    private Produto produto;

    private double qtd;

    public double total(){
        return qtd * produto.getValor();
    }

}
