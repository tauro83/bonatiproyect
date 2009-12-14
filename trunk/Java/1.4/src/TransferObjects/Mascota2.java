package TransferObjects;

public class Mascota2 {
	public String nombre = "rocky";
	public String raza = "Pitbull";
	public String sexo = "Masculino";
	public String fechaNacimiento = "22/09/2007";
	
	public String nombreDueno = "Juan";
	public String apellidoPaterno = "Bravo";
	public String apellidoMaterno = "Mora";
	public String telefono = "99987893";
	public String rut = "16.345.645";
	public String comuna = "Teno";
	public String direccion = "Prat 90b";
	
	public String fecha="13/04/2009";
	public String costo ="$ 19.000";
	public String servicio = "Atención Domicilio";
	public String descripcion = "Vacunacion, chequeo general de la mascota";
	public String responsable = "Dr. Claudio Bonati";
	
	
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion1) {
		this.descripcion =descripcion1;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	////
	public String getNombreDueno() {
		return nombreDueno;
	}
	public void setNombreDueno(String nombred) {
		this.nombreDueno = nombred;
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
		this.sexo=sexo;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fecha) {
		this.fechaNacimiento = fecha;
	}

	////////////////////
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
