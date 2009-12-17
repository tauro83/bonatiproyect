//=======================================================================
// FECHA: CREACIÓN: 10-11-09
// AUTOR: Esteban Cruz
// Script para anular o eliminar un catálogo desde la base de datos, además,
// dentro de esta se puede buscar el listado de todos los catálogos existentes
//=======================================================================

package PeluqueriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.CatPeluqueria;

public class AECatPeluqueriaBD {
	
	PreparedStatement selectAllCatalogos;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 * @author "Esteban Cruz"
	 */
	public AECatPeluqueriaBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT nombre, servicio, precio, descripcion, estado " +
					"FROM catpeluqueria " +
					"WHERE estado = 0;";
			selectAllCatalogos = connection.prepareStatement(query);
			
			query = "UPDATE catpeluqueria " +
					"SET estado = ? " + 
					"WHERE nombre = ? AND servicio = ?;";
			setEstado = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Trata de obtener todos los catalogos registrados en la base de datos
	 * @return Lista con todos los catalogos registrados
	 * @author "Esteban Cruz"
	 */
	 public List getAllCatalogos()
	    {	
	    	List catalogos = new ArrayList();
	    	CatPeluqueria cata;
	    	try 
	    	{
	    		ResultSet result = selectAllCatalogos.executeQuery();
	    		while(result.next())
	    		{  
	    			cata = new CatPeluqueria();
	    			
	    			cata.setNombre(result.getString(1).trim());
	    			cata.setServicio(result.getString(2).trim());
	    			cata.setPrecio(result.getString(3).trim());
	    			cata.setDescripcion(result.getString(4).trim());
	    				
	    			catalogos.add(cata);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return catalogos;
	    }
	 
	 /**
	  * Anula todos los catalogos solicitados por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha anulado correctamente y 0 de lo contrario
	  * @author "Esteban Cruz"
	  */
	 public int anular(CatPeluqueria cata)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 2);
			setEstado.setString(2, cata.getNombre());
			setEstado.setString(3, cata.getServicio());
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 /**
	  * Elimina todos los catalogos solicitados por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha elimina correctamente y 0 de lo contrario
	  * @author "Esteban Cruz"
	  */
	 public int eliminar(CatPeluqueria cata)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 1);
			setEstado.setString(2, cata.getNombre());
			setEstado.setString(3, cata.getServicio());
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
}
