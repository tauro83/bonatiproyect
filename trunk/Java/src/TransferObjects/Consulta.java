package TransferObjects;

public class Consulta {
	
	
private String rut;
private String rut2; 
private String nombre;
private String responsable;
private String servicio;
private String fecha;
private String costo;
private String anamnesis;
private String hora;
private int estado;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setRut(String rut) {
	this.rut = rut;
}
public String getRut() {
	return rut;
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
public void setAnamnesis(String anamnesis) {
	this.anamnesis = anamnesis;
}
public String getAnamnesis() {
	return anamnesis;
}
public void setRut2(String rut2) {
	this.rut2 = rut2;
}
public String getRut2() {
	return rut2;
}
public void setHora(String hora) {
	this.hora = hora;
}
public String getHora() {
	return hora;
}

public void setEstado(int estado) {
	this.estado = estado;
}
public int getEstado() {
	return estado;
}
}
