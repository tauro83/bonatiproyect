/**
 * @author Camilo Verdugo
 * @version 2
 *  Clase entidad que es utilizada para el mapeo con la capa 1 *  		
 **/
package TransferObjects;

import java.util.Date;

public class ConfiguracionVacuna {

	public String nombre;
	public int precio;
	public String descripcion;
	public Date caducidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	
	
	
}
