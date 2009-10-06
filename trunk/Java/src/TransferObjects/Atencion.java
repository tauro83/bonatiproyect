package TransferObjects;

import java.util.Date;

public class Atencion {

	private String clienteRut;
	private String mascotaNombre;
	private String servicio;
	private String hora;
	private String fecha;
	private String costo;
	
	public Atencion(){
		
	}
	
	public String getClienteRut() {
		return clienteRut;
	}
	public void setClienteRut(String clienteRut) {
		this.clienteRut = clienteRut;
	}
	public String getMascotaNombre() {
		return mascotaNombre;
	}
	public void setMascotaNombre(String mascotaNombre) {
		this.mascotaNombre = mascotaNombre;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String  fecha) {
		this.fecha = fecha;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	
}
