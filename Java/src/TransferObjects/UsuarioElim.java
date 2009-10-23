//=======================================================================
// AUTOR: Erwin Díaz
// Descripcion: Clase alternativa de usuario que permite enviar de forma
//				correcta al panel de la interfaz gráfica los permisos
//				de cada usuario
//=======================================================================

package TransferObjects;
/**
 * Clase alternativa de usuario que permite enviar de forma
 * correcta al panel de la interfaz gráfica los permisos
 * de cada usuario
 * @author Erwin Díaz
 *
 */
public class UsuarioElim {

	public String nombre;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String usuario;
	public String cargo;
	public String contrasena;
	public String servicio;
	
	
	public Boolean registrar;
	public Boolean editar;
	public Boolean eliminar;
	public Boolean purgar;
	
	public String permisoRegistrar = "no";
	public String permisoEditar = "no";
	public String permisoEliminar = "no";
	public String permisoPurgar = "no";
	/**
	 * Cambia de un booleano a decir "si" o "no" de 
	 * a cuerdo a si es verdadero o falso
	 */
	public void convetParam()
	{
		if(registrar){
			permisoRegistrar = "si";
		}
		if(editar){
			permisoEditar = "si";
		}
		if(eliminar){
			permisoEliminar = "si";
		}
		if(purgar){
			permisoPurgar = "si";
		}
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public Boolean getRegistrar() {
		return registrar;
	}
	public void setRegistrar(Boolean permisoRegistrar) {
		this.registrar = permisoRegistrar;
	}
	public Boolean getEditar() {
		return editar;
	}
	public void setEditar(Boolean permisoEditar) {
		this.editar = permisoEditar;
	}
	public Boolean getEliminar() {
		return eliminar;
	}
	public void setEliminar(Boolean permisoEliminar) {
		this.eliminar = permisoEliminar;
	}
	public Boolean getPurgar() {
		return purgar;
	}
	public void setPurgar(Boolean permisoPurgar) {
		this.purgar = permisoPurgar;
	}

	
}
