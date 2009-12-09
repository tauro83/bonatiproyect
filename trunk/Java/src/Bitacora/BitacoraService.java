//=======================================================================
// FECHA CREACIÓN: 02/12/09
// AUTOR: Erwin Díaz
// Comentarios: Encargada de enviar y recibir datos entre la interfaz
//				y la capa lógica
//=======================================================================

package Bitacora;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bitacora.Bitacora;
import Bitacora.BitacoraServiceBD;
import Bd.DBConnectionManager;

/**
 * Encargada de enviar y recibir datos entre la interfaz y la capa lógica
 * @author Erwin Díaz
 *
 */
public class BitacoraService {

	/**
	 * Trata de obtener todos los eventos registrados en la base de datos
	 * @return Lista con todos los eventos registrados
	 * @author Erwin Díaz
	 */
	public List<Bitacora> getAllEventos()
    {
    	List<Bitacora> persons=new ArrayList<Bitacora>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BitacoraServiceBD personDB= new BitacoraServiceBD(connection);
			persons= personDB.getAllEventosBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
}
