package Bonati;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */
import java.util.ArrayList;


public class Vacunacion extends Registro {
	private ArrayList <Policlinico> vacunas;

        public void eliminarVacuna(Vacuna v) {
                for(int i=0;i<vacunas.size();i++){
                    if(vacunas.get(i).equals(v)){
                        vacunas.remove(i);
                    }
                 }

         }

        public void setAtenciones(Vacuna v) {
               // vacunas.add(v);
                }
        }