//=======================================================================
// FECHA CREACIÓN: 16/11/09
// AUTOR: Nicolas Delgado
// Descripcion: Clase alternativa de un registro de peluquería que permite 
//              enviar de forma correcta al panel de la interfaz gráfica.
//=======================================================================

package TransferObjects;

public class anuPreoperatorio {
	public String observaciones;
	public String  sintomas;
	public String diagnostico;
	public String  fecha;
	public String  hora;
	public String responsable;
	public String ayudante;
	public String rutCliente;
	public String nombreCliente;
	public String apellido;
	public String raza;
	public String sexo;
	public String nombreMascota;
	public String costo;
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getAyudante() {
		return ayudante;
	}
	public void setAyudante(String ayudante) {
		this.ayudante = ayudante;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int i) {
		this.estado = i;
	}
	public int estado;
}
