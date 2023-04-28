package clasesProyecto;

import java.util.ArrayList;

public class Equipos {
	private int idEquipo;
	private String nombreEquipo;
	private String descripcion;
	
	
	public Equipos(int idEquipo, String nombreEquipo, String descripcion) {
		
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.descripcion = descripcion;
	}
	

	@Override
	public String toString() {
		return "Equipos [idEquipo=" + idEquipo + ", NombreEquipo=" + nombreEquipo + ", Descripcion=" + descripcion
				+ "]";
	}


	public int getIdEquipo() {
		return idEquipo;
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public String getDescripcion() {
		return descripcion;
	}
	
	
	public static Equipos buscarEquipo(ArrayList<Equipos> equipo, Integer identificador) {
		for(Equipos equipoenlista : equipo) {
			if(equipoenlista.getIdEquipo() == identificador) {
				return equipoenlista;
			}
		}
		return null;
		
	}

}
