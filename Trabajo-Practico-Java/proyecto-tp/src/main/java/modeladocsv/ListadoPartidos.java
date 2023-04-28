package modeladocsv;

import com.opencsv.bean.CsvBindByPosition;

public class ListadoPartidos  {
	@CsvBindByPosition(position= 0)
	private Integer numFase;
	
	@CsvBindByPosition(position= 1)
	private Integer idPartido;
	@CsvBindByPosition(position= 2)
	private Integer idRonda;
	@CsvBindByPosition(position= 3)
	private Integer numRonda;	
	@CsvBindByPosition(position= 4)
	private Integer idEquipo1;
	@CsvBindByPosition(position= 5)
	private String nombreEquipo1;
	@CsvBindByPosition(position= 6)
	private String descripcionEquipo1;
	@CsvBindByPosition(position= 7)
	private String golesEquipo1;
	@CsvBindByPosition(position= 8)
	private String golesEquipo2;
	@CsvBindByPosition(position= 9)
	private Integer idEquipo2;
	@CsvBindByPosition(position= 10)
	private String nombreEquipo2;
	@CsvBindByPosition(position= 11)
	private String descripcionEquipo2;
	
	
	@Override
	public String toString() {
		return "ListadoPartidos [numFase=" + numFase + ", idPartido=" + idPartido + ", idRonda=" + idRonda
				+ ", numRonda=" + numRonda + ", idEquipo1=" + idEquipo1 + ", nombreEquipo1=" + nombreEquipo1
				+ ", descripcionEquipo1=" + descripcionEquipo1 + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2="
				+ golesEquipo2 + ", idEquipo2=" + idEquipo2 + ", nombreEquipo2=" + nombreEquipo2
				+ ", descripcionEquipo2=" + descripcionEquipo2 + "]";
	}
	
	
	public Integer getNumFase() {
		return numFase;
	}


	public void setNumFase(Integer numFase) {
		this.numFase = numFase;
	}


	public Integer getIdRonda() {
		return idRonda;
	}
	public void setIdRonda(Integer idRonda) {
		this.idRonda = idRonda;
		
	}
	public Integer getNumRonda() {
		return numRonda;
		
	}
	public void setNumRonda(Integer numRonda) {
		this.numRonda = numRonda;
	}

	public void setGolesEquipo1(String golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public void setGolesEquipo2(String golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public Integer getIdEquipo1() {
		return idEquipo1;
	}

	public void setIdEquipo1(Integer idEquipo1) {
		this.idEquipo1 = idEquipo1;
	}

	public String getNombreEquipo1() {
		return nombreEquipo1;
	}

	public void setNombreEquipo1(String nombreEquipo1) {
		this.nombreEquipo1 = nombreEquipo1;
	}

	public String getDescripcionEquipo1() {
		return descripcionEquipo1;
	}

	public void setDescripcionEquipo1(String descripcionEquipo1) {
		this.descripcionEquipo1 = descripcionEquipo1;
	}

	public static boolean esNumero(String golesEquipo) {
		boolean resultado;
		try {
			Integer.parseInt(golesEquipo);
			resultado = true;
			
		} catch (NumberFormatException exception) {
			resultado = false;
		}
		return resultado;
	}
	
	
	public Integer getGolesEquipo1() throws FormatoGolesIncorrectoException {
		int temporal = -1;
    	if(esNumero(golesEquipo1)) {
    		return temporal = Integer.parseInt(golesEquipo1);
    	}else {
    		throw new FormatoGolesIncorrectoException(golesEquipo1);
    	}
    	
		//return temporal;
		/*try {
			temporal = Integer.parseInt(golesEquipo1);
			return temporal;
			
		/*}catch(Exception ex ) {
			//System.out.println("los goles del equipo 1 no tienen el formado de numero");
		}*/
		//return temporal;
	}
	
	
    public Integer getGolesEquipo2() throws FormatoGolesIncorrectoException {
    	int temporal = -1;
    	if(esNumero(golesEquipo2)) {
    		return temporal = Integer.parseInt(golesEquipo2);
    	}else {
    		throw new FormatoGolesIncorrectoException(golesEquipo2);
    	}
    	//return temporal;
    	
		/*try {
			temporal = Integer.parseInt(golesEquipo2);
			return temporal;
		}catch(NumberFormatException ex ) {
			System.out.println("los goles del equipo 2 no tienen el formado de numero");
		}
		return temporal;*/
	}
	
	
	public Integer getIdEquipo2() {
		return idEquipo2;
	}

	public void setIdEquipo2(Integer idEquipo2) {
		this.idEquipo2 = idEquipo2;
	}
	
	public String getNombreEquipo2() {
		return nombreEquipo2;
	}
	
	public void setNombreEquipo2(String nombreEquipo2) {
		this.nombreEquipo2 = nombreEquipo2;
	}
	
	public String getDescripcionEquipo2() {
		return descripcionEquipo2;
	}
	
	public void setDescripcionEquipo2(String descripcionEquipo2) {
		this.descripcionEquipo2 = descripcionEquipo2;
	}
	
	public Integer getIdPartido() {
		return idPartido;
	}
	
	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}
}
