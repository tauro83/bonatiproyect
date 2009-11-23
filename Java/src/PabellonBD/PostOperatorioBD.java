//=======================================================================
// FECHA CREACIÓN: 14/10/09
// AUTOR: Erwin Díaz
// Clase que ejecuta las consultas a la base de datos
//=======================================================================

package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.PostOperatorio;

public class PostOperatorioBD {
	
	PreparedStatement selectAllPostoperatorio;
	PreparedStatement selectAllPostoperatorio2;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public PostOperatorioBD(Connection connection)
	{
		try 
		{
			String query="";

			query = "SELECT mascota.nombre, mascota.raza, mascota.sexo, " +
			"clientepresencial.nombre, clientepresencial.apaterno, clientepresencial.rut " +
			"FROM mascota, " +
			"clientepresencial WHERE clientepresencial.rut = mascota.rut;";
	
			selectAllPostoperatorio = connection.prepareStatement(query);
			
			query = "SELECT postoperatorio.idpostoperatorio, postoperatorio.medicamento, postoperatorio.alimento, " +
					"postoperatorio.observaciones, postoperatorio.hora, postoperatorio.fecha " +
					"FROM postoperatorio " +
					"WHERE postoperatorio.mascotanombre = ? and postoperatorio.clienterut = ? and postoperatorio.estado = 0;";
			
			selectAllPostoperatorio2 = connection.prepareStatement(query);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List<PostOperatorio> getAllPostOperatorio2BD(String nombreMascota, String clienterut)
	    {	
	    	List<PostOperatorio> postOperatorios = new ArrayList<PostOperatorio>();
	    	PostOperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result;
	    		
	    		selectAllPostoperatorio2.setString(1, nombreMascota);
	    		selectAllPostoperatorio2.setString(2, clienterut);
	    		
	    		result = selectAllPostoperatorio2.executeQuery();
				
	    		while(result.next())
	    		{  
	    			postOperatorio = new PostOperatorio();
	    			postOperatorio.idpostoperatorio = result.getString(1).trim();
	    			postOperatorio.medicamentos = result.getString(2).trim();
	    			postOperatorio.alimentos = result.getString(3).trim();
	    			postOperatorio.observaciones = result.getString(4).trim();
	    			postOperatorio.hora = result.getString(5).trim();
	    			postOperatorio.fecha = result.getString(6).trim();
	    			postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
	    }
	
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List<PostOperatorio> getAllPostOperatorioBD()
	    {	
	    	List<PostOperatorio> postOperatorios = new ArrayList<PostOperatorio>();
	    	PostOperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result = selectAllPostoperatorio.executeQuery();
	    		while(result.next())
	    		{  
	    			postOperatorio = new PostOperatorio();
	    			postOperatorio.nombreMascota = result.getString(1).trim();
	    			postOperatorio.raza = result.getString(2).trim();
	    			postOperatorio.sexo = result.getString(3).trim();
	    			postOperatorio.nombreCliente = result.getString(4).trim();
	    			postOperatorio.apellido = result.getString(5).trim();
	    			postOperatorio.clienterut = result.getString(6).trim();
	    			postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
	    }
	 
}
