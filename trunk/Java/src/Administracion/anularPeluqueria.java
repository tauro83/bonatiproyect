//=======================================================================
// FECHA CREACIÓN: 16/11/09
// AUTOR: Nicolas Delgado
// Clase encargada de realizar todas las conexiones para
// para eliminar, anular y seseliminar un registro de peluquería que se 
// encuentre al interio de la base de datos. 
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.anularPeluqueriaBD;
import Bd.DBConnectionManager;
import TransferObjects.anuPeluqueria;

public class anularPeluqueria {
	/**
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos del sistema.
	 * @return Lista con todos los registros de peluquería.
	 */
	public List<anuPeluqueria> getAllVacunaciones()
    {
		List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
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
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos de un cliente determinado.
	 * @return Lista con todos los registros de peluquería.
	 */
	public List<anuPeluqueria> getAllVacunacionesU(String rut)
    {
		List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
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
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos de un cliente determinado, que ya se encontraba eliminado.
	 * @return Lista con todos los registros de peluquería.
	 */
	
	public List<anuPeluqueria> getAllVacunacionesA()
    {
		List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesA();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	/**
	 * Anula todos los registros de peluquería solicitados por el usuario
	 * de la base de datos.
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 2 si ha anulado correctamente y 0 de lo contrario
	 */
	public int anular(Integer estado,String nombreMascota,String hora)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.anular(estado,nombreMascota,hora);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Elimina todos los registros de peluquería solicitados por el usuario
	 * de la base de datos.
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha eliminado correctamente y 0 de lo contrario
	 */
	public int eliminar(Integer estado,String nombreMascota,String hora)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.eliminar(estado,nombreMascota,hora);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	
	/**
	 * Deselimina todos los registros de peluquería solicitados por el usuario
	 * de la base de datos.
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 0 si ha deseliminado correctamente y 1 de lo contrario.
	 */
	public int deseliminar(Integer estado,String nombreMascota,String hora)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.deseliminar(estado,nombreMascota,hora);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
}
