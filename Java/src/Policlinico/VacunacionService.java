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
import PabellonBD.CirugiaBD;
import PoliclinicoBD.VacunacionBD;


public class VacunacionService 
{
	/**
	 * Trata de obtener todos las vacunaciones registrados en la base de datos
	 * @return Lista con todos las vacunaciones registrados
	 * @author  "Esteban Cruz"
	 */
	public List getAllVacunaciones()
    {
		List vacunaciones = new ArrayList();
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
	
	public List getAllVacunacionesAnul()
    {
		List vacunaciones = new ArrayList();
    	try{
    		Connection connection=DBConnectionManager.getConnection();
    		VacunacionBD vacunacionBD= new VacunacionBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesAnul();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
    public List getAllVacunacionesTodo()
    {
		List vacunaciones = new ArrayList();
    	try{
    		Connection connection=DBConnectionManager.getConnection();
    		VacunacionBD vacunacionBD= new VacunacionBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesTodo();	
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
	 * @author  "Esteban Cruz"
	 */
	public List getAllVacunacionesU(String rut, String nombre)
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesU(rut, nombre);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public List getAllVacunacionesU2(String rut, String nombre)
    {
		List vacunaciones = new ArrayList();
    	try{	
    		Connection connection=DBConnectionManager.getConnection();
    		VacunacionBD vacunacionBD= new VacunacionBD(connection);
    		vacunaciones = vacunacionBD.getAllVacunacionesU2(rut, nombre);
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
	 * @author  "Esteban Cruz"
	 */
	public int anular(String nombre, String fecha, String hora, String motivo)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			result = vacunacionBD.anular(nombre, fecha, hora, motivo);
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
	 * @author  "Esteban Cruz"
	 */
	public int eliminar(String nombre, String fecha, String hora)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			result = vacunacionBD.eliminar(nombre, fecha, hora);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	public List getAllDatos()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			vacunaciones = vacunacionBD.getAllDatos();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public int regBit(String nombre, String rut, String id, String motivo)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			VacunacionBD vacunacionBD= new VacunacionBD(connection);
			result= vacunacionBD.regBit(nombre, rut, id, motivo);
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
}
