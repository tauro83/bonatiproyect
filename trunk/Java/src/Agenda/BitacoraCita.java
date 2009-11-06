
package Agenda;

public class BitacoraCita {
	/**Usuario que realiza la accion*/
	public String usuario;
	
	/**Fecha en que se realiza la accion*/
	public String fechaAccion;
	
	/**Hora en que se realiza la accion*/
	public String horaAccion;
	
	/**Fecha de la cita sobre la cual se realiza la accion*/
	public String fechaCita;
	
	/**Hora de la cita sobre la cual se realiza la accion*/
	public String horaCita;
	
	/**Responsable de la cita sobre la cual se realiza la accion*/
	public String encargado;
	
	/**Servicio de la cita sobre la cual se realiza la accion*/
	public String servicio;
	
	/**Mascota de la cita sobre la cual se realiza la accion*/
	public String mascota;
	
	/**Cliente de la cita sobre la cual se realiza la accion*/
	public String cliente;
	
	/**Accion que se realiza sobre la cita*/
	public String accion;
	
	/**
	 * Metodo que retorna la hora de una cita
	 * @return fechaAccion Fecha en que se realiza la accion
	 */
	public String getFechaAccion() {
		return fechaAccion;
	}
	
	/**
	 * Metodo que guarda la fechaAccion de un evento
	 * @param fechaAccion Fecha en que se realiza la accion
	 */
	public void setFechaAccion(String fechaAccion) {
		this.fechaAccion = fechaAccion;
	}
	
	/**
	 * Metodo que retorna la fecha de una cita
	 * @return fechaCita Fecha de la cita que es modificada
	 */
	public String getFechaCita() {
		return fechaCita;
	}
	
	/**
	 * Metodo que guarda la fecha de una cita
	 * @param fechaCita Fecha de la cita que es modificada
	 */
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}
	
	/**
	 * Metodo que retorna el encargado de la cita modificada
	 * @return encargado Encargado de la cita modificada
	 */
	public String getEncargado() {
		return encargado;
	}
	
	/**
	 * Metodo que guarda el responsable de la cita modificada
	 * @param encargado Responsable de la cita modificada
	 */
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	/**
	 * Metodo que retorna el servicio de la cita modificada
	 * @return fechaAccion Fecha en que se realiza la accion
	 */
	public String getServicio() {
		return servicio;
	}
	
	/**
	 * Metodo que guarda el servicio de la cita modificada
	 * @param servicio servicio de la cita modificada
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	/**
	 * Metodo que retorna la mascota de la cita modifcada
	 * @return mascota Mascota de la cita modificada
	 */
	public String getMascota() {
		return mascota;
	}
	
	/**
	 * Metodo que guarda la hora de una cita
	 * @param mascota Mascota de la cita
	 */
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	
	/**
	 * Metodo que retorna el cliente de la cita modificada
	 * @return cliente Cliente de la cita modificada
	 */
	public String getCliente() {
		return cliente;
	}
	
	/**
	 * Metodo que guarda el cliente de la cita modificada
	 * @param cliente Cliente de la cita modificada
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	

	
}
