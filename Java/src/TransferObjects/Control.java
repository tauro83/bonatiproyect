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
	private String descripcion;
	private String recomendacion;
	private Date fecha;
	private String hora;
	private String servicio;
	private Date proximaFecha;
	private String costo;
	
	public Control(){
		
	}
	public void setDescripcion(String s){
		this.descripcion=s;
	}
	public void setRecomendacion(String s){
		this.recomendacion=s;
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
	public void setProxFecha(Date d){
		this.proximaFecha=d;
	}
	public void setCosto(String s){
		this.costo=s;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public String getRecomendacion(){
		return this.recomendacion;
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
	public Date getProxFecha(){
		return this.proximaFecha;
	}
	public String getCosto(){
		return this.costo;
	}
	
}
