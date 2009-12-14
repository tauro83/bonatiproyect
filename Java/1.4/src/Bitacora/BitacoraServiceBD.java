//=======================================================================
// FECHA CREACIÓN: 02/12/09
// AUTOR: Erwin Díaz
// Comentarios: Encargada de enviar y recibir datos entre la base de datos
//				y la capa lógica
//=======================================================================


package Bitacora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bitacora.Bitacora;
/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin Díaz
 *
 */
public class BitacoraServiceBD {
	
	PreparedStatement selectAll;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 * @author Erwin Díaz
	 */
	public BitacoraServiceBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "SELECT fecha, usuario, servicio, accion "+
				"FROM bitacora2;";
			selectAll = connection.prepareStatement(query);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
     * Trata de obtener todos los eventos registrados en la base de datos
     * @return Lista con todos los eventos registrados
     * @autor Erwin Díaz
     */
	public List getAllEventosBD()
    {
    	List  persons=new ArrayList();
    	Bitacora person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new Bitacora();
   
    			person.fecha = result.getString(1).trim();
    			person.usuario = result.getString(2).trim();
    			person.servicio = result.getString(3).trim();
    			person.accion = result.getString(4).trim();
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
}
