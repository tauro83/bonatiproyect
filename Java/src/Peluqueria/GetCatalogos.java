//=======================================================================
// Fecha Creaccion: 09/11/09
// AUTOR: Camilo Verdugo
// Descripcion:  
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