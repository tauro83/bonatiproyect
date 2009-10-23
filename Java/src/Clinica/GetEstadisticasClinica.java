package Clinica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import ClinicaBD.GetEstadisticasClinicaBD;
import TransferObjects.EstadisticasClinica;

public class GetEstadisticasClinica {

	Connection connection;
	/**
	 * @param tipo tipo de estadistica 1:Pabellon, 2:Policlinico
	 * @param inicio indica el rango inicial de la estadisticas, esto referido a las fechas
	 * @param fin indica el rango final de las estadisticas.
	 * Este metodo hace el llamado a la clase equivalente en la capa de BD.
	 */
	public List<EstadisticasClinica> obtenerEstadisticas(int tipo, String inicio,String fin)
	{		
		List<EstadisticasClinica> Atenciones=new ArrayList<EstadisticasClinica>();
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
