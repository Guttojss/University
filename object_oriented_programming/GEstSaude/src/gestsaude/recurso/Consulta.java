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
		if(utente.sns == null)
			return false;
		if(especialidade.id == null)
			return false;
		if(this.getHoraMarcacao().isBefore(LocalTime.of(8, 10)) || this.getHoraMarcacao().isAfter(LocalTime.of(19, 50)))
			return false;

		return true;
	}

}

/*
- O utente tem de estar identificado;
- A especialidade tem de estar identificada;
- O horário deve estar entre as 8h10 e as 19:50;

- O intervalo entre consultas na mesma especialidade deve ser de 10 minutos;
- O utente não pode ter duas consultas, no mesmo dia, com diferença inferior a 3 horas; 
*/