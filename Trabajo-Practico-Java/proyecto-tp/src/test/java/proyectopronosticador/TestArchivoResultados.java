
package proyectopronosticador;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modeladocsv.LectorResultadosCsv;
import modeladocsv.NumeroDeCamposException;

class TestArchivoResultados {
	
	
		LectorResultadosCsv lectorArchivos = new LectorResultadosCsv("src\\main\\resources\\resultados-errorcol3.csv"); 
		
	
	
	@Test
	void testNumeroDeCampos() {
		
		 System.out.println(NumeroDeCamposException.class);
		
		Assertions.assertThrows(NumeroDeCamposException.class, 
				()->
		      {
		    	
			     lectorArchivos.cantidadCampos();
		    });
		
	    }
	}
	


