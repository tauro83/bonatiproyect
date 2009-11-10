//=======================================================================
// FECHA CREACIÓN: 29/10/09
// AUTOR: Erwin Díaz
// DESCRIPCION: Guarda un catálogo dentro de la base de datos
//=======================================================================

package PeluqueriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.CatPeluqueria;

/**
 * Guarda un catálogo dentro de la base de datos
 * @author Erwin Díaz
 *
 */
public class AddCatalogoBD{

	Connection connection;
	/**
	 * 
	 * @param connection Establece la conexion con la base de datos
	 */
	public AddCatalogoBD(Connection connection)
	{
		this.connection = connection;
	}
	/**
	 * 
	 * @param u de tipo CatPeluqueria encargado de recibir el objeto
	 * @return Resultado de la conexión
	 * @throws SQLException
	 */
	public String addCatalogo(CatPeluqueria u) throws SQLException
	{
		String result = null;
		int aux = 0;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO Catpeluqueria (servicio, nombre, precio, descripcion) "+
				"VALUES (?, ?, ?, ?);";			
		insert = connection.prepareStatement(query);
		
		insert.setString(1, u.servicio);		
		insert.setString(2, u.nombre);
		Integer.parseInt(u.precio, aux);
		insert.setInt(3, aux);
		insert.setString(4, u.descripcion);	
		
		try 
    	{
			System.out.println("intenta sdfsdfsd______---->");
			
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+e.toString(); 
			
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
	}
	
}
