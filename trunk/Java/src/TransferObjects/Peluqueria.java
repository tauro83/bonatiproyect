package TransferObjects;

import java.sql.Date;
import java.util.List;

public class Peluqueria {
	
	private String rutCliente;
	private String nombreMascota;
	private String responsable;
	private String servicio;
	private Date fecha;
	private String fechaS;
	private String costo;
	private String descripcion;
	private String nombre;
	private String hora;
	private Date fechaAntigua;
	private String horaAntigua;
	private List<String> tiposServicios;
	private List<String> tiposNombres;
	
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getServicio() {
		return servicio;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFecha() {
		return fecha;
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
	public void setTiposServicios(List<String> tiposservicios) {
		this.tiposServicios = tiposservicios;
	}
	public List<String> getTiposServicios() {
		return tiposServicios;
	}
	public void setTiposNombres(List<String> tiposNombres) {
		this.tiposNombres = tiposNombres;
	}
	public List<String> getTiposNombres() {
		return tiposNombres;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHora() {
		return hora;
	}
	public void setHoraAntigua(String horaAntigua) {
		this.horaAntigua = horaAntigua;
	}
	public String getHoraAntigua() {
		return horaAntigua;
	}
	public void setFechaAntigua(Date fechaAntigua) {
		this.fechaAntigua = fechaAntigua;
	}
	public Date getFechaAntigua() {
		return fechaAntigua;
	}
	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}
	public String getFechaS() {
		return fechaS;
	}


}
