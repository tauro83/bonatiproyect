package Clinica;

public class PreOperatorio extends Atencion{

	private String observaciones;
	private String sintomas;
	private String diagnosticos;
	
	public PreOperatorio(){
		this.sintomas="";
		this.observaciones="";
		this.diagnosticos="";
	}

	public void setObservaciones(String obs){
		this.observaciones.concat(obs);
	}
	public void setSintomas(String obs){
		this.sintomas.concat(obs);
	}
	public void setDiagnosticos(String obs){
		this.diagnosticos.concat(obs);
	}
}
