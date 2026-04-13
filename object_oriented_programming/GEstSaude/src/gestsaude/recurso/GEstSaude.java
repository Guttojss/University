package gestsaude.recurso;

import java.time.LocalDateTime;

/**
 * Representa o sistema. Deve armazenar todas as consulta, utentes,
 * especialidades, serviços e senhas
 */
public class GEstSaude {

	// constantes para erros e situações que podem ocorrer para usar no retorno de
	// alguns métodos
	public static final int CONSULTA_ACEITE = 0;
	public static final int CONSULTA_JA_VALIDADA = CONSULTA_ACEITE + 1;
	public static final int UTENTE_SEM_CONSULTA_HOJE = CONSULTA_JA_VALIDADA + 1;
	public static final int UTENTE_SEM_CONSULTA_PROXIMA = UTENTE_SEM_CONSULTA_HOJE + 1;
	public static final int UTENTE_DEMASIADO_ATRASADO = UTENTE_SEM_CONSULTA_PROXIMA + 1;
	public static final int UTENTE_ATRASADO_FORAHORAS = UTENTE_DEMASIADO_ATRASADO + 1;
	public static final int UTENTE_ATRASADO_ADIADO = UTENTE_ATRASADO_FORAHORAS + 1;
	public static final int SERVICO_SEM_CONSULTA = UTENTE_ATRASADO_ADIADO + 1;
	public static final int DATA_JA_PASSOU = SERVICO_SEM_CONSULTA + 1;
	public static final int UTENTE_JA_TEM_CONSULTA = DATA_JA_PASSOU + 1;
	public static final int ESPECIALISTA_JA_TEM_CONSULTA = UTENTE_JA_TEM_CONSULTA + 1;
	public static final int ALTERACAO_INVALIDA = ESPECIALISTA_JA_TEM_CONSULTA + 1;

	public GEstSaude() {
	}

	/**
	 * Deve retornar qual a primeira consulta do dia de um utente
	 * 
	 * @param u o utente de quem ver a primeira consulta do dia
	 * @return a primeira consula do dia do utente
	 */
	public Consulta primeiraConsultaDia(Utente u) {
		// TODO implementar este método
		return null;
	}

	/**
	 * Valida a consulta. Verifica se a consulta pode ser concretizada e, se sim,
	 * emite a senha respetiva.
	 * 
	 * @param c a consulta a verificar
	 * @return o resultado deve ser um dos seguintes:
	 *         <li>
	 *         CONSULTA_ACEITE se a consulta pode ser realizada
	 *         <li>UTENTE_SEM_CONSULTA_PROXIMA se o utente não tem qualquer consulta
	 *         nas próximas 3 horas
	 *         <li>UTENTE_DEMASIADO_ATRASADO se o utente tinha a consulta há mais de
	 *         2 horas
	 *         <li>UTENTE_ATRASADO_ADIADO se o utente chegou atrasado e isso levou a
	 *         que a hora da consulta fosse adiada
	 *         <li>UTENTE_ATRASADO_FORAHORAS o utente atrsou-se e devido a isso a
	 *         hora de atendimento já fica fora do horário
	 */
	public int validarConsulta(Consulta c) {
		// TODO validar a consulta
		// TODO emitir a senha
		return CONSULTA_ACEITE;
	}

	/**
	 * Emite a senha para a consulta. Se a consulta já está validada, retorna a
	 * senha previamente emitida.
	 * 
	 * @param c           a consulta a qual a senha ficará associada
	 * @param entrada     a data de entrada no sistema
	 * @param atendimento a data prevista de atendimento (pode ser diferente da data
	 *                    da consulta)
	 * @return a senha criada
	 */
	public Senha emiteSenha(Consulta c, LocalDateTime entrada, LocalDateTime atendimento) {
		// TODO implementar este método
		return null;
	}

	/**
	 * Indicação ao sistema de que a consulta terminou. Deve eliminar a consulta e a
	 * senha respetiva
	 * 
	 * @param c a consulta terminada
	 */
	public void terminaConsulta(Consulta c) {
		// TODO implementar este método
	}

	/**
	 * Verica se a consulta pode ser adicionada ao sistema
	 * 
	 * @param c a consulta a testar
	 * @return o resultado deve ser um dos seguintes:
	 *         <li>CONSULTA_ACEITE se a consulta puder ser adicionada ao sistema
	 *         <li>DATA_JA_PASSOU se a data for numa altura anterior à data atual
	 *         <li>UTENTE_JA_TEM_CONSULTA se o utente já tem uma consulta no horário
	 *         indicado
	 *         <li>ESPECIALISTA_JA_TEM_CONSULTA se o o especialista já tiver outra
	 *         consulta na mesma data
	 */
	public int podeAceitarConsulta(Consulta c) {
		// TODO implementar este método
		return CONSULTA_ACEITE;
	}

	/**
	 * Verica se a consulta pode ser alterada
	 * 
	 * @param c a consulta com as alterações
	 * @return o resultado deve ser um dos seguintes:
	 *         <li>CONSULTA_ACEITE se a consulta puder ser adicionada ao sistema
	 *         <li>DATA_JA_PASSOU se a data for numa altura anterior à data atual
	 *         <li>UTENTE_JA_TEM_CONSULTA se o utente já tem uma consulta no horário
	 *         indicado
	 *         <li>ESPECIALISTA_JA_TEM_CONSULTA se o o especialista já tiver outra
	 *         consulta na mesma data
	 *         <li>ALTERACAO_INVALIDA se mudou a especialidade ou o utente na
	 *         consulta
	 */
	public int podeAlterarConsulta(Consulta antiga, Consulta nova) {
		// TODO implementar este método
		return CONSULTA_ACEITE;
	}

	/**
	 * altera uma consulta por outra
	 * 
	 * @param antiga a consulta que será alterada
	 * @param nova   a consulta já com as alterações
	 * @return o resultado deve ser um dos seguintes:
	 *         <li>CONSULTA_ACEITE se a consulta puder ser adicionada ao sistema
	 *         <li>DATA_JA_PASSOU se a data for numa altura anterior à data atual
	 *         <li>UTENTE_JA_TEM_CONSULTA se o utente já tem uma consulta no horário
	 *         indicado
	 *         <li>ESPECIALISTA_JA_TEM_CONSULTA se o o especialista já tiver outra
	 *         consulta na mesma data
	 *         <li>ALTERACAO_INVALIDA se mudou a especialidade ou o utente na
	 *         consulta
	 */
	public int alteraConsulta(Consulta antiga, Consulta nova) {
		// TODO implementar este método
		return CONSULTA_ACEITE;
	}
}
