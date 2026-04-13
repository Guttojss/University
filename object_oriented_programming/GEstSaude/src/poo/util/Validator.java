package poo.util;

/**
 * Classe que fornece uma série de métodos para fazer validações recorrentes.
 * 
 * @author F. Sérgio Barbosa
 */
public class Validator {

    /**
     * testa se uma dada string é vazia (non blank), se for atira uma
     * IllegaLArgumentException
     * 
     * @param str a string a testar
     * @return a string já validada
     */
    public static String requireNonBlank(String str) {
        if (str.isBlank())
            throw new IllegalArgumentException();
        return str;
    }

    /**
     * testa se uma dada string é vazia (non blank), se for atira uma
     * IllegaLArgumentException. Se não for blank retorna a string já com o trim
     * feito
     * 
     * @param str a string a testar
     * @return a string já validada e com trim feito
     */
    public static String requireNonBlankTrimmed(String str) {
        return requireNonBlank(str).trim();
    }

    /**
     * Testa se um dado valor está dentro da gama indicada, inclusive em ambos os
     * limites, senão atira uma IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @param min   valor mínimo da gama (inclusive)
     * @param max   valor máximo da gama (inclusive)
     * @return o valor já validado
     */
    public static int requireInsideRange(int valor, int min, int max) {
        if (valor < min || valor > max)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um dado valor está dentro da gama indicada, inclusive em ambos os
     * limites, senão atira uma IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @param min   valor mínimo da gama (inclusive)
     * @param max   valor máximo da gama (inclusive)
     * @return o valor já validado
     */
    public static long requireInsideRange(long valor, long min, long max) {
        if (valor < min || valor > max)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um dado valor está dentro da gama indicada, inclusive em ambos os
     * limites, senão atira uma IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @param min   valor mínimo da gama (inclusive)
     * @param max   valor máximo da gama (inclusive)
     * @return o valor já validado
     */
    public static float requireInsideRange(float valor, float min, float max) {
        if (valor < min || valor > max)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um dado valor está dentro da gama indicada, inclusive em ambos os
     * limites, senão atira uma IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @param min   valor mínimo da gama (inclusive)
     * @param max   valor máximo da gama (inclusive)
     * @return o valor já validado
     */
    public static double requireInsideRange(double valor, double min, double max) {
        if (valor < min || valor > max)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo ou zero, senão atira uma
     * IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @return o valor já validado
     */
    public static int requirePositiveOrZero(int valor) {
        if (valor < 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo ou zero, senão atira uma
     * IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @return o valor já validado
     */
    public static long requirePositiveOrZero(long valor) {
        if (valor < 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo ou zero, senão atira uma
     * IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @return o valor já validado
     */
    public static float requirePositiveOrZero(float valor) {
        if (valor < 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo ou zero, senão atira uma
     * IllegaLArgumentException
     * 
     * @param valor valor a testar
     * @return o valor já validado
     */
    public static double requirePositiveOrZero(double valor) {
        if (valor < 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo, sem contar o zero, senão atira uma
     * IllegaLArgumentException
     */
    public static int requirePositive(int valor) {
        if (valor <= 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo, sem contar o zero, senão atira uma
     * IllegaLArgumentException
     */
    public static long requirePositive(long valor) {
        if (valor <= 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo, sem contar o zero, senão atira uma
     * IllegaLArgumentException
     */
    public static float requirePositive(float valor) {
        if (valor <= 0)
            throw new IllegalArgumentException();
        return valor;
    }

    /**
     * Testa se um valor é positivo, sem contar o zero, senão atira uma
     * IllegaLArgumentException
     */
    public static double requirePositive(double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException();
        return valor;
    }
}
