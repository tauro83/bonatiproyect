package TransferObjects;

import java.sql.Date;

/**
 * @author Andres Garrido
 * @version 1
 * Clase que encapsula los datos de un control.
 * Los metodos que posee solo se encargan de get y set los parametros que esta poseea
 * Ademas cuenta con un equivalente en la capa I. Para hacer el mapeo entre capas.
 */
public class Control {
	private String cliente;
	private String mascota;
	private String descripcion;
	private Date fecha;
	private String hora;
	private String servicio;
	private String costo;
	private String responsable;
	
	public void setCliente(String s){
		this.cliente=s;
	}
	public void setMascota(String s){
		this.mascota=s;
	}
	public void setDescripcion(String s){
		this.descripcion=s;
	}
	public void setFecha(Date d){
		this.fecha=d;
	}
	public void setHora(String s){
		this.hora=s;
	}
	public void setServicio(String s){
		this.servicio=s;
	}
	public void setCosto(String s){
		this.costo=s;
	}
	public void setResponsable(String s){
		this.responsable=s;
	}
	public String getCliente(){
		return this.cliente;
	}
	public String getMascota(){
		return this.mascota;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public Date getFecha(){
		return this.fecha;
	}
	public String getHora(){
		return this.hora;
	}
	public String getServicio(){
		return this.servicio;
	}
	public String getCosto(){
		return this.costo;
	}
	public String getResponsable(){
		return this.responsable;
	}
	
}

