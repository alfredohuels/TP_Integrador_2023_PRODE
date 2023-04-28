package modeladocsv;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import clasesProyecto.Pronostico;
import clasesProyecto.Resultado;
import clasesProyecto.Partido;
import clasesProyecto.Rondas;
import clasesProyecto.Equipos;
import clasesProyecto.Participantes;

public class LectorPronosticosCsv {
	/*String rutaPronostico;
	List<ListadoPronosticos> lineaPronostico;
	
	public LectorPronosticosCsv(String ruta) {
		this.rutaPronostico = ruta;
		this.lineaPronostico = new ArrayList();
		}
	
	public void parsearPronostico() {
		List<ListadoPronosticos> listadoPron = null;
		try {
			listadoPron = new CsvToBeanBuilder(new FileReader(this.rutaPronostico))
					.withType(ListadoPronosticos.class)
					.withSkipLines(1)
					.withSeparator(',')
					.build()
					.parse();
		}catch (IOException e) {
	        e.printStackTrace();
		}
		this.lineaPronostico = listadoPron;
	}
	
	public ArrayList<Participantes> listarParticipantes(ArrayList<Pronostico> pronostico){
		ArrayList<Participantes> participante =new ArrayList();
		boolean partExistente = false;
		
		for(ListadoPronosticos lineaPronostico : this.lineaPronostico) {
			partExistente = false;
			//llama al constructor
			Participantes nuevoParticipante = new Participantes(
					lineaPronostico.getIdParticipante(),
					lineaPronostico.getNombreParticipante()
					);
					
			for(Participantes partCargado: participante) {
				if(nuevoParticipante.getIdParticipante() == partCargado.getIdParticipante()) {
					partExistente = true;
					break;
					
				}
			}

			//agrego un nuevo participante en la lista 
			if(!partExistente) {
				participante.add(nuevoParticipante);
			}
			
			for(Pronostico pron:pronostico) {
				if(pron.getParticipante().equals(nuevoParticipante.getNombreParticipante())) {
					nuevoParticipante.agregarPronostico(pron);
				}
			}
			
		}
		return participante;
	}
	
	
	public ArrayList<Pronostico> listarPronosticos(ArrayList<Rondas> ronda){
    
		ArrayList<Pronostico> pronostico = new ArrayList();
		
		for(ListadoPronosticos lineaPronostico : this.lineaPronostico) {
			
			//me fijo donde esta la x
			if(lineaPronostico.getGanaEquipo1().equals("X")) {
				//busco el id del participante
				int idParticipante = lineaPronostico.getIdParticipante();
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				int idPronostico = lineaPronostico.getIdPronostico();
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();				
				for(Rondas rondaPartidos : ronda) {
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								Resultado.GANADOR
								);
						pronostico.add(unPronostico);
				}
		
				for(Rondas rondaPartidos : ronda) {
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								Resultado.PERDEDOR);
						pronostico.add(unPronostico);
				}
				
			}// fin if gana equipo 1
			
			if(lineaPronostico.getEmpate().equals("X")) {
				//busco el id del participante
				int idParticipante = lineaPronostico.getIdParticipante();
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				int idPronostico = lineaPronostico.getIdPronostico();
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				for(Rondas rondaPartidos : ronda) {
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								Resultado.EMPATE
								);
						pronostico.add(unPronostico);
				}
				
				for(Rondas rondaPartidos : ronda) {
					
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								Resultado.EMPATE
								);
						pronostico.add(unPronostico);
						}
			}// fin de empate
			
			if(lineaPronostico.getGanaEquipo2().equals("X")) {
				
				int idPronostico = lineaPronostico.getIdPronostico();
				int idParticipante = lineaPronostico.getIdParticipante();
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				for(Rondas rondaPartidos : ronda) {
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								Resultado.GANADOR
								);
						pronostico.add(unPronostico);
					}

				for(Rondas rondaPartidos : ronda) {
					
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								Resultado.PERDEDOR
								);
						pronostico.add(unPronostico);
					}
			
			}//fin gana 2
			
		}//fin de recorrer el for listado pronostico
		return pronostico;
		
	}*/

}
	
	
	
	




