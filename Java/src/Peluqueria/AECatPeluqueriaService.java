//=======================================================================
// FECHA: CREACI�N: 10-11-09
// AUTOR: Esteban Cruz
// Script para anular o eliminar un cat�logo desde la base de datos, adem�s,
// dentro de esta se puede buscar el listado de todos los cat�logos existentes
//=======================================================================

package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import PeluqueriaBD.AECatPeluqueriaBD;

import TransferObjects.CatPeluqueria;


public class AECatPeluqueriaService 
{
	/**
	 * Trata de obtener todos los cat�logos registrados en la base de datos
	 * @return Lista con todos los cat�logos registrados
	 * @author "Esteban Cruz"
	 */
	public List getAllCatalogos()
    {
		List catalogos = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AECatPeluqueriaBD catPeluqueraBD= new AECatPeluqueriaBD(connection);
			catalogos = catPeluqueraBD.getAllCatalogos();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogos;
    }
	
	/**
	 * Anula todos los cat�logos solicitados por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha anulado correctamente y 0 de lo contrario
	 * @author "Esteban Cruz"
	 */
	public int anular(CatPeluqueria cata)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AECatPeluqueriaBD catPeluqueraBD= new AECatPeluqueriaBD(connection);
			result = catPeluqueraBD.anular(cata);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Elimina todos los cat�logos solicitados por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha eliminado correctamente y 0 de lo contrario
	 * @author "Esteban Cruz"
	 */
	public int eliminar(CatPeluqueria cata)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AECatPeluqueriaBD catPeluqueraBD= new AECatPeluqueriaBD(connection);
			result = catPeluqueraBD.eliminar(cata);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
}
