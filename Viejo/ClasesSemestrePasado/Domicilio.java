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


public class Domicilio extends Registro {
	private String veterinario;
	private String ayudante;
	private String direccion;
        private ArrayList <Policlinico> atenciones;

        public Domicilio(String veterinario, String ayudante, String direccion){
            this.veterinario=veterinario;
            this.ayudante=ayudante;
            this.direccion=direccion;

        }
	public void getVeterinario(String v) {
            this.veterinario=v;
	}

        public void getAyudante(String a) {
            this.ayudante=a;
	}

        public void getDireccion(String d) {
            this.direccion=d;
	}

        public String SetVeterinario(){
            return this.veterinario;
        }

        public String SetAyudante(){
            return this.ayudante;
        }

        public String SetDireccion(){
            return this.direccion;
        }

       /*public void setAtenciones(Domicilio d) {
        atenciones.add(d);
	}*/

}

