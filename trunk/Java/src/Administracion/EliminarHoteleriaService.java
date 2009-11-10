//=======================================================================
// FECHA CREACIÓN: 09/11/09 
// AUTOR: Andrés Garrido
// Clase de la capa 2
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.Date;

/**
 * Clase que elimina un registro de hoteleria (la mascota retira la mascota,
 * luego este registro queda invisible para el usuario)
 * Esta clase además se conecta con su homóloga EliminarHoteleriaServiceBD
 * para realizar la acción.
 * @author Andrés Garrido 
 * @version 1.0 15/09/09
*/
public class EliminarHoteleriaService {
	Connection conn;
	/**
	 * Método que deja como no visible un registro de hotelería, dados
	 * la fecha de ingreso al hotel, la de salida, y el canil donde la mascota se hospedó
	 * @param fechaIngreso Fecha de ingreso de la mascota al hotel
	 * @param fechaSalida Fecha de salida de la mascota del hotel
	 * @param canil Número del canil donde la mascota se hospedó
	 * @return Entero que determina si la acción se realizó correctamente o no.
	 */
	public int eliminarHoteleria(Date fechaIngreso, Date fechaSalida, int canil){
		int result=0;
		return result;
	}

}
