//=======================================================================
//FECHA CREACIÓN: 20/11/09
//AUTOR: Erwin Díaz
//Comentarios: Transfiere datos entre la capa lógica y la base de datos
//			   y entre la interfáz y la capa lógica
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
	 * @param hora hora en la que se realizó el pago
	 * con este parámetro se hace la selección de
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
	 * @param hora hora en la que se realizó el pago
	 * con este parámetro se hace la selección de
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
