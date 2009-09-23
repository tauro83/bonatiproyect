
//=======================================================================
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad Usuario de sistema, encapsula informacion de un
//				Usuario y el privilegio de acceso al sistema.
//				Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package transferObjects;

public class Usuario {

	public String nombre;
	public String apellidoPaterno;
 	
	public String apellidoMaterno;
	public String usuario;
	public String cargo;
	public String constrasena;
	public String servicio;
	public Boolean permisoRegistrar;
	public Boolean permisoEditar;
	public Boolean permisoEliminar;
	public Boolean permisoPurgar;
	
	
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
	public String getConstrasena() {
		return constrasena;
	}
	public void setConstrasena(String constrasena) {
		this.constrasena = constrasena;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public Boolean getPermisoRegistrar() {
		return permisoRegistrar;
	}
	public void setPermisoRegistrar(Boolean permisoRegistrar) {
		this.permisoRegistrar = permisoRegistrar;
	}
	public Boolean getPermisoEditar() {
		return permisoEditar;
	}
	public void setPermisoEditar(Boolean permisoEditar) {
		this.permisoEditar = permisoEditar;
	}
	public Boolean getPermisoEliminar() {
		return permisoEliminar;
	}
	public void setPermisoEliminar(Boolean permisoEliminar) {
		this.permisoEliminar = permisoEliminar;
	}
	public Boolean getPermisoPurgar() {
		return permisoPurgar;
	}
	public void setPermisoPurgar(Boolean permisoPurgar) {
		this.permisoPurgar = permisoPurgar;
	}

	
}
