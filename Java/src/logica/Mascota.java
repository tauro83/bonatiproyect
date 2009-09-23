package logica;

import java.sql.Date;

public class Mascota 
{
    private String nombre;
    private String raza;
    private Date fecha_nacimiento;
    private String sexo;
    private int edad;
    private int estado;// 0 eliminado, 1 no eliminado 
    private int id;
    
    public Mascota(){
    	this.estado = 1;
    }
	public void setNombre(String name) {
		this.nombre = name;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public void setFechaNacimiento(Date fecha){
		this.fecha_nacimiento = fecha;
	}
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	public void setEdad(int edad){
		this.edad = edad;
	}
	public void setEstado(int x){
		this.estado = x;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getRaza(){
		return this.raza;
	}
	public Date getFechaNacimiento(){
		return this.fecha_nacimiento;
	}
	public String getSexo(){
		return this.sexo;
	}
	public int getEdad(){
		return this.edad;
	}
	public int getEstado(){
		return this.estado;
	}
	public int getID(){
		return this.id;
	}
}
