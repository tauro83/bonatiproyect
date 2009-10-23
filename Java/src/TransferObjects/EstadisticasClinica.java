/**
 * @author Andres Garrido
 * @version 1
 * Clase entidad Estadistica de clinica, encapsula informacion de una estadistica
 * La cual se refiere al tipo de atenciones y el nº de atenciones por cada tipo.
 * Posee un construction y los metodos son solo getters y setters
 */
package TransferObjects;

public class EstadisticasClinica{

	private int numAtenciones;
	private String tipo;
	
	public EstadisticasClinica(){		
	}
	public int getNumAtenciones() {
		return numAtenciones;
	}
	public void setNumAtenciones(int numAtenciones) {
		this.numAtenciones = numAtenciones;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}