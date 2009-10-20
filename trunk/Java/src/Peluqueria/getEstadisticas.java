package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import PeluqueriaBD.GetEstadisticasAtencionesBD;
import Bd.DBConnectionManager;
import TransferObjects.EstadisticasPeluqueria;

/**
 * @author Camilo Verdugo
 * @version 2
 * Clase que llama al metodo del paquete PeluqueriaBD, para obtener los datos de las atenciones
 * de peluqueria
 *  		
 **/

public class GetEstadisticas {

	Connection connection;
	/**
	 * 
	 * @param inicio indica el rango inicial de la estadisticas, esto referido a las fechas
	 * @param fin indica el rango final de las estadisticas.
	 * Este metodo hace el llamado a la clase equivalente en la capa de BD.
	 */
	public List<EstadisticasPeluqueria> obtenerEstadisticas(String inicio,String fin)
	{		
		List<EstadisticasPeluqueria> Atenciones=new ArrayList<EstadisticasPeluqueria>();
    	try 
		{
    		connection=DBConnectionManager.getConnection();
    		GetEstadisticasAtencionesBD gEABD= new GetEstadisticasAtencionesBD(connection);
			Atenciones	= gEABD.getEstadisticasBD(inicio,fin);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Atenciones;
	}
}


