//=======================================================================
// FECHA CREACI�N: 29/10/09
// AUTOR: Erwin D�az
// DESCRIPCION: TransferObject que se encarga de recibir los datos
//=======================================================================

package TransferObjects;
/**
 * TransferObject que se encarga de recibir los datos
 * @author Erwin D�az
 *
 */
public class CatPeluqueria {

	public String servicio;
	public String nombre;
	public String precio;
	public String descripcion;
	public String imagen;
	public String estado;
	public String motivo;
	public String fechaA;
	public String usuarioA;
	public String hora;

	/**
	 * 
	 * @return nombre Nombre tipo de servicio del cat�logo
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre Nombre tipo de servicio del cat�logo
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
	public String getEstado() {
		return estado;
	}
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getFechaA() {
		return fechaA;
	}
	public void setFechaA(String fechaA) {
		this.fechaA = fechaA;
	}
	public String getUsuarioA() {
		return usuarioA;
	}
	public void setUsuarioA(String usuarioA) {
		this.usuarioA = usuarioA;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
