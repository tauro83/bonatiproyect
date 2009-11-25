package TransferObjects;

import java.util.ArrayList;
import java.util.List;
import TransferObjects.tiposCir;

public class Cirugia {

	private String clienteRut;
	private String clienteNombre;
	private String clienteApellido;
	private String mascotaSexo;
	private String mascotaRaza;
	private String servicio;
	private String mascotaNombre;
	private String hora;
	private String fecha;
	private String nuevaFecha;
	private String nuevaHora;
	private String costo;
	private String veterinario;
	private String ayudante;
	private String tipoCir;
	private String diagnostico;
	private List<String> tiposCirugias;
	
	public String getMascotaRaza() {
		return mascotaRaza;
	}
	public String getMascotaSexo() {
		return mascotaSexo;
	}
	public String getServicio() {
		return servicio;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public String getClienteApellido() {
		return clienteApellido;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public void setClienteApellido(String clienteApellido) {
		this.clienteApellido = clienteApellido;
	}
	public void setMascotaRaza(String mascotaRaza) {
		this.mascotaRaza = mascotaRaza;
	}
	public void setMascotaSexo(String mascotaSexo) {
		this.mascotaSexo = mascotaSexo;
	}
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
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return fecha;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getCosto() {
		return costo;
	}
	public void setAyudante(String ayudante) {
		this.ayudante = ayudante;
	}
	public String getAyudante() {
		return ayudante;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHora() {
		return hora;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setTipoCir(String tipoCir) {
		this.tipoCir = tipoCir;
	}
	public String getTipoCir() {
		return tipoCir;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setTiposCirugias(List<String> tiposCirugias) {
		this.tiposCirugias = tiposCirugias;
	}
	public List<String> getTiposCirugias() {
		return tiposCirugias;
	}
	public void setNuevaFecha(String nuevaFecha) {
		this.nuevaFecha = nuevaFecha;
	}
	public String getNuevaFecha() {
		return nuevaFecha;
	}
	public void setNuevaHora(String nuevaHora) {
		this.nuevaHora = nuevaHora;
	}
	public String getNuevaHora() {
		return nuevaHora;
	}
	
}
