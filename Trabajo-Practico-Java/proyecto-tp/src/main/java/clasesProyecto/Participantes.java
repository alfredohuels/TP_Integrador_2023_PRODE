
package clasesProyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Participantes {
	private int idParticipante;
	private String nombreParticipante;
	private String apellidoParticipante;
	private ArrayList<Pronostico> pronostico;
	HashMap<Integer, Float>totalesPart = new HashMap<Integer,Float>();
	
    public void imprimirAsterisco (){
    	System.out.println("***************************************************************");
    }
	
    public void imprimir (String texto) {
    	if (texto.length()>((texto.length()/2)*2)) {
      	    texto = " "+texto;
      	}

    	int largoTexto = texto.length()/2; 	

    	System.out.print("* ");
    	for (int i = 0; i < 30-largoTexto; i++) {
		   System.out.print(" ");
		}
    	    	
    	System.out.print(texto);
    	
    	for (int i = 0; i < 30-largoTexto; i++) {
			System.out.print(" ");
    	}	
    	System.out.println("*");
    }
	
	
	public void totalesParticipante (int participante) {
		float totales = 0;
		//float totalesNuevaRonda = 0;
		//float parcial= 0;
		boolean acertoRonda = false;
		//int cantRondasAcertadas = 0;
		String nombreCompleto = "";
		//String apostador = "";
		//float totalPuntos = 0;
		float extraPorRondaPerfecta = 3.0f;
		int ronda = 0;
		
		ArrayList<Integer> rondasAcertadas = new ArrayList<Integer>();
		ArrayList<Integer>fasesAcertadas = new ArrayList<Integer>();
		
		String participanteAcerto= "";
		Set<Integer> keys = totalesPart.keySet();
		
		for(Pronostico pro:pronostico) {
			if(ronda!= pro.getPartido().getIdronda()) {
				totales= 0; //reseteo totales cuando cambio de ronda
			}
			ronda =  pro.getPartido().getIdronda();
			
			
			if(pro.getIdParticipante() == participante) {
				
				nombreCompleto = this.apellidoParticipante + " " +  this.nombreParticipante;
				
				totales += pro.obtenerPuntos();
				if(totales == 4) {
					acertoRonda= true;
					
					rondasAcertadas.add(ronda);
					fasesAcertadas.add(pro.getNumFase(ronda));
					
				}
				
			}

			totalesPart.put(ronda, totales);	
			
		}
		
		imprimirAsterisco ();
		System.out.println("****************          P  R  O  D  E         ***************");
		imprimirAsterisco ();
		System.out.println("");
		imprimirAsterisco ();
		System.out.println("****************        TOTALES OBTENIDOS       ***************");
		System.out.println("****************               POR              ***************");
		imprimirAsterisco ();
		imprimir ("Participante : "+nombreCompleto);
		imprimirAsterisco ();
		System.out.println("");
		float totalParticipante = 0;
		String pts;

		for (Integer key: keys){
			if (totalesPart.get(key)<= 1) {
				pts = " punto.";
			} else {
				pts = " puntos.";
			}
			
			System.out.println("                En "+key+"º Ronda Obtuvo ===> " + Math.round(totalesPart.get(key))+pts  );
			  totalParticipante += totalesPart.get(key) ;
			
		} 
		
		System.out.println("");
//		imprimirAsterisco ();
		System.out.println("                  PUNTOS TOTALES DE LAS RONDAS:  ");
		System.out.println("                            "+ Math.round(totalParticipante)+" puntos");
		System.out.println("");
		imprimirAsterisco ();
		
		if(acertoRonda) {
			int fase= 0;
			//int cantFase1 = 0;
			//int cantFase2 = 0;
			
			int cantAciertos = 0;
			int cantFases = 0;
			System.out.print("        PUNTAJE EXTRA DE 3 PUNTOS POR CADA RONDA PERFECTA");
			
			System.out.println("");
			System.out.println("");
			for(Integer ro: rondasAcertadas) {
				System.out.println("                       Ronda premiada:  " + ro+"º");
				 cantAciertos = rondasAcertadas.size();
				 
			}
		  ArrayList<Integer> repetidaFase = new ArrayList<Integer>();
			for(int i = 0; i < fasesAcertadas.size() ; i ++) {
				for(int j = i+1 ; j < fasesAcertadas.size(); j ++) {
					if(fasesAcertadas.get(i) == fasesAcertadas.get(j)) {
						repetidaFase.add(fasesAcertadas.get(i));
						
					}
					
				}
				
			}
			
			int puntajeTotal = (int) (totalParticipante + (cantAciertos * 3));
			
			System.out.println(""); 
		//	imprimirAsterisco ();
			System.out.println("                 TOTAL DE PUNTOS POR RONDA PERFECTA: ");
			System.out.println("                             "+Math.round(cantAciertos * 3)+" puntos.");
			System.out.println("");
			imprimirAsterisco ();
			System.out.println("");
					
			for (Integer faserep:repetidaFase) {
		//		imprimirAsterisco ();
				System.out.println("        PUNTAJE EXTRA DE 4 PUNTOS POR CADA FASE PERFECTA:");
				System.out.println("");
				System.out.println("                       Fase premiada:  " + faserep+"º");
				 cantFases = repetidaFase.size();
				
			}
			
			int puntajeTotalFase = puntajeTotal + (cantFases * 4);
			
			System.out.println("");
	//		imprimirAsterisco ();
			System.out.println("                 TOTAL GENERAL POR FASE PERFECTA:");
			System.out.println("                            "+ (cantFases * 4) +" puntos");
			System.out.println("");
	//		imprimirAsterisco ();
		//	System.out.println("");
						
			
	//		if(puntajeTotalFase != puntajeTotal) {
				
				imprimirAsterisco ();
				imprimirAsterisco ();
				System.out.println("   TOTAL GENERAL POR RONDA, RONDA PERFECTA Y FASE PERFECTA:");
				System.out.println("                            "+ puntajeTotalFase+" puntos");
				imprimirAsterisco ();
				imprimirAsterisco ();
				System.out.println("");System.out.println("");System.out.println("");
//			}
			
		}

				
	}
	

	public String getApellidoParticipante() {
		return apellidoParticipante;
	}


	public void setApellidoParticipante(String apellidoParticipante) {
		this.apellidoParticipante = apellidoParticipante;
	}


	public Participantes(int idParticipante, String nombreParticipante, String apellidoParticipante) {
		
		this.idParticipante = idParticipante;
		this.nombreParticipante = nombreParticipante;
		this.apellidoParticipante = apellidoParticipante;
		pronostico = new ArrayList<Pronostico>();
	}
	
	public void agregarPronostico(Pronostico p) {
		if(!existePronostico(p)) {
			this.pronostico.add(p);
			
		}
		
	}
	
	public boolean existePronostico(Pronostico p) {
		for(Pronostico pron: pronostico) {
			if((pron.getPartido() == p.getPartido()) && (pron.getEquipo() == p.getEquipo())) {
				return true;
			}
		}
		return false;
	}
	
	




	public ArrayList<Pronostico> getPronostico() {
		return pronostico;
	}

	public void setPronostico(ArrayList<Pronostico> pronostico) {
		this.pronostico = pronostico;
	}

	public int getIdParticipante() {
		return idParticipante;
	}


	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}


	public String getNombreParticipante() {
		return nombreParticipante;
	}


	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}

	@Override
	public String toString() {
		return "Participantes [idParticipante=" + idParticipante + ", nombreParticipante=" + nombreParticipante
				+ ", pronostico=" + pronostico + "]";
	}


	

	
	
	
	
	
	
	

}
