package Bonati;


public class Canil {
	private int id;
	private int idServicio;
	private boolean estado;
	private String comentario;

        public Canil(){
            this.comentario = new String();
        }
	public int getId() {
            return id;
	}
	
	public int getIdServicio() {
            return idServicio;
	}
	
	public void setIdServicio(int id) {
            this.idServicio = id;
	}
	
	public boolean getEstado() {
            return estado;
	}
	
	public void setId(int i) {
            this.id=i;
	}
	
	public void setEstado(boolean e) {
            this.estado = e;
	}

        public void addComentarios(String s){
            this.comentario = this.comentario.concat(s);
        }

}
