package Clinica;
import java.sql.Date;
import java.sql.Time;


public abstract class Atencion {

	
	private String nombreMascota;
	private Date fechaNacimiento;
	private Time hora;
	private Date fecha;
	public Atencion(){
		
	}
	public void setNombreMascota(String s){
		this.nombreMascota=s;
	}
	public void setFechaNacimiento(Date d){
		
	}
	public void setFecha(Date f){
		this.fecha = f;
	}
}
