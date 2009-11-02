/**
 * @author Camilo Verdugo
 * @version 2
 *  Clase entidad que es utilizada para el mapeo con la capa 1 *  		
 **/
package TransferObjects;


public class ConfiguracionVacuna {

	public String nombre;
	public String precio;
	public String descripcion;
	public String caducidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	
	
	
}
