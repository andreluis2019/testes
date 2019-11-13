

public class InverteString {

    public static String inverte(String nome) {
        StringBuffer nomeInvertido = new StringBuffer(nome);
        nomeInvertido.reverse();

        return nomeInvertido.toString();
    }
}
