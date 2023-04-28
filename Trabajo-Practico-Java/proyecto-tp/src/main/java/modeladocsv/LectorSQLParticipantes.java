package modeladocsv;
import java.util.ArrayList;

import clasesProyecto.Participantes;
import clasesProyecto.Pronostico;
//para la coneccion bd
import java.sql.*;
import static conexion.sql.ConectorSQL.DB_URL;
import static conexion.sql.ConectorSQL.PASS;
import static conexion.sql.ConectorSQL.USER;

public class LectorSQLParticipantes {
	
	public static ArrayList<Participantes> obtenerParticipantes(ArrayList<Pronostico> pronostico){
		ArrayList<Participantes> participante =new ArrayList();
		Connection conexion= null;
		Statement consulta = null;
		
		try {
			//abrir la coneccion 
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			//ejecutar la consulta
			consulta = conexion.createStatement();
			String sql = "select * from pronosticospartidos.participantes";
			ResultSet resultado = consulta.executeQuery(sql);
			
			//obtener los objetos instanciarlos
			while(resultado.next()) {
				boolean partExistente = false;
				
				int id_participante = resultado.getInt("id_participante");
			
				String nombre = resultado.getString("nombre");
				
				String apellido = resultado.getString("apellido");
			
				Participantes nuevoParticipante = new Participantes(id_participante, nombre,apellido);
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
					if(pron.getIdParticipante() == nuevoParticipante.getIdParticipante() ) {
						nuevoParticipante.agregarPronostico(pron);
					}
				}
				
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
				
			}
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return participante;
	}

}
