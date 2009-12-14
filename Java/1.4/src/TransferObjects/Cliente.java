//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comentario: Esta Clase adquiere todos los datos ingresados por el cliente
// desde teclado y son transformados a objetos.
//======================================================================
package TransferObjects;

/**
 * Este metodo agrega cada uno de los metodos de los set y get de
 * cada uno de los datos ingresados por el usuario.  
 * 
 * @langversion ActionScript 3.0
 *

 */

public class Cliente {
	
    public String nombre;
    public String apellido;
    public String apellido2;
    public String rut;
    public String rut2;
    public String telefono;
    public String telefono2;
    public String celular;
    public String celular2;    
    public String direccion;
    public String region;
    public String comuna;
    public String email;   
    public String email2;
    public boolean estado;
    
    

	/**
	 *  retorna estado
	 */
    public boolean isEstado() {
		return estado;
	}
    
	/**
	 *  asigna el estado
	 */
    
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	/**
	 *  asigna el apellido paterno
	 */
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 *  retorna apellido paterno
	 */		
	
	public String getApellido() {
		return apellido;
	}
	
	/**
	 *  asigna el nombre
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 *  retorna nombre
	 */	
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 *  asigna el apellido materno
	 */
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	/**
	 *  retorna apellido materno
	 */		
	
	public String getApellido2() {
		return apellido2;
	}
	
	/**
	 *  asigna el Rut
	 */
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	/**
	 *  retorna Rut
	 */	
	
	public String getRut() {
		return rut;
	}
	
	/**
	 *  asigna el codigo identificador del Rut
	 */
	
	public void setRut2(String rut2) {
		this.rut2 = rut2;
	}
	
	/**
	 *  retorna codigo identificador del Rut
	 */	
	
	public String getRut2() {
		return rut2;
	}
	
	/**
	 *  asigna el codigo ciudad del telefono
	 */
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 *  retorna codigo ciudad del telefono
	 */	
	
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 *  asigna el telefono
	 */
	
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	
	/**
	 *  retorna telefono
	 */	
	
	public String getTelefono2() {
		return telefono2;
	}
	
	/**
	 *  asigna el celular
	 */
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	/**
	 *  retorna celular
	 */	
	
	public String getCelular() {
		return celular;
	}
	
	/**
	 *  asigna el celular
	 */
	
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	
	/**
	 *  retorna celular
	 */
	
	public String getCelular2() {
		return celular2;
	}
	
	/**
	 *  asigna el direccion
	 */
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 *  retorna direccion
	 */
	
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 *  asigna el region
	 */
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 *  retorna region
	 */
	
	public String getRegion() {
		return region;
	}
	
	/**
	 *  asigna el comuna
	 */
	
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
	/**
	 *  retorna comuna
	 */
	
	public String getComuna() {
		return comuna;
	}
	
	/**
	 *  asigna el correo
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 *  retorna correo
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 *  asigna la confirmacion del correo
	 */
	
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	/**
	 *  retorna la confirmacion del correo
	 */
	
	public String getEmail2() {
		return email2;
	}
    
}
