//=======================================================================
// FECHA CREACIÓN: 02/10/09 
// AUTOR: Andrés Garrido
// Clase que conecta la clase 2 con la 3
//=======================================================================

package Clinica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import ClinicaBD.GetEstadisticasClinicaBD;
import TransferObjects.EstadisticasClinica;
/**
 * Clase que obtiene todas las estadisticas del sistema a partir
 * de una conexion con la capa 3
 * @author Andrés Garrido 
 * @version 1.0 02/10/09
*/
public class GetEstadisticasClinica {

	Connection connection;
	/**
	 * @param tipo tipo de estadistica 1:Pabellon, 2:Policlinico
	 * @param inicio indica el rango inicial de la estadisticas, esto referido a las fechas
	 * @param fin indica el rango final de las estadisticas.
	 * Este metodo hace el llamado a la clase equivalente en la capa de BD.
	 * @return Una lista con todas las atencion registradas en Clínica.
	 */
	public List obtenerEstadisticas(int tipo, String inicio,String fin)
	{		
		List Atenciones=new ArrayList();
    	try{
    		connection=DBConnectionManager.getConnection();
    		GetEstadisticasClinicaBD object= new GetEstadisticasClinicaBD(connection);
			Atenciones	= object.getEstadisticasBD(tipo, inicio, fin);
			connection.close();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
		return Atenciones;
	}
}
