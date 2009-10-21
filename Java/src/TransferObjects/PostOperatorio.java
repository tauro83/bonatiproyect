package TransferObjects;

import java.sql.Date;

//=======================================================================
//FECHA CREACI�N: 13-10-09
//AUTOR: Andres Garrido R.
//Clase que representa al objeto de Post Operatorio para el m�dulo de cl�nica
//=======================================================================
public class PostOperatorio extends Atencion{

	private String medicamentos;
	private String alimentos;
	private String indicaciones;
	private String nombreMascota;
	private String nombreDue�o;
	private String rut;
	private String apellidoDue�o;
	
	
	public PostOperatorio(String hora, Date fecha, String cost){
		super();
		this.setHora(hora);
		this.setFecha(fecha);
		this.setCosto(cost);
	}

	public String getNombreDue�o(){
		return this.nombreDue�o;
	}
	public String getRut(){
		return this.rut;
	}
	public String getApellidoDue�o(){
		return this.apellidoDue�o;
	}
	public String getAlimentos(){
		return this.alimentos;
	}
	public String getMedicamentos(){
		return this.medicamentos;
	}
	public String getIndicaciones(){
		return this.indicaciones;
	}
	public String getNombreMascota(){
		return this.nombreMascota;
	}
	public void setNombreMascota(String s){
		this.nombreMascota=s;
	}
	public void setNombreDue�o(String s){
		this.nombreDue�o = s;
	}
	public void setRut(String s){
		this.rut=s;
	}
	public void setApellidoDue�o(String s){
		this.apellidoDue�o=s;
	}
	public void setMedicamentos(String meds){
		this.medicamentos=meds;
	}
	public void setAlimentos(String alim){
		this.alimentos=alim;
	}
	public void setIndicaciones(String ind){
		this.indicaciones= ind;
	}
}
