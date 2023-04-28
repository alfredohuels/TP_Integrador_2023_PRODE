package modeladocsv;

import com.opencsv.bean.CsvBindByPosition;

public class ListadoPronosticos {
	@CsvBindByPosition(position= 0)
	private Integer idPronostico;
	@CsvBindByPosition(position= 1)
	private Integer idParticipante;
	@CsvBindByPosition(position= 2)
	private String nombreParticipante;
	@CsvBindByPosition(position= 3)
	private Integer idEquipo1;
	@CsvBindByPosition(position= 4)
	private String ganaEquipo1;
	@CsvBindByPosition(position= 5)
	private String empate;
	@CsvBindByPosition(position= 6)
	private String ganaEquipo2;
	@CsvBindByPosition(position= 7)
	private Integer idEquipo2;
		
	
	@Override
	public String toString() {
		return "ListadoPronosticos [idPronostico=" + idPronostico + ", idParticipante=" + idParticipante
				+ ", nombreParticipante=" + nombreParticipante + ", idEquipo1=" + idEquipo1 + ", ganaEquipo1="
				+ ganaEquipo1 + ", empate=" + empate + ", ganaEquipo2=" + ganaEquipo2 + ", idEquipo2=" + idEquipo2
				+ "]";
	}
	public Integer getIdPronostico() {
		return idPronostico;
	}
	
	public void setIdPronostico(Integer idPronostico) {
		this.idPronostico = idPronostico;
	}
	
	public Integer getIdParticipante() {
		return idParticipante;
	}
	
	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}
	
	public String getNombreParticipante() {
		return nombreParticipante;
	}
	
	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}
	
	public Integer getIdEquipo1() {
		return idEquipo1;
	}
	
	public void setIdEquipo1(Integer idEquipo1) {
		this.idEquipo1 = idEquipo1;
	}
	
	public String getGanaEquipo1() {
		return ganaEquipo1;
	}
	
	public void setGanaEquipo1(String ganaEquipo1) {
		this.ganaEquipo1 = ganaEquipo1;
	}
	
	public String getEmpate() {
		return empate;
	}
	
	public void setEmpate(String empate) {
		this.empate = empate;
	}
	
	public String getGanaEquipo2() {
		return ganaEquipo2;
	}
	
	public void setGanaEquipo2(String ganaEquipo2) {
		this.ganaEquipo2 = ganaEquipo2;
	}
	
	public Integer getIdEquipo2() {
		return idEquipo2;
	}
	
	public void setIdEquipo2(Integer idEquipo2) {
		this.idEquipo2 = idEquipo2;
	}
}
