package TransferObjects;

public class Producto {

	public String nombre;
	public String codigo;
	public String precio;
	public String categoria;
	public String descripcion;
	
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
	public void setDescripcion(String desc)
	{
		this.descripcion = desc;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
}
