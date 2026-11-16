package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Pedido {

    private Cliente cliente;
    private LocalDateTime data;
    private List<Prato> pratos;

    public Pedido(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "Um pedido precisa ter um cliente!"
            );
        }

        this.cliente = cliente;
        this.data = LocalDateTime.now();
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {

        if (prato == null) {
            throw new IllegalArgumentException(
                "Não é possível adicionar um prato nulo!"
            );
        }

        pratos.add(prato);
    }

    public BigDecimal calcularTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (Prato prato : pratos) {
            total = total.add(prato.calcularPreco());
        }

        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<Prato> getPratos() {
        return new ArrayList<>(pratos);
    }
}

