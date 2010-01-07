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
import AdministracionBD.anularPreoperatorioBD;
import Bd.DBConnectionManager;
import TransferObjects.anuPeluqueria;
import TransferObjects.anuPreoperatorio;

public class anularPreoperatorio {
	/**
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos del sistema.
	 * @return Lista con todos los registros de peluquería.
	 */
	public List getAllVacunaciones()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
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
	public List getAllVacunacionesU(String rut)
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
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
	
	public List getAllVacunacionesV()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesV();
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
	public int anular(int estado,String nombreMascota,String hora,String motivo)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
			result = vacunacionBD.anular(estado, nombreMascota, hora, motivo);
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
	public int eliminar(int estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
			result = vacunacionBD.eliminar(estado);
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
	public int deseliminar(int estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
			result = vacunacionBD.deseliminar(estado);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
}
