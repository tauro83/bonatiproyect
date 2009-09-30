package Registro;

import java.sql.Time;
import java.util.Date;

public class Preopreratorio extends Registro {

	private String observacion;
	private String diagnostico;
	private String sintoma;
	
	
	public Preopreratorio(int costoAtenci�n,String responsable, Date fecha,String nombreMascota,Time hora,int idServicio,Date mascotaFechaNacimiento, int rutCliente,String observacion,String diagnostico,String sintoma){
		super(costoAtenci�n,responsable,fecha,nombreMascota,hora,idServicio,mascotaFechaNacimiento,rutCliente);
		this.observacion=observacion;
		this.sintoma=sintoma;
		this.diagnostico=diagnostico;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public String getSintoma() {
		return sintoma;
	}


	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
}
