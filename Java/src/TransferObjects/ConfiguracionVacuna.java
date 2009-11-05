//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad que es utilizada para el mapeo con la capa 1
//=======================================================================

package TransferObjects;


public class ConfiguracionVacuna {

	public String nombre;
	public String precio;
	public String descripcion;
	public String caducidad;
	
	/**
	 * retorna el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Asigna el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * retorna el precio
	 */
	public String getPrecio() {
		return precio;
	}
	/**
	 * Asigna el precio
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	/**
	 * retorna la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Asigna la descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * retorna la caducidad
	 */
	public String getCaducidad() {
		return caducidad;
	}
	/**
	 * Asigna la caducidad
	 */
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	
	
	
}
