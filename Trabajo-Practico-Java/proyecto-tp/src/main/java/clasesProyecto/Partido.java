
package clasesProyecto;

public class Partido {
	private int numFase;
	private int idPartido;
	private int idronda;
	private Equipos equipo1;
	private Equipos equipo2;
	private Integer golesEquipo1;
	private Integer golesEquipo2;
	

	public Partido(int numFase, int idPartido, int idronda, Equipos equipo1, Equipos equipo2, Integer golesEquipo1,
			Integer golesEquipo2) {
	
		this.numFase = numFase;
		this.idPartido = idPartido;
		this.idronda = idronda;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
	}
	

	@Override
	public String toString() {
		return "Partido [numFase=" + numFase + ", idPartido=" + idPartido + ", idronda=" + idronda + ", equipo1="
				+ equipo1 + ", equipo2=" + equipo2 + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2
				+ "]";
	}


	public int getNumFase() {
		return numFase;
	}


	public void setNumFase(int numFase) {
		this.numFase = numFase;
	}


	public int getIdronda() {
		return idronda;
	}


	public void setIdronda(int idronda) {
		this.idronda = idronda;
	}


	public void setGolesEquipo1(Integer golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}


	public void setGolesEquipo2(Integer golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	
	public int getIdPartido() {
		return idPartido;
	}

	
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}



	public Resultado obtenerResultado(Equipos equipo, int idRondaRecibida) {
		Resultado resultadoReal= null;
		// se verifica que la el partido sea de la ronda que se esta recibiendo el pronostico
		if(this.idronda   == idRondaRecibida) {
			if(this.golesEquipo1 > this.golesEquipo2) {
				
				if(this.equipo1 == equipo) {
					resultadoReal = Resultado.GANADOR;
				}else {
					resultadoReal = Resultado.PERDEDOR;
				}
			}else if(this.golesEquipo1 < this.golesEquipo2) {
				if(this.equipo2 == equipo) {
					resultadoReal = Resultado.GANADOR;
				}else {
					resultadoReal =Resultado.PERDEDOR;
				}
			}else {
				
				resultadoReal = Resultado.EMPATE;
			}
			
		}
		return resultadoReal;
		
	}
	

	public Equipos getEquipo1() {
		return equipo1;
	}


	public void setEquipo1(Equipos equipo1) {
		this.equipo1 = equipo1;
	}


	public Equipos getEquipo2() {
		return equipo2;
	}


	public void setEquipo2(Equipos equipo2) {
		this.equipo2 = equipo2;
	}


	public int getGolesEquipo1() {
		return golesEquipo1;
	}


	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}


	public int getGolesEquipo2() {
		return golesEquipo2;
	}


	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
	

}
