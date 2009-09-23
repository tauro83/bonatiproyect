package transferObjects;


public class Mascota 
{
    public String nombre;
    public String raza;
    public String fecha_nacimiento;
    public String sexo;
    public int edad;
    public int estado;// 0 purgado, 1 no purgado 
    public int id;
    
    public Mascota(){
    	this.estado = 1;
    }
	public void setNombre(String name) {
		this.nombre = name;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public void setFechaNacimiento(String fecha){
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
	public String getFechaNacimiento(){
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
