
package modelo;

import java.math.BigDecimal;

public class PratoDiet extends Prato {

    public PratoDiet(
        String nome,
        BigDecimal precoBase,
        int tempoPreparo
    ) {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public BigDecimal calcularPreco() {
        return getPrecoBase();
    }
}
