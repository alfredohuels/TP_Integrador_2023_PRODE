package clasesProyecto;

import java.util.ArrayList;
import java.util.List;

public class Pronostico {
	private int idPronostico;
	//private String participante;
	private int idParticipante;
	private int numFase;
	private Partido partido;
	private Equipos equipo;
	private Resultado resultadoPronostico;
	

	@Override
	public String toString() {
		return "Pronostico [idPronostico=" + idPronostico + ", idParticipante=" + idParticipante + ", numFase="
				+ numFase + ", partido=" + partido + ", equipo=" + equipo + ", resultadoPronostico="
				+ resultadoPronostico + "]";
	}


	public int getIdParticipante() {
		return idParticipante;
	}


	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}



	public Pronostico(int idPronostico, int idParticipante, int numFase, Partido partido, Equipos equipo,
			Resultado resultadoPronostico) {
		
		this.idPronostico = idPronostico;
		this.idParticipante = idParticipante;
		this.numFase = numFase;
		this.partido = partido;
		this.equipo = equipo;
		this.resultadoPronostico = resultadoPronostico;
	}



	public int getNumFase(int ronda) {
		int numFase = 0;
		if(partido.getIdronda() == ronda) {
			numFase = partido.getNumFase();
		}
		return numFase;		
	}


	public void setNumFase(int numFase) {
		this.numFase = numFase;
	}



	public Partido getPartido() {
		return partido;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	public int getIdPronostico() {
		return idPronostico;
	}

	public void setIdPronostico(int idPronostico) {
		this.idPronostico = idPronostico;
	}


	public float obtenerPuntos() {
		
		Resultado resultadoReal = partido.obtenerResultado(equipo, partido.getIdronda());
		if (this.resultadoPronostico.equals(resultadoReal) ){			
		    return 0.5f;		    
		} 		
		else {
			return 0; 
		}
			
	}
	
	
	



	public Equipos getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}


	public Resultado getResultadoPronostico() {
		return resultadoPronostico;
	}


	public void setResultadoPronostico(Resultado resultadoPronostico) {
		this.resultadoPronostico = resultadoPronostico;
	}
	
	
	
	
	
	
	
	

}
