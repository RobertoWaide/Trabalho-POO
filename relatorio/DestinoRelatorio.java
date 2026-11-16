
package relatorio;

import java.io.IOException;

public interface DestinoRelatorio {

    void enviar(String conteudo) throws IOException;

}