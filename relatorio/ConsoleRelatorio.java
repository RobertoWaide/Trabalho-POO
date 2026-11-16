
package relatorio;

public class ConsoleRelatorio implements DestinoRelatorio {

    @Override
    public void enviar(String conteudo) {
        System.out.println(conteudo);
    }
}
