package modeladocsv;

public class FormatoGolesIncorrectoException extends Exception {
	private final String valorGoles;
	
    public FormatoGolesIncorrectoException(String valor) {
		this.valorGoles = valor;
	}
     
     @Override
     public String getMessage() {
    	 return "el campo de goles no tiene el formato adecuado : No es un numero";
     }
}
