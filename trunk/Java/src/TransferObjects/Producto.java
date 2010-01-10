//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Esteban Cruz
// DESCRIPCION: TransferObject que se encarga de recibir los datos
//=======================================================================

package TransferObjects;

public class Producto {

	public String nombre;
	public String codigo;
	public String precio;
	public String categoria;
	public String descripcion;
	public int cantidad;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
