package AvisoWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin Díaz
 *
 */
public class AvisoWebServiceBD {
	
	PreparedStatement selectAll;
	PreparedStatement selectAllA;
	PreparedStatement insertreal;
	PreparedStatement publicar;
	PreparedStatement insert;
	PreparedStatement anul;
	PreparedStatement del;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public AvisoWebServiceBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "SELECT id, nombre, apaterno, telefono0, telefono, celular0, celular, asunto, descripcion "+
				"FROM avisoweb where avisoweb.estado = 0;";
			selectAll = connection.prepareStatement(query);
			
			query = "SELECT id, nombre, apaterno, telefono0, telefono, celular0, celular, asunto, descripcion "+
				"FROM avisoweb where avisoweb.estado = 1;";
			selectAllA = connection.prepareStatement(query);
			
			
			query = "INSERT INTO avisoweb (nombre,apaterno,telefono0,telefono,celular0,celular,asunto,descripcion) "+
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			query = "UPDATE avisoweb "+
			   "SET telefono0=?, telefono=?, celular=?, asunto=?, descripcion=? "+
			   "WHERE id = ?;";
			insertreal = connection.prepareStatement(query);

			query = "UPDATE avisoweb "+
			   "SET telefono0=?, telefono=?, celular=?, asunto=?, descripcion=?, estado = '0' "+
			   "WHERE id = ?;";
			publicar = connection.prepareStatement(query);

			
			query = "UPDATE avisoweb "+
			   "SET estado = 2 " +
			   "WHERE id = ?;";
			anul= connection.prepareStatement(query);
			
			query = "DELETE FROM avisoweb "+
			  	"WHERE id = ?;";
			del= connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Anula un aviso
	 * @param id id del aviso
	 * @return retorna el resultado de la operación
	 */
	public int delAvisoBD(String id)
    {
		String result = null;
		try 
    	{
			int aux = Integer.parseInt(id);
			del.setInt(1, aux);
			result=""+del.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	if(result.length()==1){
    		return 1;
    		
    	}
    	else {
    		return   0;  	
		}
    	
    }
	/**
	 * Anula un aviso
	 * @param id id del aviso
	 * @return retorna el resultado de la operación
	 */
	public int anulAvisoBD(String id)
    {
		String result = null;
		try 
    	{
			int aux = Integer.parseInt(id);
			anul.setInt(1, aux);
			result=""+anul.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	if(result.length()==1){
    		return 1;
    		
    	}
    	else {
    		return   0;  	
		}
    	
    }
	
	
	/**
	 * Actualiza un aviso en la base de datos
	 * @param person aviso que es llevado a la base de datos para reemplazar el antiguo aviso
	 * @return entero que indica si se realiza con éxito la actualización
	 */
	
	public int upAvisoWebBD(AvisoWeb person)
    {
		int result = 0;
		try 
    	{
			insertreal.setString(1, person.telefono0);
			insertreal.setString(2, person.telefono);
			insertreal.setString(3, person.celular);
			insertreal.setString(4, person.asunto);
			insertreal.setString(5, person.descripcion);
			insertreal.setInt(6, person.id);
			
			result=insertreal.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    	
    }
	public int pubAvisoWebBD(AvisoWeb person)
    {
		int result = 0;
		try 
    	{
			publicar.setString(1, person.telefono0);
			publicar.setString(2, person.telefono);
			publicar.setString(3, person.celular);
			publicar.setString(4, person.asunto);
			publicar.setString(5, person.descripcion);
			publicar.setInt(6, person.id);
			
			result=publicar.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    	
    }
	public int registrar(AvisoWeb person)
    {
		int result = 0;
		try 
    	{
			insert.setString(1, person.nombre);
			insert.setString(2, person.apaterno);
			insert.setString(3, person.telefono0);
			insert.setString(4, person.telefono);
			insert.setString(5, "0");
			insert.setString(6, person.celular);
			insert.setString(7, person.asunto);
			insert.setString(8, person.descripcion);
						
			result=insert.executeUpdate();
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
	public List getAllAvisoWebBD()
    {
    	List persons=new ArrayList();
    	AvisoWeb person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new AvisoWeb();
   
    			person.id = result.getInt(1);
    			person.nombre = result.getString(2).trim();
    			person.apaterno = result.getString(3).trim();
    			person.telefono0 = result.getString(4).trim();
    			person.telefono = result.getString(5).trim();
    			person.celular0 = result.getString(6).trim();
    			person.celular = result.getString(7).trim();
    			person.asunto = result.getString(8).trim();
    			person.descripcion = result.getString(9).trim();
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
     * Trata de obtener todos los avisos registrados en la base de datos
     * @return Lista con todos los avisos registrados
     */
	public List getAllAvisoWebABD()
    {
    	List persons=new ArrayList();
    	AvisoWeb person;
    	try 
    	{
    		ResultSet result = selectAllA.executeQuery();
    		while(result.next())
    		{
    			person= new AvisoWeb();
   
    			person.id = result.getInt(1);
    			person.nombre = result.getString(2).trim();
    			person.apaterno = result.getString(3).trim();
    			person.telefono0 = result.getString(4).trim();
    			person.telefono = result.getString(5).trim();
    			person.celular0 = result.getString(6).trim();
    			person.celular = result.getString(7).trim();
    			person.asunto = result.getString(8).trim();
    			person.descripcion = result.getString(9).trim();
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
