package Bonati;

import java.awt.Image;
import java.util.Date;


public class Mascota {
	private int id;
	private int sexo;
	private String nombre;
	private int edad;
	private Date fechaNacimiento;
	private String raza;
	private String rutDueño;
	private boolean visible;
	private Image foto;
	private int idFicha;

        public Mascota(int id, int sexo, int edad, int idFicha, String nombre,String raza, String rutDueño, Date fechaNacimiento, Boolean visible, Image foto){
            this.id = id;
            this.sexo = sexo;
            this.edad = edad;
            this.idFicha = idFicha;
            this.nombre = nombre;
            this.raza = raza;
            this.rutDueño = rutDueño;
            this.fechaNacimiento = fechaNacimiento;
            this.visible = visible;
            this.foto = foto;            
        }

	public int getId() {
            return this.id;
	}	
	public int getSexo() {
            return this.sexo;
	}	
	public String getNombre() {
            return nombre;
	}	
	public int getEdad() {
            return this.edad;
	}	
	public Date getFechaNacimiento() {
            return this.fechaNacimiento;
	}	
	public String getRaza() {
            return this.raza;
	}	
	public String getRutDueño() {
            return rutDueño;
	}	
	public boolean getEstado() {
            return visible;
	}	
	public Image getFoto() {
            return foto;
	}	
	public int getIdFicha() {
            return idFicha;
	}
        public void setIdFicha(int id) {
            this.idFicha = id;
	}	
	public void setId(int i) {
            this.id=i;
	}	
	public void setSexo(int i) {
            this.sexo = i;
	}	
	public void setNombre(String n) {
            this.nombre = n;
	}	
	public void setEdad(int e) {
            this.edad = e;
	}	
	public void setFechaNacimiento(Date f) {
            this.fechaNacimiento = f;
	}	
	public void setRaza(String r) {
            this.raza = r;
	}	
	public void setRutDueño(String rut){
            this.rutDueño = rut;
	}	
	public void setEstado(boolean e) {
            this.visible =e;
	}	
	public void setFoto(Image p) {
            this.foto = p;
	}	
}
