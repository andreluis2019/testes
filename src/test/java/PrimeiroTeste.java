import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimeiroTeste {

    @Test
    public void somaDeUmMaisUmDeveSerDois() {

        int um = 1;
        int dois = 2;

        int resultado = um + um;

        assertEquals(dois, resultado);
    }

    @Test
    public void valorNaoPodeSerNulo(){
        String valor = "TESTE";
        assertNotNull(valor);
    }

    @Test
    public void stringDeveSerInvertida(){
        String nome = "Andre Luis";
        String nomeInvertido = InverteString.inverte(nome);

        System.out.println(nomeInvertido);

        assertEquals("siuL erdnA", nomeInvertido);
    }

}
