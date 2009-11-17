package AvisoWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AvisoWeb.AvisoWeb;
/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin Díaz
 *
 */
public class AvisoWebServiceBD {
	
	PreparedStatement selectAll;
	PreparedStatement insert;
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
				"FROM avisoweb where estado='1';";
			selectAll = connection.prepareStatement(query);
			
			query = "UPDATE avisoweb "+
			   "SET telefono0=?, telefono=?, celular0=?, celular=?, asunto=?, descripcion=? "+
			   "WHERE id = ?;";
			insert = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	public int upAvisoWebBD(AvisoWeb person)
    {
		String result = null;
		try 
    	{
			insert.setString(1, person.telefono0);
			insert.setString(2, person.telefono);
			insert.setString(3, person.celular0);
			insert.setString(4, person.celular);
			insert.setString(5, person.asunto);
			insert.setString(6, person.descripcion);
			insert.setInt(7, person.id);
			result=""+insert.executeUpdate();
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
     * Trata de obtener todos los avisos registrados en la base de datos
     * @return Lista con todos los avisos registrados
     */
	public List<AvisoWeb> getAllAvisoWebBD()
    {
    	List<AvisoWeb> persons=new ArrayList<AvisoWeb>();
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
    
}
