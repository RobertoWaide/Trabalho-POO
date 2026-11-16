
package relatorio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ArquivoRelatorio implements DestinoRelatorio {

    private Path caminho;

    public ArquivoRelatorio(Path caminho) {
        this.caminho = caminho;
    }

    @Override
    public void enviar(String conteudo) throws IOException {

        Path pasta = caminho.getParent();

        if (pasta != null) {
            Files.createDirectories(pasta);
        }

        Files.writeString(
            caminho,
            conteudo,
            StandardCharsets.UTF_8
        );

        System.out.println(
            "Relatório salvo em: " + caminho.toAbsolutePath()
        );
    }
}