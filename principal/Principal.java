
package principal;

import modelo.*;
import servico.*;
import relatorio.*;
import excecao.*;

import java.math.BigDecimal;
import java.io.IOException;
import java.nio.file.Path;

public class Principal {

    public static void main(String[] args) {

        System.out.println("=== SABOREXPRESS ===");

        Prato executivo = new PratoExecutivo(
            "Frango grelhado",
            new BigDecimal("30.00"),
            20
        );
        Prato combo = new Combo(
            "Combo X-Burger",
            new BigDecimal("50.00"),
            15
        );
        Prato especial = new PratoEspecial(
            "Filé especial",
            new BigDecimal("40.00"),
            30,
            new BigDecimal("12.00")
        );
        Prato diet = new PratoDiet(
            "Salada Fit",
            new BigDecimal("35.00"),
            15
        );

        System.out.println("\n=== CARDÁPIO ===");

        System.out.println(
            executivo.getNome() + ": R$ " +
            executivo.calcularPreco()
        );
        System.out.println(
            combo.getNome() + ": R$ " +
            combo.calcularPreco()
        );
        System.out.println(
            especial.getNome() + ": R$ " +
            especial.calcularPreco()
        );
        System.out.println(
            diet.getNome() + ": R$ " +
            diet.calcularPreco()
        );

        System.out.println("\n=== TESTE DE EXCEÇÃO ===");

        try {

            Prato invalido = new PratoExecutivo(
                "Prato inválido",
                new BigDecimal("-10.00"),
                20
            );

        } catch (PrecoInvalidoException e) {

            System.out.println("Erro tratado: " + e.getMessage());

        }

        Cliente cliente1 = new Cliente(
            "Robert",
            "Rua A",
            "99999-1111"
        );
        Cliente cliente2 = new Cliente(
            "Maria",
            "Rua B",
            "99999-2222"
        );

        Pedido pedido1 = new Pedido(cliente1);

        pedido1.adicionarPrato(executivo);
        pedido1.adicionarPrato(combo);
        pedido1.adicionarPrato(especial);
        pedido1.adicionarPrato(diet);

        Pedido pedido2 = new Pedido(cliente2);

        pedido2.adicionarPrato(combo);
        pedido2.adicionarPrato(especial);


        ControlePedidos controle = new ControlePedidos();

        controle.adicionarPedido(pedido1);
        controle.adicionarPedido(pedido2);

        System.out.println("\n=== PEDIDO 1 ===");

        System.out.println(
            "Cliente: " + pedido1.getCliente().getNome()
        );
        System.out.println(
            "Data: " + pedido1.getData()
        );
        System.out.println(
            "Quantidade de pratos: " + pedido1.getPratos().size()
        );
        System.out.println(
            "Total: R$ " + pedido1.calcularTotal()
        );


        System.out.println("\n=== CONTROLE DO RESTAURANTE ===");

        for (Pedido pedido : controle.getPedidos()) {

            System.out.println(
                "Cliente: " + pedido.getCliente().getNome()
            );

            System.out.println(
                "Total: R$ " + pedido.calcularTotal()
            );

            System.out.println("----------------------");
        }

        FechamentoDia fechamento = new FechamentoDia();

        String relatorio = fechamento.gerarRelatorio(controle);

        DestinoRelatorio destinoConsole = new ConsoleRelatorio();

        DestinoRelatorio destinoArquivo =
            new ArquivoRelatorio(
                Path.of("relatorios", "fechamento.txt")
            );

        try {

            destinoConsole.enviar(relatorio);

            destinoArquivo.enviar(relatorio);

        } catch (IOException e) {

            System.out.println(
                "Erro ao salvar relatório: " + e.getMessage()
            );

        }

        System.out.println("\n=== TESTE LSP ===");

        testarSubstituicao(executivo);
        testarSubstituicao(combo);
        testarSubstituicao(especial);
        testarSubstituicao(diet);

    }

    private static void testarSubstituicao(Prato prato) {

        System.out.println(
            prato.getNome() + " custa R$ " +
            prato.calcularPreco().setScale(2)
        );

    }

}
