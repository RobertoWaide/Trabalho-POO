package modelo;

import java.math.BigDecimal;

public class Combo extends Prato{
    
    private static final BigDecimal DESCONTO = new BigDecimal("0.15");

    public Combo(String nome, BigDecimal precoBase, int tempoPreparo) {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public BigDecimal calcularPreco(){
        BigDecimal desconto = getPrecoBase().multiply(DESCONTO);

        return getPrecoBase().subtract(desconto);
    }
}
