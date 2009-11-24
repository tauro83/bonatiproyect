//=======================================================================
// FECHA CREACI�N: 14/10/09
// AUTOR: Erwin D�az
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
	PreparedStatement elimReg;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexi�n obtenida con la base de datos
	 */
	public PostOperatorioBD(Connection connection)
	{
		try 
		{
			String query="";

			query = "SELECT mascota.nombre, mascota.raza, mascota.sexo, " +
			"clientepresencial.nombre, clientepresencial.apaterno, clientepresencial.rut " +
			"FROM mascota, clientepresencial, atencionpostoperatorio " +
			"WHERE clientepresencial.rut = atencionpostoperatorio.rut and " +
			"mascota.rut = atencionpostoperatorio.rut and mascota.nombre = atencionpostoperatorio.nombremascota;";
	
			selectAllPostoperatorio = connection.prepareStatement(query);
			
			query = "SELECT atencionpostoperatorio.medicamentos, atencionpostoperatorio.alimentos, " +
					"atencionpostoperatorio.indicaciones, atencionpostoperatorio.hora, atencionpostoperatorio.fecha " +
					"FROM atencionpostoperatorio " +
					"WHERE atencionpostoperatorio.nombremascota = ? and atencionpostoperatorio.rut = ? and atencionpostoperatorio.estado = 0;";
			
			selectAllPostoperatorio2 = connection.prepareStatement(query);
			
			query = "UPDATE atencionpostoperatorio "+
			   "SET estado = '1' " +
			   "WHERE atencionpostoperatorio.hora = ? and " +
			   "atencionpostoperatorio.rut = ? and atencionpostoperatorio.nombremascota = ?;";
			elimReg = connection.prepareStatement(query);
		
			
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
	public int elimAtencionBD(String hora, String rut, String nomMascota)
    {
    	int result=0;
    	try 
    	{
    		elimReg.setString(1, hora);
    		elimReg.setString(2, rut);
    		elimReg.setString(3, nomMascota);
    		elimReg.executeQuery();
    		result= elimReg.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
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
	    			postOperatorio.medicamentos = result.getString(1).trim();
	    			postOperatorio.alimentos = result.getString(2).trim();
	    			postOperatorio.observaciones = result.getString(3).trim();
	    			postOperatorio.shora = result.getString(4).trim();
	    			postOperatorio.stfecha = result.getString(5).trim();
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
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
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