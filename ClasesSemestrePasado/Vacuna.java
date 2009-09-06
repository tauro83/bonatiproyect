package Bonati;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */

public class Vacuna{
//public class Vacuna extends Producto {
	private String nombre;
	private String descripcion;


        public Vacuna(String nombre, String descripcion){

            this.nombre=nombre;
            this.descripcion=descripcion;
        }

        public String getNombre() {
            return this.nombre;
	}

	public String getDescripcion() {
            return this.descripcion;
	}

	public void setNombre(String n) {
            this.nombre=n;
	}

	public void setDescripcion(String d) {
            this.descripcion=d;
	}

    String get() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}