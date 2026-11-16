
package servico;

import modelo.Pedido;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FechamentoDia {

    public String gerarRelatorio(ControlePedidos controle) {

        List<Pedido> pedidos = controle.getPedidos();

        StringBuilder relatorio = new StringBuilder();

        BigDecimal faturamento = BigDecimal.ZERO;

        Pedido pedidoMaisCaro = null;

        relatorio.append("========== FECHAMENTO DO DIA ==========\n\n");

        // Percorrendo todos os pedidos
        for (Pedido pedido : pedidos) {

            BigDecimal totalPedido = pedido.calcularTotal();

            faturamento = faturamento.add(totalPedido);

            // Identificando o pedido mais caro
            if (pedidoMaisCaro == null ||
                totalPedido.compareTo(pedidoMaisCaro.calcularTotal()) > 0) {

                pedidoMaisCaro = pedido;
            }

            relatorio.append("Cliente: ")
                .append(pedido.getCliente().getNome())
                .append("\n");

            relatorio.append("Data: ")
                .append(pedido.getData())
                .append("\n");

            relatorio.append("Quantidade de pratos: ")
                .append(pedido.getPratos().size())
                .append("\n");

            relatorio.append("Total: R$ ")
                .append(totalPedido.setScale(2, RoundingMode.HALF_UP))
                .append("\n");

            relatorio.append("---------------------------------------\n");
        }

        // Resumo financeiro
        relatorio.append("\n========== RESUMO FINANCEIRO ==========\n");

        relatorio.append("Quantidade de pedidos: ")
            .append(pedidos.size())
            .append("\n");

        relatorio.append("Faturamento total: R$ ")
            .append(faturamento.setScale(2, RoundingMode.HALF_UP))
            .append("\n");

        if (pedidoMaisCaro != null) {

            relatorio.append("Pedido mais caro: ")
                .append(pedidoMaisCaro.getCliente().getNome())
                .append(" - R$ ")
                .append(pedidoMaisCaro.calcularTotal()
                    .setScale(2, RoundingMode.HALF_UP));

        } else {

            relatorio.append("Nenhum pedido registrado.");

        }

        relatorio.append("\n=======================================");

        return relatorio.toString();
    }
}
