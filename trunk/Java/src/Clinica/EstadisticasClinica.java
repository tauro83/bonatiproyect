package Clinica;
//=======================================================================
// AUTOR: Andres Garrido Rojas
// Descripcion: Clase que recolecta estadisticas para clinica,
//				referentes a la frecuencia de atenciones en una determinada
//				área de clinica.
//=======================================================================
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bd.DBConnectionManager;


public class EstadisticasClinica {
	Connection connection;
	PreparedStatement select;
	
	public EstadisticasClinica() throws SQLException{
		this.connection = DBConnectionManager.getConnection();
		String result = null;
		
		String query="";
		query="SELECT * FROM ? WHERE fecha between ? AND ?"+
			"ORDER BY fecha DESC";		
		select = connection.prepareStatement(query);
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones realizadas en Pre Operatorio
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param fechaIni Fecha de inicio de estadistica
	 * @param fechaFin Fecha de fin de estadistica
	 */
	public int getAllPreOperatorio(Date fechaIni, Date fechaFin){
		int size=0;
    	ResultSet result;
    	try {
    		select.setString(1, "PreOperatorio");
    		select.setDate(2, fechaIni);
    		select.setDate(3, fechaFin);
    		result = select.executeQuery();
    		size=result.getFetchSize();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return size;
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones realizadas en Post Operatorio
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param fechaIni Fecha de inicio de estadistica
	 * @param fechaFin Fecha de fin de estadistica
	 */
	public int getAllPostOperatorio(Date fechaIni, Date fechaFin){
		int size=0;
    	ResultSet result;
    	try {
    		select.setString(1, "PostOperatorio");
    		select.setDate(2, fechaIni);
    		select.setDate(3, fechaFin);
    		result = select.executeQuery();
    		size=result.getFetchSize();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return size;
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones realizadas en Cirugia
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param fechaIni Fecha de inicio de estadistica
	 * @param fechaFin Fecha de fin de estadistica
	 */
	public int getAllCirugia(Date fechaIni, Date fechaFin){
		int size=0;
    	ResultSet result;
    	try {
    		select.setString(1, "Cirugia");
    		select.setDate(2, fechaIni);
    		select.setDate(3, fechaFin);
    		result = select.executeQuery();
    		size=result.getFetchSize();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return size;
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones realizadas en Consulta
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param fechaIni Fecha de inicio de estadistica
	 * @param fechaFin Fecha de fin de estadistica
	 */
	public int getAllConsulta(Date fechaIni, Date fechaFin){
		int size=0;
    	ResultSet result;
    	try {
    		select.setString(1, "Consulta");
    		select.setDate(2, fechaIni);
    		select.setDate(3, fechaFin);
    		result = select.executeQuery();
    		size=result.getFetchSize();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return size;
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones realizadas en Control
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param fechaIni Fecha de inicio de estadistica
	 * @param fechaFin Fecha de fin de estadistica
	 */
	public int getAllControl(Date fechaIni, Date fechaFin){
		int size=0;
    	ResultSet result;
    	try {
    		select.setString(1, "Control");
    		select.setDate(2, fechaIni);
    		select.setDate(3, fechaFin);
    		result = select.executeQuery();
    		size=result.getFetchSize();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return size;
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones realizadas en Vacuna
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param fechaIni Fecha de inicio de estadistica
	 * @param fechaFin Fecha de fin de estadistica
	 */
	public int getAllVacuna(Date fechaIni, Date fechaFin){
		int size=0;
    	ResultSet result;
    	try {
    		select.setString(1, "Vacuna");
    		select.setDate(2, fechaIni);
    		select.setDate(3, fechaFin);
    		result = select.executeQuery();
    		size=result.getFetchSize();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return size;
	}

}
