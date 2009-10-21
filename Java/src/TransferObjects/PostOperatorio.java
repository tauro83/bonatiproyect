package TransferObjects;
//=======================================================================
//FECHA CREACIÓN: 13-10-09
//AUTOR: Andres Garrido R.
//Clase que representa al objeto de Post Operatorio para el módulo de clínica
//=======================================================================
public class PostOperatorio extends Atencion{

	private String medicamentos;
	private String alimentos;
	private String indicaciones;
	
	public PostOperatorio(String med, String alimento, String indicacion
			, String hora, String fecha, String cost, String coment){
		super();
		this.medicamentos = med;
		this.alimentos = alimento;
		this.indicaciones=indicacion;
		this.setHora(hora);
		this.setFecha(fecha);
		this.setCosto(cost);
	}
	
	public String getMedicamentos(){
		return this.medicamentos;
	}
	public String getAlimentos(){
		return this.alimentos;
	}

	public String getIndicaciones(){
		return this.indicaciones;
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
