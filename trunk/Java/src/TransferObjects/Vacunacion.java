package TransferObjects;

import java.sql.Date;
import java.util.List;

public class Vacunacion {
	private String clienteRut;
	private String mascotaNombre;
	private String hora;
	private Date fecha;
	private Date fechaCaducidad;
	private String costo;
	private String veterinario;
	private String descripcion;
	private List<String> tiposVacunas;
	
	public void setClienteRut(String clienteRut) {
		this.clienteRut = clienteRut;
	}
	public String getClienteRut() {
		return clienteRut;
	}
	public void setMascotaNombre(String mascotaNombre) {
		this.mascotaNombre = mascotaNombre;
	}
	public String getMascotaNombre() {
		return mascotaNombre;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHora() {
		return hora;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getCosto() {
		return costo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setTiposVacunas(List<String> tiposVacunas) {
		this.tiposVacunas = tiposVacunas;
	}
	public List<String> getTiposVacunas() {
		return tiposVacunas;
	}
}
