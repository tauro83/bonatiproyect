//=======================================================================
// FECHA: CREACI�N: 14-10-09
// AUTOR: Esteban Cruz
// Script para purgar una cirug�a desde la base de datos, adem�s, dentro
// de esta se puede buscar el listado de todas las cirug�as existentes
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
}
