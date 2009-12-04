//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz
// Comentarios: Encargada de enviar y recibir datos entre la interfaz
//				y la capa lógica
//=======================================================================

package AvisoWeb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Usuario;

import AvisoWeb.AvisoWeb;
import AvisoWeb.AvisoWebServiceBD;
import Bd.DBConnectionManager;


public class AvisoWebService {

	/**
	 * Trata de desactivar el aviso registrado en la base de datos
	 * @return Resultado de la operación realizada
	 */
	public int delAviso(String id)
    {
		int result = 0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AvisoWebServiceBD personDB= new AvisoWebServiceBD(connection);
			result = personDB.delAvisoBD(id);		
			
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	/**
	 * Trata de anular el aviso registrado en la base de datos
	 * @return Resultado de la operación realizada
	 */
	public int anulAviso(String id)
    {
		int result = 0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AvisoWebServiceBD personDB= new AvisoWebServiceBD(connection);
			result = personDB.anulAvisoBD(id);		
			
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	/**
	 * Trata de editar el aviso registrado en la base de datos
	 * @return Resultado de la operación realizada
	 */
	public int upAvisoWeb(AvisoWeb aviso)
    {
		int result = 0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AvisoWebServiceBD personDB= new AvisoWebServiceBD(connection);
			result = personDB.upAvisoWebBD(aviso);		
			
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

	
	
	/**
	 * Trata de obtener todos los avisos registrados en la base de datos
	 * @return Lista con todos los avisos registrados
	 */
	public List<AvisoWeb> getAllAvisoWeb()
    {
    	List<AvisoWeb> persons=new ArrayList<AvisoWeb>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AvisoWebServiceBD personDB= new AvisoWebServiceBD(connection);
			persons= personDB.getAllAvisoWebBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	/**
	 * Trata de obtener todos los avisos registrados en la base de datos
	 * @return Lista con todos los avisos registrados
	 */
	public List<AvisoWeb> getAllAvisoWebA()
    {
    	List<AvisoWeb> persons=new ArrayList<AvisoWeb>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AvisoWebServiceBD personDB= new AvisoWebServiceBD(connection);
			persons= personDB.getAllAvisoWebABD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
}
