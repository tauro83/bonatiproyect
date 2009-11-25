//=======================================================================
//FECHA CREACI�N: 20/11/09
//AUTOR: Erwin D�az
//Comentarios: Transfiere datos entre la capa l�gica y la base de datos
//			   y entre la interf�z y la capa l�gica
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Pago;
import Petshop.ElimPagoBD;
import Bd.DBConnectionManager;

public class ElimPagoService {

	/**
	 * Funcion que permite ocultar un pago
	 * @param fecha es la fecha del pago
	 * @param hora hora en la que se realiz� el pago
	 * con este par�metro se hace la selecci�n de
	 * una tupla en la base de datos
	 * @return retorna el estado de la conexion
	 */
	public int deletePagoH(String fecha, String hora)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ElimPagoBD userDB= new ElimPagoBD(connection);
			result= userDB.deletePagoHBD(fecha, hora);
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * Funcion que permite ocultar un pago
	 * @param fecha es la fecha del pago
	 * @param hora hora en la que se realiz� el pago
	 * con este par�metro se hace la selecci�n de
	 * una tupla en la base de datos
	 * @return retorna el estado de la conexion
	 */
	public int deletePago(String fecha, String hora)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ElimPagoBD userDB= new ElimPagoBD(connection);
			result= userDB.deletePagoBD(fecha, hora);
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * Funcion que retorna una lista de pagos desde la base de datos
	 * para enviarlo a la capa 1
	 * @return
	 */
	public List<Pago> getAllPagosE()
    {
    	List<Pago> persons=new ArrayList<Pago>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ElimPagoBD personDB= new ElimPagoBD(connection);
			persons= personDB.getAllPagosEBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	/**
	 * Funcion que retorna una lista de pagos desde la base de datos
	 * para enviarlo a la capa 1
	 * @return
	 */
	public List<Pago> getAllPagos()
    {
    	List<Pago> persons=new ArrayList<Pago>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ElimPagoBD personDB= new ElimPagoBD(connection);
			persons= personDB.getAllPagosBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
}
