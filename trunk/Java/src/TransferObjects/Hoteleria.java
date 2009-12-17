package TransferObjects;

import java.sql.Date;

public class Hoteleria {
	private String servicio;//en este caso corresponde a Hotelería
	private String hora;//hora en que ingresó la mascota
	private Date fechaIngreso;//fecha de ingreso de la mascota
	private String costo;//costo total del servicio
	private String responsable;//reponsable del serivico
	private String cliente;//dueño de la mascota
	private String mascota;//mascota que se está alojando
	private int canil;//número del canil en donde se encuentra la mascota
	private Date fechaSalida;//fecha estipulada para la salida de la mascota
	private String comentario;//comentarios correspondientes al servicio
	private int diasEstadia;//número de días que dura la estadía, calculado a partir						// de la fecha de ingreso y la de salida
	private boolean eliminado;
	
	private Date nuevaFechaIngreso;
	private Date nuevaFechaSalida;
	private int nuevoCanil;
	
	/**
	 * Establece un nuevo valor para la variable servicio
	 * @param s nuevo valor a asignar
	 */
	public void setServicio(String s){
		this.servicio=s;
	}
	/**
	 * Establece un nuevo valor para la variable hora
	 * @param s nuevo valor a asignar
	 */
	public void setHora(String s){
		this.hora=s;
	}
	/**
	 * Establece un nuevo valor para la variable fechaIngreso
	 * @param s nuevo valor a asignar
	 */
	public void setFechaIngreso(Date d){
		this.fechaIngreso=d;
	}
	/**
	 * Establece un nuevo valor para la variable costo
	 * @param s nuevo valor a asignar
	 */
	public void setCosto(String s){
		this.costo=s;
	}
	/**
	 * Establece un nuevo valor para la variable responsable
	 * @param s nuevo valor a asignar
	 */
	public void setResponsable(String s){
		this.responsable=s;
	}
	/**
	 * Establece un nuevo valor para la variable cliente
	 * @param s nuevo valor a asignar
	 */
	public void setCliente(String s){
		this.cliente=s;
	}
	/**
	 * Establece un nuevo valor para la variable mascota
	 * @param s nuevo valor a asignar
	 */
	public void setMascota(String s){
		this.mascota=s;
	}
	/**
	 * Establece un nuevo valor para la variable canil
	 * @param i nuevo valor a asignar
	 */
	public void setCanil(int i){
		this.canil=i;
	}
	/**
	 * Establece un nuevo valor para la variable fechaSalida
	 * @param d nuevo valor a asignar
	 */
	public void setFechaSalida(Date d){
		this.fechaSalida=d;
	}
	/**
	 * Establece un nuevo valor para la variable comentario
	 * @param s nuevo valor a asignar
	 */
	public void setComentario(String s){
		this.comentario=s;
	}
	/**
	 * Establece un nuevo valor para la variable diasEstadia
	 * @param i nuevo valor a asignar
	 */
	public void setDiasEstadia(int i){
		this.diasEstadia=i;
	}
	/**
	 * Establece un nuevo valor para la variable eliminado
	 * @param b nuevo valor a asignar
	 */
	public void setEliminado(boolean b){
		this.eliminado=b;
	}
	/**
	 * Retorna el valor correspondiente a la variable servicio
	 * @return servicio en que se encuentra la mascota, en este caso Hotelería
	 */
	public String getServicio(){
		return this.servicio;
	}
	/**
	 * Retorna el valor correspondiente a la variable hora
	 * @return hora en que ingresó la mascota
	 */
	public String getHora(){
		return this.hora;
	}
	/**
	 * Retorna el valor correspondiente a la variable fechaIngreso
	 * @return fecha en que ingresó la mascota.
	 */
	public Date getFechaIngreso(){
		return this.fechaIngreso;
	}
	/**
	 * Retorna el valor correspondiente a la variable costo
	 * @return costo total del servicio.
	 */
	public String getCosto(){
		return this.costo;
	}
	/**
	 * Retorna el valor correspondiente a la variable responsable
	 * @return responsable asignado al servicio.
	 */
	public String getResponsable(){
		return this.responsable;
	}
	/**
	 * Retorna el valor correspondiente a la variable cliente
	 * @return dueño de la mascota en hotel.
	 */
	public String getCliente(){
		return this.cliente;
	}
	/**
	 * Retorna el valor correspondiente a la variable mascota
	 * @return nombre de la mascota en hotel.
	 */
	public String getMascota(){
		return this.mascota;
	}
	/**
	 * Retorna el valor correspondiente a la variable canil
	 * @return número del canil que se está ocupando.
	 */
	public int getCanil(){
		return this.canil;
	}
	/**
	 * Retorna el valor correspondiente a la variable fechaSalida
	 * @return fecha de salida de la mascota de hotel.
	 */
	public Date getFechaSalida(){
		return this.fechaSalida;
	}
	/**
	 * Retorna el valor correspondiente a la variable comentario
	 * @return comentarios hechos relacionados con la estadía de la mascota.
	 */
	public String getComentario(){
		return this.comentario;
	}
	/**
	 * Retorna el valor correspondiente a la variable diasEstadia
	 * @return número de días que la mascota estará en hotel.
	 */
	public int getDiasEstadia(){
		return this.diasEstadia;
	}
	/**
	 * Retorna el valor correspondiente a la variable eliminado
	 * @return valor booleano que nos indica si el registro está eliminado o no.
	 */
	public boolean getEliminado(){
		return this.eliminado;
	}
	
	
	
	/**
	 * Retorna el valor correspondiente a la variable comentario
	 * @return comentarios hechos relacionados con la estadía de la mascota.
	 */
	public Date getNuevaFechaIngreso(){
		return this.nuevaFechaIngreso;
	}
	/**
	 * Retorna el valor correspondiente a la variable diasEstadia
	 * @return número de días que la mascota estará en hotel.
	 */
	public Date getNuevaFechaSalida(){
		return this.nuevaFechaSalida;
	}
	/**
	 * Retorna el valor correspondiente a la variable eliminado
	 * @return valor booleano que nos indica si el registro está eliminado o no.
	 */
	public int getNuevoCanil(){
		return this.nuevoCanil;
	}
}
