package gestsaude.recurso;

import java.time.LocalTime;

/**
 * Representa uma Senha. Deve ter um número (letra e número, por exemplo A1, A2,
 * A12), a hora de entrada e a hora prevista de atendimento e qual a consulta
 * associada.
 */
public class Senha {

	private GEstSaude gest; // deve ter ligação ao sistema
		
	String id;
	Consulta consulta;
	LocalTime horaEntrada; 
	LocalTime horaPrevista; 

	private Senha(String id, LocalTime horaEntrada, LocalTime horaPrevista, Consulta consulta){
		this.id = id;
		this.horaEntrada = horaEntrada;
		this.horaPrevista = horaPrevista;
		this.consulta = consulta;
	}

	public String getId(){
		return this.id;
	}

	public LocalTime getHoraEntrada( ){
		return this.horaEntrada;
	}

	public LocalTime getHoraPrevista(){
		return this.horaPrevista;
	}

	public Consulta getConsulta(){
		return this.consulta;
	}

	public void setId(String id){
		this.id = id;
	}

	public void setHoraEntrada(LocalTime entrada){
		this.horaEntrada = entrada;
	}

	public void setHoraPrevista(LocalTime prevista){
		this.horaPrevista = prevista;
	}

	public void setConsulta(Consulta consulta){
		this.consulta = consulta;
	}

	/**
	 * Indica qual o próximo serviço que tem de visitar
	 * 
	 * @return o serviço que tem de visitar ou null se não tiver serviços a visitar
	 */
	public Servico servicoAtual() {
		// TODO implementar este método
		return null;
	}

	/**
	 * Terminou o atendimento na consulta ou serviço atual. Se ainda tem serviços
	 * por visitar, deve passar para o próximo
	 */
	public void terminaAtendimento() {
		// TODO implementar este método
	}
}
