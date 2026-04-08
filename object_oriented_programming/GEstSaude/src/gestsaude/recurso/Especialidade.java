package gestsaude.recurso;

import java.time.LocalTime;
import java.util.Collection;

import poo.tempo.HorarioDiario;

/**
 * Representa uma Especialidade. Deve ter uma lista das consultas marcadas e uma
 * lista com as senhas a serem atendidas no dia atual.
 */
public class Especialidade {

	// para simplificar, cada serviço vai ter sempre o mesmo horário
	private HorarioDiario horario = new HorarioDiario(LocalTime.of(8, 10), LocalTime.of(19, 50));

	/**
	 * Retorna qual a próxima senha em espera
	 * 
	 * @return a próxima senha em espera
	 */
	public Senha getProximaSenha() {
		// TODO implementar este método
		return null;
	}

	/**
	 * O utente não responde à chamada? Coloca a senha/consulta para 15 minutos mais
	 * tarde e passa ao próximo utente.
	 */
	public void rejeitaProximaSenha() {
		// TODO implementar este método
	}

	/**
	 * Terminou a consulta da senha
	 * 
	 * @param s a senha cuja consulta terminou
	 */
	public void terminaConsulta(Senha s) {
		// TODO implementar este método
	}

	/**
	 * Retorna as senhas que estão em lista de espera para serem atendidas nesta
	 * especialidade
	 * 
	 * @return as senhas que estão em lista de espera para serem atendidas
	 */
	public Collection<Senha> getEmEspera() {
		// TODO implementar este método
		return null;
	}
}
