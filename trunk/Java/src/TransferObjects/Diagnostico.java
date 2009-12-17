package TransferObjects;

public class Diagnostico {
	public String clienteRut;
	public String mascotaNombre;
	public String hora;
	public String nuevaHora;
	public String fecha;
	public String nuevaFecha;
	public String tipoCir;
	public String diagnostico;
	

	public void setClienteRut(String clienteRut) {
		this.clienteRut = clienteRut;
	}
	public String getClienteRut() {
		return clienteRut;
	}
	public void setMascotaNombre(String mascotaNombre) {
		this.mascotaNombre = mascotaNombre;
	}
	public String getMascotaNombre() {
		return mascotaNombre;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHora() {
		return hora;
	}
	public String getNuevaFecha() {
		return nuevaFecha;
	}
	public void setNuevaHora(String hora) {
		this.nuevaHora = hora;
	}
	public String getNuevaHora() {
		return nuevaHora;
	}
	public void setNuevaFecha(String fecha) {
		this.nuevaFecha = fecha;
	}
	public void setTipoCir(String tipoCir) {
		this.tipoCir = tipoCir;
	}
	public String getTipoCir() {
		return tipoCir;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	
}
