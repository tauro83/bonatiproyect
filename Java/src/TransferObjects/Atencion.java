//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase que encapsula los datos de una atencion.
// Los metodos que posee solo se encargan de get y set los parametros que esta poseea
// Ademas cuenta con un equivalente en la capa I. Para hacer el mapeo entre capas.
//=======================================================================

package TransferObjects;

public class Atencion {

	private String clienteRut;
	private String mascotaNombre;
	private String servicio;
	private String hora;
	private String fecha;
	private String costo;
	private String sfecha;
	

	/**
	 *  constructor de la clase
	 */
	public Atencion(){
		
	}

	/**
	 *  retorna el rut
	 */
	public String getClienteRut() {
		return clienteRut;
	}

	/**
	 *  asigna el rut
	 */
	public void setClienteRut(String clienteRut) {
		this.clienteRut = clienteRut;
	}

	/**
	 *  retorna el nombre de la mascota
	 */
	public String getMascotaNombre() {
		return mascotaNombre;
	}

	/**
	 *  Asigna el nombre de la mascota
	 */
	public void setMascotaNombre(String mascotaNombre) {
		this.mascotaNombre = mascotaNombre;
	}

	/**
	 *  retorna el servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 *  Asigna el servicio
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	 *  retorna la hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 *  Asigna la hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/**
	 *  retorna la sfecha
	 */
	public String getSfecha() {
		return sfecha;
	}
	/**
	 *  Asigna  la sFecha
	 */
	public void setSfecha(String fecha) {
		this.sfecha = fecha;
	}
	/**
	 *  retorna la fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 *  Asigna la fecha
	 */
	public void setFecha(String  string) {
		this.fecha = string;
	}
	/**
	 *  retorna el costo
	 */
	public String getCosto() {
		return costo;
	}
	/**
	 *  Asigna el costo
	 */
	public void setCosto(String costo) {
		this.costo = costo;
	}
}
