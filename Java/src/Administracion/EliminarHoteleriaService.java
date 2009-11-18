//=======================================================================
// FECHA CREACI�N: 09/11/09 
// AUTOR: Andr�s Garrido
// Clase de la capa 2
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import AdministracionBD.EliminarHoteleriaServiceBD;
import Bd.DBConnectionManager;

/**
 * Clase que elimina un registro de hoteleria (la mascota retira la mascota,
 * luego este registro queda invisible para el usuario)
 * Esta clase adem�s se conecta con su hom�loga EliminarHoteleriaServiceBD
 * para realizar la acci�n.
 * @author Andr�s Garrido 
 * @version 1.0 15/09/09
*/
public class EliminarHoteleriaService {
	Connection conn;
	/**
	 * M�todo que deja como no visible un registro de hoteler�a, dados
	 * la fecha de ingreso al hotel, la de salida, y el canil donde la mascota se hosped�
	 * @param fechaIngreso Fecha de ingreso de la mascota al hotel
	 * @param fechaSalida Fecha de salida de la mascota del hotel
	 * @param canil N�mero del canil donde la mascota se hosped�
	 * @return Entero que determina si la acci�n se realiz� correctamente o no.
	 * @throws SQLException 
	 */
	public int eliminarHoteleria(Date fechaIngreso, Date fechaSalida, int canil) throws SQLException{
		int result=0;
		conn = DBConnectionManager.getConnection();
		EliminarHoteleriaServiceBD object = new EliminarHoteleriaServiceBD(conn);
		result =object.eliminarHoteleria(fechaIngreso, fechaSalida, canil);
		return result;
	}

}
