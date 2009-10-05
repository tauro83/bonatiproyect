package Administracion;

import java.util.Date;



public class Preoperatorio extends Registro {

	private String observacion;
	private String diagnostico;
	private String sintoma;
	
	
	public Preoperatorio(int costoAtención,String responsable, String fecha,String nombreMascota,String hora,int idServicio,String mascotaFechaNacimiento, int rutCliente,String observacion,String diagnostico,String sintoma)throws Exception{
		super(costoAtención,responsable,fecha,nombreMascota,hora,idServicio,mascotaFechaNacimiento,rutCliente);
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
	
	protected String addRegistro(Registro r, String d, int e,Date dia) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String deteleRegistro() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String getRegistro() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String setRegistro() {
		// TODO Auto-generated method stub
		return null;
	}


	/*protected String addRegistro(Registro r) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}*/



}
