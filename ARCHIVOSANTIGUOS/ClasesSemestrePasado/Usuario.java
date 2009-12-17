package Bonati;


public class Usuario {
	private String nombre;
	private String contraseña;
	private String cargo;
	private int privilegio;
	private int idServicio;

        public Usuario(String nombre, String contraseña, String cargo, int privilegio, int idServicio){
            this.nombre = nombre;
            this.contraseña = contraseña;
            this.cargo = cargo;
            this.idServicio = idServicio;
            this.privilegio = privilegio;
        }


	public String getNombre() {
            return nombre;
	}
	
	public String getContraseña() {
            return contraseña;
	}
	
	public String getCargo() {
            return cargo;
	}
	
	public int getPrivilegio() {
            return privilegio;
	}

        public int getidServicio() {
            return idServicio;
	}
	
	public void setNombre(String n) {
           nombre = n;
	}
	
	public void setContraseña(String s) {
            contraseña = s;
	}
	
	public void setCargo(String c) {
            cargo = c;
	}
	
	public void setPrivilegio(int p) {
            privilegio = p;
	}
}