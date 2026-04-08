package poo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Classe que representa um simulador de um relógio.
 * Este relógio é inicializado às 0h00 do dia atual.<br>
 * Em todo o sistema existe apenas um relógio, dai, para aceder
 * ao relógio é necessário usar o método <code><b>getRelogioSistema</b></code>,
 * ou em alternativa, para aceder ao tempo atual, ao método
 * <code><b>getTempoAtual</b></code>.<br>
 * Para definir a velocidade do relógio, usar o método
 * <code><b>setTicksPorSegundo</b></code>.
 * Para alterar o tempo do relógio, usar o método
 * <code><b>setTempoAtual</b></code>.
 */
public class RelogioSimulado {

	private static RelogioSimulado relogio;
	private LocalDateTime ultimoTempoLido;
	private long ultimoTempoReal;
	private int ticksPorSegundo = 1;

	/**
	 * Construtor privado. Para aceder ao relógio usar o método
	 * getRelogioSimulado
	 */
	private RelogioSimulado() {
		ultimoTempoReal = System.currentTimeMillis();
		ultimoTempoLido = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
	}

	/**
	 * Retorna o relógio simulado
	 * 
	 * @return o relógio simulado
	 */
	public static RelogioSimulado getRelogioSimulado() {
		if (relogio == null) {
			relogio = new RelogioSimulado();
		}
		return relogio;
	}

	/**
	 * Método de conveniência para retornar o tempo atual,
	 * sem ser necessário aceder ao relógio diretamente
	 * 
	 * @return o tempo atual no relógio simulado
	 */
	public static LocalDateTime getTempoAtual() {
		return getRelogioSimulado().tempoAtual();
	}

	/**
	 * Método que retorna o tempo atual no relógio de sistema simulado
	 * 
	 * @return o tempo atual no relógio simulado
	 */
	public LocalDateTime tempoAtual() {
		long agora = System.currentTimeMillis();
		long difSecs = (agora - ultimoTempoReal) / 1000;
		long segundosSimulados = difSecs * ticksPorSegundo;
		ultimoTempoReal = agora;

		ultimoTempoLido = ultimoTempoLido.plusSeconds(segundosSimulados);
		return ultimoTempoLido;
	}

	/**
	 * Define a "velocidade" do relógio, isto é, cada segundo no relógio real
	 * corresponderá a <b>ticksPorSegundo</b> segundos no relógio simulado.
	 * Inicialmente o relógio tem 1 tick por segundo, isto é, 1 segundo real
	 * corresponde a 1 segundo simulado.
	 * 
	 * @param ticksPorSegundo o número de segundos simulados que passam por cada
	 *                        segundo do relógio real
	 */
	public void setTicksPorSegundo(int ticksPorSegundo) {
		if (ticksPorSegundo > 1)
			this.ticksPorSegundo = ticksPorSegundo;
	}

	/**
	 * Define o tempo atual que o relógio deve simular. O novo tempo nunca pode ser
	 * anterior ao tempo simulado atual.
	 * 
	 * @param tempo o novo tempo.
	 * @throws IllegalArgumentException se tempo for anterior ao tempo atualmente
	 *                                  simulado no relógio
	 */
	public void setTempoAtual(LocalDateTime tempo) {
		ultimoTempoReal = System.currentTimeMillis();
		ultimoTempoLido = getTempoAtual();
		if (tempo.isBefore(ultimoTempoLido))
			throw new IllegalArgumentException(
					"tempo (" + tempo + " não pode ser inferior ao tempo atual (" + ultimoTempoLido);
		ultimoTempoLido = tempo;
	}
}
