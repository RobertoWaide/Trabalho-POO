
package servico;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ControlePedidos {

    private List<Pedido> pedidos;

    public ControlePedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {

        if (pedido == null) {
            throw new IllegalArgumentException(
                "Não é possível registrar um pedido nulo!"
            );
        }

        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public int getQuantidadePedidos() {
        return pedidos.size();
    }
}