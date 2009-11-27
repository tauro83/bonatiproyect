
//======================================================================
// FECHA  CREACIÓN: 08/11/09
// AUTOR: Cristian Bravo
// Comentarios: Clase que representa al objeto de un Aviso Web
//=======================================================================

package TransferObjects;

public class aviWeb {
	public Integer id; 
	public String nombre; 
	public String apaterno; 
	public String telefono0; 
	public String telefono; 
	public String celular;
	public String celular0;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getTelefono0() {
		return telefono0;
	}
	public void setTelefono0(String telefono0) {
		this.telefono0 = telefono0;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular0() {
		return celular0;
	}
	public void setCelular0(String celular0) {
		this.celular0 = celular0;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String asunto; 
	public String descripcion; 
	public String responsable; 
	public Integer estado;

}
