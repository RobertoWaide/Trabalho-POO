package modelo;

import java.math.BigDecimal;
import excecao.PrecoInvalidoException;

public abstract  class Prato {
    private String nome;
    private BigDecimal precoBase;
    private int tempoPreparo;

    public Prato(String nome, BigDecimal precoBase, int tempoPreparo){

        if (precoBase.compareTo(BigDecimal.ZERO) < 0) {
            throw new PrecoInvalidoException("O preço base não pode ser negativo!");
        }

        this.nome = nome;
        this.precoBase = precoBase;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome(){
        return nome;
    }
    public BigDecimal getPrecoBase(){
        return precoBase;
    }
    public int  getTempoPreparo(){
        return tempoPreparo;
    }

    public abstract BigDecimal calcularPreco();
}
