//=======================================================================
// FECHA CREACIÓN: 20/11/09
// AUTOR: Erwin Díaz
// Comentarios: Transfiere datos entre la base de datos hacia la
//				capa lógica.
//=======================================================================
package Petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Producto;
/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin Díaz
 *
 */
public class PetshopBD {
	
	PreparedStatement insert;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public PetshopBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "INSERT INTO producto(nombre, precio, categoria, codigo, descripcion) "+
			"VALUES (?, ?, ?, ?, ?);";
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
	public int regProductoBD(Producto person)
    {
		String result = null;
		try 
    	{
			insert.setString(1, person.nombre);
			insert.setString(2, person.precio);
			insert.setString(3, person.categoria);
			insert.setString(4, person.codigo);
			insert.setString(5, person.descripcion);
			
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
}
