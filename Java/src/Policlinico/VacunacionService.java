//=======================================================================
// FECHA: CREACIÓN: 27-10-09
// AUTOR: Esteban Cruz
// Script para anular o eliminar una vacunación desde la base de datos, además,
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package Policlinico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import PoliclinicoBD.VacunacionBD;

import TransferObjects.vacunacionesObj;;


public class VacunacionService 
{
	/**
	 * Trata de obtener todos las vacunaciones registrados en la base de datos
	 * @return Lista con todos las vacunaciones registrados
	 */
	public List<vacunacionesObj> getAllVacunaciones()
    {
		List<vacunacionesObj> vacunaciones = new ArrayList<vacunacionesObj>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			vacunaciones = vacunacionBD.getAllVacunaciones();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	/**
	 * Trata de obtener todos las vacunaciones registrados en la base de datos
	 * de un cliente determinado
	 * @return Lista con todos las vacunaciones registrados
	 */
	public List<vacunacionesObj> getAllVacunacionesU(String rut)
    {
		List<vacunacionesObj> vacunaciones = new ArrayList<vacunacionesObj>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesU(rut);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	/**
	 * Anula todas las vacunaciones solicitadas por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha anulado correctamente y 0 de lo contrario
	 */
	public int anular(String estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			result = vacunacionBD.anular(estado);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Elimina todas las vacunaciones solicitadas por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha eliminado correctamente y 0 de lo contrario
	 */
	public int eliminar(String estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			result = vacunacionBD.eliminar(estado);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
}
