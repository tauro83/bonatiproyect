package TransferObjects;

import java.util.Date;

/**
 * @author Camilo Verdugo
 * @version 1
 * Clase que encapsula los datos de una atencion.
 * Los metodos que posee solo se encargan de get y set los parametros que esta poseea
 * Ademas cuenta con un equivalente en la capa I. Para hacer el mapeo entre capas.
 */
public class Atencion {

	private String clienteRut;
	private String mascotaNombre;
	private String servicio;
	private String hora;
	private Date fecha;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date  fecha) {
		this.fecha = fecha;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
}
