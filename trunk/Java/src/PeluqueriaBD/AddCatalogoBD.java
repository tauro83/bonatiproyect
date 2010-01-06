//=======================================================================
// FECHA CREACI�N: 29/10/09
// AUTOR: Erwin D�az
// DESCRIPCION: Guarda un cat�logo dentro de la base de datos
//=======================================================================

package PeluqueriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import TransferObjects.CatPeluqueria;

/**
 * Guarda un cat�logo dentro de la base de datos
 * @author Erwin D�az
 *
 */
public class AddCatalogoBD{
	
	PreparedStatement insert;
	/**
	 * 
	 * @param connection Establece la conexion con la base de datos
	 */
	public AddCatalogoBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "INSERT INTO catpeluqueria (servicio, nombre, precio, descripcion) "+
			"VALUES (?, ?, ?, ?);";			
			insert = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param u de tipo CatPeluqueria encargado de recibir el objeto
	 * @return Resultado de la conexi�n
	 * @throws SQLException
	 */
	public String regCatalogo(CatPeluqueria person)
    {
		String result = null;
		try 
    	{
			insert.setString(1, person.servicio.trim());
			insert.setString(2, person.nombre.trim());
			int aux = Integer.parseInt(person.precio);
			insert.setInt(3, aux);
			insert.setString(4, person.descripcion.trim());
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
    	
    }
}
