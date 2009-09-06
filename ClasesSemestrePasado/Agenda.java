package Bonati;

public class Agenda {
	private int idDiaBloqueado;
	private int idServicio;
	private int idAgenda;

        public Agenda(int idAgenda, int idDiaBloqueado,int idServicio){
            this.idAgenda = idAgenda;
            this.idDiaBloqueado = idDiaBloqueado;
            this.idServicio =  idServicio;
        }
        

        public void setIdDiaBloqueado(int d) {
            this.idDiaBloqueado = d;
	}
        public void setIdServicio(int id) {
            this.idServicio = id;
	}

         public void setIdAgenda(int id) {
            this.idAgenda = id;
	}

        public int getidDiaBloqueado() {
            return idDiaBloqueado;
	}
		
	public int getIdServicio() {
            return idServicio;
	}

	public int getIdAgenda() {
            return idAgenda;
	}

	
}
