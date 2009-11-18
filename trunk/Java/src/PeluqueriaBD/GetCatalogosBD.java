//=======================================================================
//Fecha Creaccion: 14/10/09
//AUTOR: Camilo Verdugo
//Descripcion: Clase que hace las consultas SQL y retorna una lista items del catalogo de peluqueria
//=======================================================================

package PeluqueriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import TransferObjects.CatPeluqueria;

public class GetCatalogosBD {
	
	PreparedStatement selectAll;
	Connection connection;
	ResultSet result;	
	
	/**
	 * Constructor de la clase
	 * @param connection link establecido con la BD
	 */
	public GetCatalogosBD(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * Obtiene los catalogos desde la BD
	 * @return una lista de catalogos, la cual es llamda desde la capa 2
	 */
	public ArrayList<CatPeluqueria> getCatalgosBD() throws SQLException
	{
		ArrayList<CatPeluqueria> catalogos	=	new ArrayList<CatPeluqueria>();
		CatPeluqueria cat;
 		String query						=  "select servicio,nombre,precio,descripcion,estado from catpeluqueria";
		
		selectAll = connection.prepareStatement(query);
		result = selectAll.executeQuery();
		
	   	try 
    	{
    		selectAll = connection.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
			
    		while(result.next())
    		{
    			cat = new CatPeluqueria();
    			cat.setNombre(result.getString(2));
    			cat.setServicio(result.getString(1));
    			cat.setPrecio(result.getInt(3)+"");
    			cat.setDescripcion(result.getString(4).trim());
    			catalogos.add(cat);
    		}
    	}
	   	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
	   	connection.close();
	   	return catalogos;
	}
	
	/**
	 * Obtiene los catalogos desde la BD
	 * @return una lista de catalogos, la cual es llamda desde la capa 2
	 * @param c es un catalogo el cual fue modificado.
	 */
	public void editCatalogoBD(CatPeluqueria c) throws SQLException
	{
		PreparedStatement insert;
		String query="";	
		query = "UPDATE catpeluqueria SET precio=?, descripcion=? WHERE nombre='"+ c.nombre.trim()+"' and servicio='"+c.servicio.trim()+"';";

		String pre = c.precio.trim().replace("$", "");
		pre = pre.replace(".", "");
		insert = connection.prepareStatement(query);
		insert.setInt(1, Integer.parseInt(pre));
		insert.setString(2, c.descripcion.trim());	
		
		try 
	    {		
			insert.executeUpdate();
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    connection.close();
	    	
	}
}
