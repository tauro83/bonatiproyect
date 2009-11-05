//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad Usuario de sistema, encapsula informacion de un
//				Usuario y el privilegio de acceso al sistema.
//				Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package TransferObjects;
public class Usuario {
	public String nombre;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String usuario;
	public String cargo;
	public String contrasena;
	public String servicio;
	public Boolean permisoRegistrar;
	public Boolean permisoEditar;
	public Boolean permisoEliminar;
	public Boolean permisoPurgar;
	
	/**
	 *  retorna nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *  asigna el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 *  retorna apellido paterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 *  asigna el apellido paterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 *  retorna apellido materno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 *  asigna el apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 *  retorna el usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 *  asigna el usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 *  retorna el cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 *  asigna el cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 *  retorna la contraseña
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 *  asigna la contrseña
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 *  retorna el servicio
	 */
	public String getServicio() {
		return servicio;
	}
	/**
	 *  asigna el servicio
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	 *  retorna permiso de registro
	 */
	public Boolean getPermisoRegistrar() {
		return permisoRegistrar;
	}
	/**
	 *  asigna el permiso de registrar
	 */
	public void setPermisoRegistrar(Boolean permisoRegistrar) {
		this.permisoRegistrar = permisoRegistrar;
	}
	/**
	 *  retorna el permiso de edicion
	 */
	public Boolean getPermisoEditar() {
		return permisoEditar;
	}
	/**
	 *  asigna el permiso de editar
	 */
	public void setPermisoEditar(Boolean permisoEditar) {
		this.permisoEditar = permisoEditar;
	}
	/**
	 *  retorna el permiso de eliminar
	 */
	public Boolean getPermisoEliminar() {
		return permisoEliminar;
	}
	/**
	 *  asigna el permiso eliminar
	 */
	public void setPermisoEliminar(Boolean permisoEliminar) {
		this.permisoEliminar = permisoEliminar;
	}
	/**
	 *  retorna el permiso de purgar
	 */
	public Boolean getPermisoPurgar() {
		return permisoPurgar;
	}
	/**
	 *  asigna el permiso de purgar
	 */
	public void setPermisoPurgar(Boolean permisoPurgar) {
		this.permisoPurgar = permisoPurgar;
	}

	
}
