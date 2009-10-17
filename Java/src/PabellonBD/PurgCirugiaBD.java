//=======================================================================
// FECHA: CREACI�N: 14-10-09
// AUTOR: Esteban Cruz
// Clase para purgar una cirug�a desde la base de datos, adem�s, dentro
// de esta se puede buscar el listado de todas las cirug�as existentes
//=======================================================================

package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.CirugiaPurg;

public class PurgCirugiaBD {
	
	PreparedStatement selectAllCirugias;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexi�n obtenida con la base de datos
	 */
	public PurgCirugiaBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT nombreCliente, apellidoPaterno, rutCliente, nombreMascota, tipo, veterinario " +
					"FROM cirugia;";
			selectAllCirugias = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
	 */
	 public List<CirugiaPurg> getAllCirugias()
	    {	
	    	List<CirugiaPurg> cirugias = new ArrayList<CirugiaPurg>();
	    	CirugiaPurg cirugia;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugias.executeQuery();
	    		while(result.next())
	    		{  
	    			cirugia = new CirugiaPurg();
	    			
	    			cirugia.setNombreCliente(result.getString(1));
	    			cirugia.setApellidoPaterno(result.getString(2));
	    			cirugia.setRutCliente(result.getString(3));
	    			cirugia.setNombreMascota(result.getString(4));
	    			cirugia.setTipo(result.getString(5));
	    			cirugia.setVeterinario(result.getString(6));
	    			
	    			cirugias.add(cirugia);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	    }
}
