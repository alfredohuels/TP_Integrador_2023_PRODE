package clasesProyecto;

import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//import org.apache.commons.collections.bag.SynchronizedSortedBag;

import modeladocsv.ListadoPartidos;
import modeladocsv.ListadoPronosticos;
import modeladocsv.NumeroDeCamposException;
import modeladocsv.LectorResultadosCsv;
import modeladocsv.LectorSQLParticipantes;
//import modeladocsv.LectorSQLEquipos;
import modeladocsv.LectorSQLPronosticos;
import modeladocsv.FormatoGolesIncorrectoException;
import modeladocsv.LectorPronosticosCsv;

//import com.opencsv.bean.CsvToBeanBuilder;

public class Principal {

	public static void main(String[] args) throws NumeroDeCamposException, FormatoGolesIncorrectoException {
		
		String rutaArchivo = "src\\main\\resources\\resultados2fases4rondas.csv";

		//String rutaPronostico = "src\\main\\resources\\pronostico2da.csv";
		
		LectorResultadosCsv lectorArchivos = new LectorResultadosCsv(rutaArchivo); //debe lanzar excepciones
		//lector del archivo de pronosticos
		//LectorPronosticosCsv lectorArchivoPro = new LectorPronosticosCsv(rutaPronostico);
		
		//verifico la cantidad de campos del archivo resultados
		boolean correcto =lectorArchivos.cantidadCampos();
		if(correcto) {
			//obtengo las lineas del archivo CSV correspondiente a partidos
			lectorArchivos.parsearArchivo();
			//lectorArchivoPro.parsearPronostico();
		}
		
		//genera lista con equipos
		ArrayList<Equipos> equipos = lectorArchivos.listarEquipos();

		
		//generar lista de partidos
		ArrayList<Partido> partido = lectorArchivos.listarPartidos(equipos);
		
		//genero lista de rondas
		ArrayList<Rondas> rondas = lectorArchivos.listarRondas(partido);
		
		//genera lista con pronosticos
		//ArrayList<Pronostico> pronostico = lectorArchivoPro.listarPronosticos(rondas);
		
		//ArrayList<Participantes> participante = lectorArchivoPro.listarParticipantes(pronostico);
		
		//genera lista con pronosticos de mysql

        ArrayList<Pronostico> pronostico= LectorSQLPronosticos.obtenerPronosticos(rondas);
		ArrayList<Participantes> participante = LectorSQLParticipantes.obtenerParticipantes(pronostico);
		
		for(Participantes part:participante) {		
		    part.totalesParticipante(part.getIdParticipante());			
			
		}
		
	}
	
}
