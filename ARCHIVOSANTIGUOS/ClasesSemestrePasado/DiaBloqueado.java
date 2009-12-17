
package Bonati;

import java.util.Date;


public class DiaBloqueado {

    private Date dia;
    private int idAgenda;

    public DiaBloqueado(Date d, int idAgenda){
        this.dia = d;
        this.idAgenda = idAgenda;
    }


    public Date getDia(){
        return dia;
    }
    public int getIdAgenda(){
        return idAgenda;
    }

    public void setDia(Date d){
        dia = d;
    }
    public void setIdAgenda(int id){
        idAgenda = id;
    }


}
