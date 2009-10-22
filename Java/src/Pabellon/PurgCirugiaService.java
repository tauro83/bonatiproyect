//=======================================================================
// FECHA: CREACIÓN: 14-10-09
// AUTOR: Esteban Cruz
// Script para anular una cirugía desde la base de datos, además, dentro
// de esta se puede buscar el listado de todas las cirugías existentes
//=======================================================================

package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import PabellonBD.PurgCirugiaBD;

import TransferObjects.CirugiaPurg;;


public class PurgCirugiaService 
{
	/**
	 * Trata de obtener todos las cirugias registrados en la base de datos
	 * @return Lista con todos las cirugias registrados
	 */
	public List<CirugiaPurg> getAllCirugias()
    {
		List<CirugiaPurg> cirugias = new ArrayList<CirugiaPurg>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgCirugiaBD purgCirugiaBD= new PurgCirugiaBD(connection);
			cirugias= purgCirugiaBD.getAllCirugias();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	
	/**
	 * Trata de obtener todos las cirugias registrados en la base de datos
	 * de un cliente determinado
	 * @return Lista con todos las cirugias registrados
	 */
	public List<CirugiaPurg> getAllCirugiasU(String rut)
    {
		List<CirugiaPurg> cirugias = new ArrayList<CirugiaPurg>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgCirugiaBD purgCirugiaBD= new PurgCirugiaBD(connection);
			cirugias= purgCirugiaBD.getAllCirugiasU(rut);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
	
	/**
	 * Trata de purgar todas las cirugias solicitadas por el usuario
	 * de la base de datos
	 * @return 1 si ha purgado correctamente y 0 de lo contrario
	 */
	public int purgCirugiaU(String tipo)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgCirugiaBD purgCirugiaBD= new PurgCirugiaBD(connection);
			result=purgCirugiaBD.purgCirugiaU(tipo);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Anula todas las cirugias solicitadas por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha anulado correctamente y 0 de lo contrario
	 */
	public int setEstado(String estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgCirugiaBD purgCirugiaBD= new PurgCirugiaBD(connection);
			result=purgCirugiaBD.setEstado(estado);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
}
