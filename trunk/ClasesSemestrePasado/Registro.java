package Bonati;

import java.sql.Time;
import java.util.Date;

public abstract class Registro {

	protected int costoAtencion;
	protected String atencionRealizada;
	protected Date fecha;
	protected int idMascota;
	protected Time hora;
	protected int idRegistro;
	protected int idServicio;
	protected int idFicha;


	protected int getCostoAtencion() {
            return costoAtencion;
	}	
        protected String getAtencionRealizada() {
            return atencionRealizada;
	}        
        protected Date getFecha() {
            return fecha;
	}
        protected int getIdMascota(){
            return idMascota;
        }
        protected Time getHora() {
            return hora;
	}
	protected int getIdRegistro() {
            return idRegistro;
	}
        protected int getIdServicio(){
            return idServicio;
        }
        protected int getIdFicha(){
            return idFicha;
        }
	protected void setCostoAtencion(int CostoAtencion){
            this.costoAtencion = CostoAtencion;
        }
	protected void setAtencionRealizada(String AtencionRealizada){
            this.atencionRealizada = AtencionRealizada;
        }
        protected void setFecha(Date f){
            this.fecha = f;
        }
        protected void setIdMascota(int IdMascota){
            this.idMascota = IdMascota;
        }
        protected void setHora(Time Hora){
            this.hora = Hora;
        }
        protected void setIdRegistro(int IdRegistro){
            this.idRegistro = IdRegistro;
        }
        protected void setIdServicio(int IdServicio){
            this.idServicio = IdServicio;
        }
        protected void setIdFicha(int IdFicha){
            this.idFicha = IdFicha;
        }

}
