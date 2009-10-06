//=======================================================================
// FECHA CREACIÓN: 20/09/09 
// AUTOR: Erwin Díaz
// Comentario: Se declara la clase usuario, una vez instanciada 
// representa el objeto de transferencia entre la capa lógica
// y la interfaz gráfica
//=======================================================================

package TransferObjects;

/**
 * Se declara la clase usuario, una vez instanciada 
   representa el objeto de transferencia entre la capa lógica
   y la interfaz gráfica
 * @author Erwin Díaz
 *
 */
public class UsuarioElim 
{
    private String nombre;
    private String apellido;
    private String cargo;
    private String usuario;
    private String servicio;
    private boolean registrar;
    private boolean editar;
    private boolean eliminar;
    private boolean purgar;
    
    
    public boolean getPurgar() {
		return purgar;
	}
	public void setPurgar(boolean purgar) {
		this.purgar = purgar;
	}
	public boolean getEliminar() {
		return eliminar;
	}
	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	public boolean getEditar() {
		return editar;
	}
	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	public boolean getRegistrar() {
		return registrar;
	}
	public void setRegistrar(boolean registrar) {
		this.registrar = registrar;
	}
    public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
