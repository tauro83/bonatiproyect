package Bonati;



public class Servicio {
	private String nombre;
	private String descripcion;
	private int idServicio;
	private int idAdmin;
        private int costo;



        public Servicio(){
            
        }
	protected String getNombre() {
        return this.nombre;
	}
	
	protected String getDescripcion() {
        return this.descripcion;
	}
	
	protected int getAdministrador() {
        return this.idAdmin;
	}
	
	protected void setNombre(String nombre) {
        this.nombre = nombre;
	}
	
	protected void setDescripcion(String descripcion) {
        this.descripcion = this.descripcion.concat(descripcion);
	}
	
	protected void setAdministrador(int u) {
        this.idAdmin = u;
	}
	
	protected int getIdServicio() {
        return this.idServicio;
	}
	
	protected void setId(int id) {
        this.idServicio = id;
	}
        
        protected int getIdAdministrador(){
            return this.idAdmin;
        }
        
        protected void setIdAdministrador(int id){
            this.idAdmin = id;
        }

        protected void setCosto(int costo){
            this.costo = costo;
        }

        protected int getCosto(){
            return this.costo;
        }
}

