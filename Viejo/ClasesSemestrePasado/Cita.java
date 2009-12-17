package Bonati;

import java.sql.Time;
import java.util.Date;


public class Cita {
	private Date dia;
	private Time horaInicio;
	private Time horaFin;
	private int idAgenda;
	private int idCita;
        private int idMascota;
        private String rutCliente;
     
        public Cita(){         
        }

        public String getRutCliente(){
            return rutCliente;
        }
	public Date getDia() {
            return dia;
	}	
	public Time getHoraInicio() {
            return horaInicio;
	}	
	public Time getHoraFin() {
            return horaFin;
	}
        public int getIdCita() {
            return idCita;
	}
        public int getIdAgenda() {
            return idAgenda;
	}
        public int getIdMascota() {
            return idMascota;
	}

        public void setRutCliente(String rutCliente){
            this.rutCliente = rutCliente;
        }

        public void setDia(Date d) {
            dia = d;
	}
	public void setHoraInicio(Time i) {
             horaInicio = i;
	}	
	public void setHoraFin(Time f) {
             horaFin = f;
        }

        public void setIdMascota(int idMascota) {
            this.idMascota = idMascota;
	}
	public void setIdAgenda(int id) {
            idAgenda = id;
	}		
	public void setIdCita(int id) {
            idCita = id;
	}
}
