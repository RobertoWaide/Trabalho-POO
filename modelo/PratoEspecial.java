package modelo;

import java.math.BigDecimal;
import excecao.PrecoInvalidoException;

public class PratoEspecial extends Prato {

    private BigDecimal custoIngredientePremium;

    public PratoEspecial(
        String nome,
        BigDecimal precoBase,
        int tempoPreparo,
        BigDecimal custoIngredientePremium
    ) {
        super(nome, precoBase, tempoPreparo);

        if (custoIngredientePremium.compareTo(BigDecimal.ZERO) < 0) {
            throw new PrecoInvalidoException(
                "O custo do ingrediente premium não pode ser negativo!"
            );
        }

        this.custoIngredientePremium = custoIngredientePremium;
    }

    @Override
    public BigDecimal calcularPreco() {
        return getPrecoBase().add(custoIngredientePremium);
    }
}