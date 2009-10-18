package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import Bd.DBConnectionManager;

/**
 * @author Camilo Verdugo
 * @version 2
 * Clase que llama al metodo del paquete PeluqueriaBD, para obtener los datos de las atenciones
 * de peluqueria
 *  		
 **/

public class getEstadisticas {

	/**
	 * 
	 * @param inicio indica el rango inicial de la estadisticas, esto referido a las fechas
	 * @param fin indica el rango final de las estadisticas.
	 */
	public static Object getEstadisticas(int inicio, int fin) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		return new Object();
	}
}


