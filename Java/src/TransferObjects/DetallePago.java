package TransferObjects;

import java.sql.Date;

public class DetallePago {

	public String codigoProducto;
	public int cantidad;
	public int subtotal;
	public Date fecha;
	public String hora;
	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String cp) {
		this.codigoProducto = cp;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCodigo(int c) {
		this.cantidad = c;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setPrecio(int subtotal) {
		this.subtotal = subtotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora)
	{
		this.hora = hora;
	}
	public String getHora(){
		return this.hora;
	}
}
