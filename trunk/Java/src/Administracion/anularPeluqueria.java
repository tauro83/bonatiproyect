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
import PabellonBD.PostOperatorioBD;
import TransferObjects.anuPeluqueria;

public class anularPeluqueria {
	/**
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos del sistema.
	 * @return Lista con todos los registros de peluquería.
	 */
	public List getAllPeluqueria()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllPeluqueria();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public List getAllPostOperatorioAnul()
    {
    	List persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD personDB= new anularPeluqueriaBD(connection);
			persons= personDB.getAllPeluqueriaV1();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	
	/**
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos de un cliente determinado.
	 * @return Lista con todos los registros de peluquería.
	 */
	public List getAllPeluqueriaU(String rut)
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllPeluqueriaU(rut);
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
	
	public List getAllPeluqueriaA()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllPeluqueriaA();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public List getAllPeluqueriaV()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllPeluqueriaV();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public List getAllPeluqueriaR(String nombreMascota, String clienterut) {
    	List persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD personDB= new anularPeluqueriaBD(connection);
			persons= personDB.getAllPeluqueriaR2(nombreMascota,clienterut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	

	/**
	 * Anula todos los registros de peluquería solicitados por el usuario
	 * de la base de datos.
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 2 si ha anulado correctamente y 0 de lo contrario
	 */
	public int anular(int estado,String nombreMascota,String hora,String nombreCatalogo,String motivo)
    {
		int result = 0;
    	try  
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.anular(estado,nombreMascota,hora,nombreCatalogo,motivo);
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
	public int eliminar(int estado,String nombreMascota,String hora,String nombreCatalogo)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.eliminar(estado,nombreMascota,hora,nombreCatalogo);
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
	public int deseliminar(int estado,String nombreMascota,String hora,String nombreCatalogo)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.deseliminar(estado,nombreMascota,hora,nombreCatalogo);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	public List getTodas()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getTodas();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
}
