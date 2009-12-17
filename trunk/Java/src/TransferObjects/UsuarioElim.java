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
	
	
	public boolean registrar;
	public boolean editar;
	public boolean eliminar;
	public boolean purgar;
	
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
		if((boolean) registrar){
			permisoRegistrar = "si";
		}
		if((boolean)editar){
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
	public boolean getRegistrar() {
		return registrar;
	}
	public void setRegistrar(boolean permisoRegistrar) {
		this.registrar = permisoRegistrar;
	}
	public boolean getEditar() {
		return editar;
	}
	public void setEditar(boolean permisoEditar) {
		this.editar = permisoEditar;
	}
	public boolean getEliminar() {
		return eliminar;
	}
	public void setEliminar(boolean permisoEliminar) {
		this.eliminar = permisoEliminar;
	}
	public boolean getPurgar() {
		return purgar;
	}
	public void setPurgar(boolean permisoPurgar) {
		this.purgar = permisoPurgar;
	}

	
}
