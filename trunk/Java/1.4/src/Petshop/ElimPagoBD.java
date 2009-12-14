//=======================================================================
// FECHA CREACIÓN: 20/11/09
// AUTOR: Erwin Díaz
// Comentarios: Transfiere datos entre la base de datos hacia la
//				capa lógica.
//=======================================================================
package Petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Pago;
/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin Díaz
 *
 */
public class ElimPagoBD {
	
	PreparedStatement selectAll;
	PreparedStatement selectAllE;
	PreparedStatement deletePago;
	PreparedStatement deletePagoH;
	
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public ElimPagoBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "SELECT pago.fecha, pago.hora, pago.total "+
			"FROM pago where pago.estado='0';";
			selectAll = connection.prepareStatement(query);
		
			query = "SELECT pago.fecha, pago.hora, pago.total "+
			"FROM pago where pago.estado='1';";
			selectAllE = connection.prepareStatement(query);
			
			query = "UPDATE pago "+
			"SET estado = 1 " +
			"WHERE fecha = ? AND hora = ?;";
			deletePago= connection.prepareStatement(query);

			query = "UPDATE pago "+
			"SET estado = 2 " +
			"WHERE fecha = ? AND hora = ?;";
			deletePagoH= connection.prepareStatement(query);
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Elimina un usuario de la base de datos
	 * @param clave Nombre de usuario obtenido desde la capa de interfáz con el usuario
	 * @return 1 si se ha eliminado correctamente, -1 o 0 la eliminación ha fallado
	 */
    public int deletePagoHBD(String fecha, String hora)
    {
    	int result=0;
    	try 
    	{
    		deletePagoH.setString(1, fecha);
    		deletePagoH.setString(2, hora);
    		deletePagoH.executeQuery();
			result= deletePagoH.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Elimina un usuario de la base de datos
	 * @param clave Nombre de usuario obtenido desde la capa de interfáz con el usuario
	 * @return 1 si se ha eliminado correctamente, -1 o 0 la eliminación ha fallado
	 */
    public int deletePagoBD(String fecha, String hora)
    {
    	int result=0;
    	try 
    	{
    		deletePago.setString(1, fecha);
    		deletePago.setString(2, hora);
    		deletePago.executeQuery();
			result= deletePago.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    
	
	/**
     * Trata de obtener todos los usuarios registrados en la base de datos
     * @return Lista con todos los usuarios registrados
     */
	public List getAllPagosEBD()
    {
    	List persons=new ArrayList();
    	Pago person;
    	try 
    	{
    		ResultSet result = selectAllE.executeQuery();
    		while(result.next())
    		{
    			person= new Pago();
   
    			person.fecha = result.getString(1);
    			person.hora = result.getString(2);
    			person.total = result.getInt(3);
    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
	
	/**
     * Trata de obtener todos los usuarios registrados en la base de datos
     * @return Lista con todos los usuarios registrados
     */
	public List getAllPagosBD()
    {
    	List persons=new ArrayList();
    	Pago person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new Pago();
   
    			person.fecha = result.getString(1);
    			person.hora = result.getString(2);
    			person.total = result.getInt(3);
    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
}
