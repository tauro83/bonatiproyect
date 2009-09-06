package Bonati;

//package policlinico;
import java.util.Date;


public class Consulta {
	private String descripcion;
	private Date proximaFecha;
	private String recomendacion;

        public Consulta(String descripcion, Date proximaFecha, String recomendacion){
            this.descripcion=descripcion;
            this.proximaFecha=proximaFecha;
            this.recomendacion=recomendacion;
        }
	public String getDescripcion() {
            return this.descripcion;
	}

	public Date getProximaFecha() {
            return this.proximaFecha;
	}

	public String getRecomendacion() {
            return this.recomendacion;
	}

	public void setDescripcion(String d) {
            this.descripcion=d;
	}

	public void setProximaFecha(Date d) {
            this.proximaFecha=d;
	}

	public void setRecomendacion(String r) {
            this.recomendacion=r;
	}
}

