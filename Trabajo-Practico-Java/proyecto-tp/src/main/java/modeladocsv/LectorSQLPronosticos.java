package modeladocsv;
import java.util.ArrayList;

import clasesProyecto.Partido;
import clasesProyecto.Pronostico;
import clasesProyecto.Resultado;
import clasesProyecto.Rondas;

//para la coneccion bd
import java.sql.*;
import static conexion.sql.ConectorSQL.DB_URL;
import static conexion.sql.ConectorSQL.PASS;
import static conexion.sql.ConectorSQL.USER;
public class LectorSQLPronosticos {
	
	//metodo
	public static ArrayList<Pronostico> obtenerPronosticos(ArrayList<Rondas> rondas) {
		
       ArrayList<Pronostico> pronostico = new ArrayList();
       Connection conexion= null;
		Statement consulta = null;
		
		try {
			//abrir la coneccion 
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			//ejecutar la consulta
			consulta = conexion.createStatement();
			String sql = "select * from pronosticospartidos.pronosticos";
			ResultSet resultado = consulta.executeQuery(sql);
			
			//obtener los objetos instanciarlos
			while(resultado.next()) {
				//Rondas ronda = null;
				if(resultado.getInt("gana_1") == 1) {
					int idParticipante = resultado.getInt("id_participante");
					//String nombreParticipante = lineaPronostico.getNombreParticipante();
					int idPronostico = resultado.getInt("id_pronosticos");
					int idequipo1 = resultado.getInt("id_Equipo1");
					int idequipo2 = resultado.getInt("id_Equipo2");				
					for(Rondas rondaPartidos : rondas) {
						int numFase = rondaPartidos.getNumFase();
						
						Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
						Pronostico unPronostico = new Pronostico(
									idPronostico,
									idParticipante,
									numFase,
									partidoPronosticado,
									partidoPronosticado.getEquipo1(),
									Resultado.GANADOR
									);
							pronostico.add(unPronostico);
					}
					for(Rondas rondaPartidos : rondas) {
						int numFase = rondaPartidos.getNumFase();
						Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
						Pronostico unPronostico = new Pronostico(
									idPronostico,
									idParticipante,
									numFase,
									partidoPronosticado,
									partidoPronosticado.getEquipo2(),
									Resultado.PERDEDOR
									);
							pronostico.add(unPronostico);
					}
					
				}//fin gana1
				if(resultado.getInt("empata") == 1)
				{
					int idParticipante = resultado.getInt("id_participante");
					//String nombreParticipante = lineaPronostico.getNombreParticipante();
					int idPronostico = resultado.getInt("id_pronosticos");
					int idequipo1 = resultado.getInt("id_Equipo1");
					int idequipo2 = resultado.getInt("id_Equipo2");				
					for(Rondas rondaPartidos : rondas) {
						int numFase = rondaPartidos.getNumFase();
						Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
						Pronostico unPronostico = new Pronostico(
									idPronostico,
									idParticipante,
									numFase,
									partidoPronosticado,
									partidoPronosticado.getEquipo1(),
									Resultado.EMPATE
									);
							pronostico.add(unPronostico);
					}

					for(Rondas rondaPartidos : rondas) {
						int numFase = rondaPartidos.getNumFase();
						Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
						Pronostico unPronostico = new Pronostico(
									idPronostico,
									idParticipante,
									numFase,
									partidoPronosticado,
									partidoPronosticado.getEquipo2(),
									Resultado.EMPATE
									);
							pronostico.add(unPronostico);
					}
					
				}//fin empata
				
				if(resultado.getInt("gana_2") == 1)
				{
					int idParticipante = resultado.getInt("id_participante");
					//String nombreParticipante = lineaPronostico.getNombreParticipante();
					int idPronostico = resultado.getInt("id_pronosticos");
					int idequipo1 = resultado.getInt("id_Equipo1");
					int idequipo2 = resultado.getInt("id_Equipo2");				
					for(Rondas rondaPartidos : rondas) {
						int numFase = rondaPartidos.getNumFase();
						Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
						Pronostico unPronostico = new Pronostico(
									idPronostico,
									idParticipante,
									numFase,
									partidoPronosticado,
									partidoPronosticado.getEquipo2(),
									Resultado.GANADOR
									);
							pronostico.add(unPronostico);
					}

					for(Rondas rondaPartidos : rondas) {
						int numFase = rondaPartidos.getNumFase();
						Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
						Pronostico unPronostico = new Pronostico(
									idPronostico,
									idParticipante,
									numFase,
									partidoPronosticado,
									partidoPronosticado.getEquipo1(),
									Resultado.PERDEDOR
									);
							pronostico.add(unPronostico);
					}
				}//fin gana2
			}
			
			//cerrar la base de datos
			resultado.close();
			consulta.close();
			conexion.close();
			
		}catch(SQLException se) {
			System.out.println(se.getErrorCode());
			se.printStackTrace();
			
		}finally {
			try {
				if(consulta!= null)
					consulta.close();
			}catch(SQLException se2) {
				// Hacer Excepcion
			}
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
				
			}
		}
		return pronostico;
		
	}

}