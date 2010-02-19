package TransferObjects;

import java.sql.Date;
import java.util.List;

public class Vacunacion {
	private String clienteRut;
	private String clienteNombre;
	private String clienteApellido;
	private String mascotaNombre;
	private String mascotaRaza;
	private String mascotaSexo;
	private String hora;
	private String fechaS;
	private Date fecha;
	private Date fechaCaducidad;
	private String costo;
	private String veterinario;
	private String descripcion;
	private String servicio;
	private String estado;
	private List tiposVacunas;
	public String motivo;
	public String fechaA;
	public String usuarioA;
	
	public String getFechaS() {
		return fechaS;
	}
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
	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
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
	public void setTiposVacunas(List tiposVacunas) {
		this.tiposVacunas = tiposVacunas;
	}
	public List getTiposVacunas() {
		return tiposVacunas;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getFechaA() {
		return fechaA;
	}
	public void setFechaA(String fechaA) {
		this.fechaA = fechaA;
	}
	public String getUsuarioA() {
		return usuarioA;
	}
	public void setUsuarioA(String usuarioA) {
		this.usuarioA = usuarioA;
	}
}
