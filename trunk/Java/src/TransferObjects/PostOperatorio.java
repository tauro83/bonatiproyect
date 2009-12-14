package TransferObjects;

import java.sql.Date;

//=======================================================================
//FECHA CREACIÓN: 13-10-09
//AUTOR: Andres Garrido R.
//Clase que representa al objeto de Post Operatorio para el módulo de clínica
//=======================================================================
public class PostOperatorio extends Atencion{

	public String idpostoperatorio;
	public String medicamentos;
	public String observaciones;
	public String sintomas;
	public String diagnostico;
	public String responsable;
	public Date fecha;
	public String hora;
	public String ayudante;
	public String alimentos;
	public String shora;
	public String stfecha;
	
	public String clienterut;
	public String nombreMascota;
	public String nombreCliente;
	public String apellido;
	public String sexo;
	public String raza;
	public String costo;
	public String indicaciones;
	private String nombreDueño;
	private String rut;
	
	private String apellidoDueño;
	
	
	public PostOperatorio(String hora, Date fecha, String cost){
		super();
		this.setHora(hora);
		setFecha(fecha);
		this.setCosto(cost);
	}
	public PostOperatorio(){
	}

	public String getNombreDueño(){
		return this.nombreDueño;
	}
	public String getRut(){
		return this.rut;
	}
	public String getApellidoDueño(){
		return this.apellidoDueño;
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
	public void setNombreDueño(String s){
		this.nombreDueño = s;
	}
	public void setRut(String s){
		this.rut=s;
	}
	public void setApellidoDueño(String s){
		this.apellidoDueño=s;
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
