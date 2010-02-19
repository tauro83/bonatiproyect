//=======================================================================
// FECHA: CREACI�N: 14-10-09
// AUTOR: Esteban Cruz
// Script para anular o eliminar una cirugia desde la base de datos, adem�s,
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import PabellonBD.CirugiaBD;


public class CirugiaService 
{
	/**
	 * Trata de obtener todos las cirugias registrados en la base de datos
	 * @return Lista con todos las cirguias registrados
	 * @author  "Esteban Cruz"
	 */
	public List getAllCirugias()
    {
		List cirugias = new ArrayList();
    	try{
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			cirugias = cirugiaBD.getAllCirugias();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	
	public List getAllCirugiasAnul()
    {
		List cirugias = new ArrayList();
    	try{
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			cirugias = cirugiaBD.getAllCirugiasAnul();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	
    public List getAllCirugiasTodo()
    {
		List cirugias = new ArrayList();
    	try{
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			cirugias = cirugiaBD.getAllCirugiasTodo();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	/**
	 * Trata de obtener todos las vacunaciones registrados en la base de datos
	 * de un cliente determinado
	 * @return Lista con todos las vacunaciones registrados
	 * @author  "Esteban Cruz"
	 */
	public List getAllCirugiasUEC(String rut, String nombre)
    {
		List cirugias = new ArrayList();
    	try{	
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			cirugias = cirugiaBD.getAllCirugiasUEC(rut, nombre);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	
	public List getAllCirugiasU2(String rut, String nombre)
    {
		List cirugias = new ArrayList();
    	try{	
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			cirugias = cirugiaBD.getAllCirugiasU2(rut, nombre);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	
	/**
	 * Anula todas las vacunaciones solicitadas por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha anulado correctamente y 0 de lo contrario
	 * @author  "Esteban Cruz"
	 */
	public int anularCirugia(String nombre, String fecha, String hora)
    {
		int result = 0;
    	try 
		{
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			result = cirugiaBD.anularCirugia(nombre, fecha, hora);
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
	public int eliminarCirugia(String nombre, String fecha, String hora)
    {
		int result = 0;
    	try 
		{
    		Connection connection=DBConnectionManager.getConnection();
			CirugiaBD cirugiaBD= new CirugiaBD(connection);
			result = cirugiaBD.eliminarCirugia(nombre, fecha, hora);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
}
