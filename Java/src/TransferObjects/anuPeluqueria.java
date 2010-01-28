//=======================================================================
// FECHA CREACI�N: 16/11/09
// AUTOR: Nicolas Delgado
// Descripcion: Clase alternativa de un registro de peluquer�a que permite 
//              enviar de forma correcta al panel de la interfaz gr�fica.
//=======================================================================

package TransferObjects;

public class anuPeluqueria {
	public String rutCliente;
	public String nombreCliente;
	public String apellido;
	public String nombreMascota;
	public String raza;
	public String sexo;
	public String servicio;
	public String hora;
	public String fecha;
	public String descripcion;
	public String costo;
	public int estado;
	public String responsable;
	public String nombreCatalogo;
	 public String motivo;
	 public String fechaA;
	 public String usuarioA;
	 
	public String getFechaA() {
		return fechaA;
	}

	public void setFechaA(String fechaA) {
		this.fechaA = fechaA;
	}

	public String getUsuarioA() {
		return usuarioA;
	}

	public void setUsuarioA(String usuarioA) {
		this.usuarioA = usuarioA;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	*  retorna rut del cliente.
	*/
	 public String getRutCliente() {
		return rutCliente;
	}
	 
	/**
	*  asigna el rut Cliente
	*/
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	
	/**
	*  retorna nombre de la mascota.
	*/
	public String getNombreMascota() {
		return nombreMascota;
	}
	
	/**
	*  asigna nombre de la mascota.
	*/
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	
	/**
	*  retorna servicio.
	*/
	public String getServicio() {
		return servicio;
	}
	
	/**
	*  asigna servicio.
	*/	
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	/**
	*  retorna la hora.
	*/	
	public String getHora() {
		return hora;
	}
	
	/**
	*  asigna la hora.
	*/	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**
	*  retorna la fecha.
	*/	
	public String getFecha() {
		return fecha;
	}
	
	/**
	*  asigna la fecha.
	*/
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	*  retorna la decripci�n.
	*/
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	*  asigna la decripci�n.
	*/
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	*  retorna el costo.
	*/
	public String getCosto() {
		return costo;
	}
	
	/**
	*  asigna el costo.
	*/
	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	/**
	*  retorna el estado.
	*/
	public int getEstado() {
		return estado;
	}
	
	/**
	*  asigna el estado.
	*/
	public void setEstado(int i) {
		this.estado = i;
	}
	
	/**
	*  retorna el nombre del cliente.
	*/	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	/**
	*  asigna el nombre del cliente.
	*/
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	/**
	*  retorna el apellido del cliente.
	*/
	public String getApellido() {
		return apellido;
	}
	
	/**
	*  asigna el apellido del cliente.
	*/
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	*  retorna la raza de la mascota.
	*/
	public String getRaza() {
		return raza;
	}
	
	/**
	*  asigna la raza de la mascota.
	*/
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	/**
	*  retorna el sexo de la mascota.
	*/
	public String getSexo() {
		return sexo;
	}
	
	/**
	*  asigna el sexo de la mascota.
	*/
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	*  retorna el responsable.
	*/
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	/**
	*  asigna el responsable.
	*/
	public String getResponsable() {
		return responsable;
	}
	
	/**
	*  retorna el nombre del catalogo.
	*/
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}
	
	/**
	*  asigna el nombre del catalogo.
	*/
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}
	


}
