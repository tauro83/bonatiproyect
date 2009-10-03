//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comentario: Esta Clase adquiere todos los datos ingresados por el cliente
// desde teclado y son transformados a objetos.
//======================================================================
package transferObjects;

public class ClienteTO {
	
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
    
    /**
     * Este metodo agrega cada uno de los metodos de los set y get de
     * cada uno de los datos ingresados por el usuario.  
     * 
     * @langversion ActionScript 3.0
     *

     */		
	public void setApellidoPaterno(String apellido) {
		this.apellido = apellido;
	}
	public String getApellido() {
		return apellido;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getRut() {
		return rut;
	}
	public void setRut2(String rut2) {
		this.rut2 = rut2;
	}
	public String getRut2() {
		return rut2;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	public String getCelular2() {
		return celular2;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getComuna() {
		return comuna;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmail2() {
		return email2;
	}
    
}
