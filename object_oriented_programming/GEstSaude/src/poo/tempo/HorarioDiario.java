package poo.tempo;

import java.time.LocalTime;

/**
 * Esta classe representa um horário diário. Para simplificar, este horário é
 * composto por um intervalo apenas, desde uma hora inicial (de abertura) e uma
 * hora final (de fecho). Se a hora de início for igual à hora de fim,
 * considera-se que o horário está vazio.
 * Esta classe é imutável.
 */
public final class HorarioDiario {

    /** constante que define um horário de aberto todo o dia */
    public static final HorarioDiario TODO_DIA = new HorarioDiario(LocalTime.MIDNIGHT, LocalTime.MAX);

    /** constante que define um horário de nunca aberto */
    public static final HorarioDiario VAZIO = new HorarioDiario(LocalTime.MIDNIGHT, LocalTime.MIDNIGHT);

    private final LocalTime inicio;
    private final LocalTime fim;

    /**
     * Cria um horário diário, com uma dada hora de início e de fim. A hora de fim
     * tem de ser sempre superior à hora de início. Para criar um horário vazio
     * basta indicar uma hora final igual à inicial.
     * 
     * @param inicio hora de início
     * @param fim    hora de fim
     */
    public HorarioDiario(LocalTime inicio, LocalTime fim) {
        if (inicio.isAfter(fim))
            throw new IllegalArgumentException("inicio tem de ser menor ou igual a fim");
        this.inicio = inicio;
        // se for vazio usa-se o mesmo inicio e fim
        this.fim = inicio.equals(fim) ? this.inicio : fim;
    }

    /**
     * Devolve um horário diário, com uma dada hora de início e de fim. A hora de
     * fim tem de ser sempre superior à hora de início. Para criar um horário vazio
     * basta indicar uma hora final igual à inicial.
     * 
     * @param inicio hora de início
     * @param fim    hora de fim
     * @return o horário configurado de acordo com o pretendido
     */
    public static HorarioDiario deAte(LocalTime inicio, LocalTime fim) {
        if (inicio.equals(fim))
            return VAZIO;
        return new HorarioDiario(inicio, fim);
    }

    /**
     * Devolve um horário em que todas as horas são consideradas dentro do mesmo,
     * isto é, um horário desde as 0:0:0 às 23:59:59
     * 
     * @return o horário totalmente aberto
     */
    public static HorarioDiario todoDia() {
        return TODO_DIA;
    }

    /**
     * Devolve um horário vazio, isto é, nunca está aberto
     * 
     * @return
     */
    public static HorarioDiario vazio() {
        return VAZIO;
    }

    /**
     * Indica se um tempo especificado está dentro do período deste horário. Atenção
     * que se um horário tiver o inicio igual ao fim é considerado um horário vazio,
     * logo qualquer tempo irá ficar fora deste tipo de horários.
     * 
     * @param t o tempo a verificar
     * @return true se estiver dentro do periodo
     */
    public boolean contem(LocalTime t) {
        return !eVazio() && inicio.compareTo(t) <= 0 && fim.compareTo(t) >= 0;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    /**
     * Indica se um horário é vazio. Um horário é vazio se o fim for igual ao início
     * 
     * @return true se for um horário vazio
     */
    public boolean eVazio() {
        return inicio == fim;
    }
}
