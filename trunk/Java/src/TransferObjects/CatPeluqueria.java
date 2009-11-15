//=======================================================================
// FECHA CREACIÓN: 29/10/09
// AUTOR: Erwin Díaz
// DESCRIPCION: TransferObject que se encarga de recibir los datos
//=======================================================================

package TransferObjects;
/**
 * TransferObject que se encarga de recibir los datos
 * @author Erwin Díaz
 *
 */
public class CatPeluqueria {

	public String servicio;
	public String nombre;
	public String precio;
	public String descripcion;
	private String estado;
    
	 public String getEstado() {
			return estado;
	 }
	/**
	 * 
	 * @return nombre Nombre tipo de servicio del catálogo
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre Nombre tipo de servicio del catálogo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return Tipo de servicio
	 */
	public String getServicio() {
		return servicio;
	}
	/**
	 * 
	 * @param servicio Tipo de servicio
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	 * 
	 * @return Precio del servicio
	 */
	public String getPrecio() {
		return precio;
	}
	/**
	 * 
	 * @param precio Precio del servicio
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	/**
	 * 
	 * @return Descripcion del servicio
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * 
	 * @param descripcion Descripcion del servicio
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
    }

	
}
