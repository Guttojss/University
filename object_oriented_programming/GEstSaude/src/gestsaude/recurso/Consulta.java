package gestsaude.recurso;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa uma Consulta. Deve ter o dia e hora da marcação, o utente e a
 * especialidade.
 */
public class Consulta {

	/**
	 * Indica se a consulta já está validada
	 * 
	 * @return true, se a consulta já está validada
	 */

	Utente utente;
	Especialidade especialidade;
	LocalTime horaMarcacao;
	LocalDate diaMarcacao;

	private Consulta(Utente utente, Especialidade especialidade, LocalTime hora, LocalDate dia){
		this.utente = utente;
		this.especialidade = especialidade;
		this.horaMarcacao = hora;
		this.diaMarcacao = dia;
	}

	public Utente getUtente(){
		return this.utente;
	}

	public Especialidade getEspecialidade(){
		 return this.especialidade;
	}
	public LocalTime getHoraMarcacao(){
		 return this.horaMarcacao;
	}
	public LocalDate getDiaMarcacao(){
		 return this.diaMarcacao;
	}

	public void setUtente(Utente utente){
		this.utente = utente;
	}
	public void setEspecialidade(Especialidade especialidade){
		this.especialidade = especialidade;
	}
	public void setHora(LocalTime hora){
		this.horaMarcacao = hora;
	}
	public void setDia(LocalDate dia){
		this.diaMarcacao = dia;
	}



	// Metodos
	public boolean estaValidada() {
		// TODO implementar este método
		return false;
	}

}
