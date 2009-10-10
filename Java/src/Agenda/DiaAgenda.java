//=======================================================================
// AUTOR: Sebastian Arancibia
// Descripcion: Clase entidad DiaAgenda de sistema, encapsula informacion de un
//				DiaAgenda 
//				Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================
package Agenda;

public class DiaAgenda {
	/** Atributo que corresponde a la fecha de una cita */
	public String fecha;
	/** Atributo que corresponde a la hora de una cita */
	public String hora;
	/** Atributo que corresponde al responsable de una cita */
	public String responsable;
	/** Atributo que corresponde al servicio de una cita */
	public String servicio;
	/** Atributo que corresponde a la mascota de una cita */
	public String mascota;
	/** Atributo que corresponde al cliente de una cita */
	public String cliente;
	
	/**
     * Esta clase agrega cada uno de los metodos de los set y get de
     * cada uno de los datos seleccionados en DiaAgenda  
     * 
     * @langversion Java
	 * @author Sebastian Arancibia
	 * @version 1 05/10/2009
     */
	
	/**
	 * Metodo que retorna la hora de una cita
	 * @return hora de una cita
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * Metodo que guarda la hora de una cita
	 * @param hora de una cita
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/**
	 * Metodo que retorna la fecha de una cita
	 * @return fecha de una cita
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Metodo que guarda la fecha de una cita
	 * @param fecha de una cita
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * Metodo que retorna el responsable de una cita
	 * @return resposable de una cita
	 */
	public String getResponsable() {
		return responsable;
	}
	/**
	 * Metodo que guarda el responsable de una cita
	 * @param responsable de una cita
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	/**
	 * Metodo que retorna el servicio de una cita
	 * @return servicio de una cita
	 */
	public String getServicio() {
		return servicio;
	}
	/**
	 * Metodo que guarda el servicio de una cita
	 * @param servicio de una cita
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	 * Metodo que retorna la el nombre de la Mascota de una cita
	 * @return mascota de una cita
	 */
	public String getMascota() {
		return mascota;
	}
	/** 
	 * Metodo que guarda la mascota de una cita
	 * @param mascota de una cita
	 */
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	/**
	 * Metodo que retorna el cliente de una cita
	 * @return cliente de una cita
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * Metodo que guarda el cliente de una cita
	 * @param cliente de una cita
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	

	
}
