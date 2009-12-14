package Clinica;

import java.sql.Date;
import java.sql.Time;
//=======================================================================
//FECHA CREACIÓN: 13-10.09
//AUTOR: Andres Garrido R.
//Clase que representa al objeto de Post Operatorio para el módulo de clínica
//=======================================================================
public class PostOperatorio {

	private String medicamento;
	private String alimento;
	private String servicio;
	private Time hora; //hora de la atencion
	private Date fecha; //fecha de la atencion
	public PostOperatorio(String med, String alimento, String serv, Time hora, Date fecha){
		this.medicamento = med;
		this.alimento = alimento;
		this.servicio = serv;
		this.hora = hora;
		this.fecha = fecha;
	}
	
	public String getMeds(){
		return this.medicamento;
	}
	public String getAlimento(){
		return this.alimento;
	}
	public String getServicio(){
		return this.servicio;
	}
	public Time getHora(){
		return this.hora;
	}
	public Date getFecha(){
		return this.fecha;
	}
}
