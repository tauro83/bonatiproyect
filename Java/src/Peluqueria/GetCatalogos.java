//=======================================================================
// Fecha Creaccion: 09/11/09
// AUTOR: Camilo Verdugo
// Descripcion:  Clase que es llamada desde la capa de flex y obtiene 
// los catalogos y envia el catalogo editado
//=======================================================================

package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Bd.DBConnectionManager;
import PeluqueriaBD.GetCatalogosBD;
import TransferObjects.CatPeluqueria;

public class GetCatalogos {
	
	static Connection connection;
	
	/**
	 * Este metodo obtiene los catalogos desde la base de datos.
	 * @return una lista de catalogos, la cual sera mostrada en un datagrid en flex 
	 */
	public static ArrayList<CatPeluqueria> getCatalogos()
	{
		ArrayList<CatPeluqueria> catalogos =new ArrayList<CatPeluqueria>();
    	try 
		{
    		connection=DBConnectionManager.getConnection();
    		GetCatalogosBD gcat= new GetCatalogosBD(connection);
    		catalogos	= gcat.getCatalgosBD();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogos;
	}
	
	/**
	 * Metodo que se comunica con la capa 3 y envia un nuevo catalogo
	 * @param c es un objeto catalogo peluqueria, ya editado, el cual es enviado a la capa 3
	 */
	public static void editCatalogo(CatPeluqueria c)
	{
		try 
		{
			connection=DBConnectionManager.getConnection();
			GetCatalogosBD gcat= new GetCatalogosBD(connection);
			gcat.editCatalogoBD(c);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}