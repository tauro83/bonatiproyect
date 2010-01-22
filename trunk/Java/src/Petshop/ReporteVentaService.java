//=======================================================================
// AUTOR: Sebastian Arancibia
// Descripcion: Clase DiaAgendaService de sistema,
//=======================================================================

package Petshop;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Bd.DBConnectionManager;
import PetshopBD.ReporteVentaBD;
/**
 * Clase para la conexion entre la capa 2 y la capa de 1
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class ReporteVentaService{
	/**
	 * Clase para la conexion entre la capa 2 y la capa de 1
	 * @param fecha
	 * @return Lista de DiaAgenda pertenecientes a la fecha
	 */
    public List getReporteVenta(Date fechaInicio, Date fechaFin){
    	List reportes=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ReporteVentaBD reporteVentaBD= new ReporteVentaBD(connection);
			reportes = reporteVentaBD.getReporteVenta(fechaInicio, fechaFin);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return reportes;
    }
}
