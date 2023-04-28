package clasesProyecto;

import java.util.ArrayList;

public class Rondas {
	private int numFase;
	private int idRonda;
	private int numRonda;
	private ArrayList<Partido> partido;
	
	public Rondas(int numFase,int idRonda, int numRonda, ArrayList<Partido> partido) {
		this.numFase= numFase;
		this.idRonda = idRonda;
		this.numRonda = numRonda;
		this.partido = partido;
	}
	
	public int getNumFase() {
		return numFase;
	}

	public void setNumFase(int numFase) {
		this.numFase = numFase;
	}

	public int obteneridEquipo1(){
		int idEquipo1 = 0;
		for(Partido part:partido) {
			idEquipo1 = part.getEquipo1().getIdEquipo();
		}
		return idEquipo1;
	}

	public int obteneridEquipo2(){
		int idEquipo2 = 0;
		for(Partido part:partido) {
			idEquipo2 = part.getEquipo2().getIdEquipo();
		}
		return idEquipo2;
		
	}

	public Partido obtenerPartido(int equipo1, int equipo2) {
		Partido partidoPron= null;
		
		for(Partido part :partido) {
			if((part.getEquipo1().getIdEquipo() == equipo1) && (part.getEquipo2().getIdEquipo()== equipo2) ) {
				return partidoPron= part;
			}
		}
		return partidoPron;
	}
	
	/*public Equipos obtenerEquipo1(){
		 Equipos equipo1 = null;
		for(Partido part:partido) {
			equipo1 = part.getEquipo1();
		}
		return equipo1;
	}
	
	public Equipos obtenerEquipo2(){
		Equipos equipo2 = null;
		for(Partido part:partido) {
			equipo2 = part.getEquipo2();
		}
		return equipo2;
		
	}*/
	

	public ArrayList<Partido> getPartido() {
		return partido;
	}

	public void setPartido(ArrayList<Partido> partido) {
		this.partido = partido;
	}

	public int getIdRonda() {
		return idRonda;
	}

	public void setIdRonda(int idRonda) {
		this.idRonda = idRonda;
	}

	public int getNumRonda() {
		return numRonda;
	}

	public void setNumRonda(int numRonda) {
		this.numRonda = numRonda;
	}


	@Override
	public String toString() {
		return "Rondas [numFase=" + numFase + ", idRonda=" + idRonda + ", numRonda=" + numRonda + ", partido=" + partido
				+ "]";
	}

}
