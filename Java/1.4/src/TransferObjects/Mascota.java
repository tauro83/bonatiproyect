//=======================================================================
// FECHA CREACIÓN: 10 de Septiembre de 2009
// AUTOR: Sebastian Arancibia
// …. Clase Mascota
//=======================================================================

package TransferObjects;


/**
 * Clase utilizada para representar el objecto Mascota
 *
 * @author  Sebastian Arancibia
 * @version 0.1, 22/09/09
 */

public class Mascota {
    /** Rut de cliente dueño de la mascota */
    private String rutCliente;
    /** Nombre de la mascota */
    private String nombre;
    /** Fecha de Nacimiento de la mascota */
    private String fechaNacimiento;
    /** Clase de Animal que es la mascota */
    private String claseAnimal;
    /** Raza de la mascota */
    private String raza;
    /** Sexo de la mascota */
    private String sexo;
    /** Estado de la mascota */
    private boolean estado;
    private byte imagen[];
	
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	
	/**
	 * Retorna el rut del dueño de la mascota
	 * @return rutCliente Rut del dueño de la mascota
	 */
	public String getRutCliente() {
		return rutCliente;
	}
	
	/**
	 * Asigna rut del dueño de la mascota
	 * @param rutCliente rut del dueño de la mascota
	 */
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	
	/**
	 * Retorna el nombre de la mascota
	 * @return nombre Nombre de la mascota
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna nombre de mascota
	 * @param nombre Nombre de la mascota
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Retorna identificador de la mascota
	 * @return fechaNacimiento Fecha de Nacimiento de la mascota
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * Asigna fecha de nacimiento de la mascota
	 * @param fechaNacimiento Fecha de Nacimiento de la mascota
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Retorna clase de animal de la mascota
	 * @return claseAnimal Clase de Animal de la Mascota
	 */
	public String getClaseAnimal() {
		return claseAnimal;
	}
	
	/**
	 * Asigna clase de animal de la mascota
	 * @param claseAnimal Clase de Animal de la mascota
	 */
	public void setClaseAnimal(String claseAnimal) {
		this.claseAnimal = claseAnimal;
	}
	
	
	/**
	 * Retorna la raza de la mascota
	 * @return raza Raza de la mascota
	 */
	public String getRaza() {
		return raza;
	}
	
	/**
	 * Asigna raza de la mascota
	 * @param raza Raza de la mascota
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	/**
	 * Retorna sexo de la mascota
	 * @return sexo Sexo de la mascota
	 */
	public String getSexo() {
		return sexo;
	}
	
	/**
	 * Asigna sexo de la mascota
	 * @param sexo Sexo de la mascota
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * Retorna estado de la mascota
	 * @return estado Estado de la mascota
	 */
	public boolean getEstado() {
		return estado;
	}
	
	/**
	 * Asigna sexo de la mascota
	 * @param sexo Sexo de la mascota
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
