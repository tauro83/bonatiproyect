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
	PreparedStatement selectAllElim;
	PreparedStatement selectAllPostoperatorio2;
	PreparedStatement selectAllPostNull;
	PreparedStatement selectAllActivo;
	PreparedStatement elimReg;
	PreparedStatement anulReg;
	PreparedStatement insert;
	
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public PostOperatorioBD(Connection connection)
	{
		try 
		{
			String query="";

			query = "SELEC * " +
					"FROM atencionpostoperatorio " +
					"WHERE estado=0";
			selectAllActivo = connection.prepareStatement(query);
			
			query = "SELECT mascota.nombre, mascota.raza, mascota.sexo, " +
			"clientepresencial.nombre, clientepresencial.apaterno, clientepresencial.rut " +
			"FROM mascota, clientepresencial, atencionpostoperatorio " +
			"WHERE clientepresencial.rut = atencionpostoperatorio.rut and " +
			"mascota.rut = atencionpostoperatorio.rut and mascota.nombre = atencionpostoperatorio.nombremascota and " +
			"atencionpostoperatorio.estado = '1';";
	
			selectAllElim = connection.prepareStatement(query);
			
			query = "SELECT mascota.nombre, mascota.raza, mascota.sexo, " +
			"clientepresencial.nombre, clientepresencial.apaterno, clientepresencial.rut " +
			"FROM mascota, clientepresencial, atencionpostoperatorio " +
			"WHERE clientepresencial.rut = atencionpostoperatorio.rut and " +
			"mascota.rut = atencionpostoperatorio.rut and mascota.nombre = atencionpostoperatorio.nombremascota and " +
			"atencionpostoperatorio.estado = '0';";
			
			selectAllPostoperatorio = connection.prepareStatement(query);
			
			query = "SELECT atencionpostoperatorio.indicaciones, atencionpostoperatorio.hora, atencionpostoperatorio.fecha " +
					"FROM atencionpostoperatorio " +
					"WHERE atencionpostoperatorio.nombremascota = ? and atencionpostoperatorio.rut = ? and atencionpostoperatorio.estado = 0;";
			
			selectAllPostoperatorio2 = connection.prepareStatement(query);
			
			query = "SELECT atencionpostoperatorio.indicaciones, atencionpostoperatorio.hora, atencionpostoperatorio.fecha " +
			"FROM atencionpostoperatorio " +
			"WHERE atencionpostoperatorio.nombremascota = ? and atencionpostoperatorio.rut = ? and atencionpostoperatorio.estado = 1;";
	
			selectAllPostNull = connection.prepareStatement(query);
			
			query = "UPDATE atencionpostoperatorio "+
			   "SET estado = '1' " +
			   "WHERE atencionpostoperatorio.hora = ? and " +
			   "atencionpostoperatorio.rut = ? and atencionpostoperatorio.nombremascota = ?;";
			elimReg = connection.prepareStatement(query);
			
			query = "UPDATE atencionpostoperatorio "+
			   "SET estado = '2' " +
			   "WHERE atencionpostoperatorio.hora = ? and " +
			   "atencionpostoperatorio.rut = ? and atencionpostoperatorio.nombremascota = ?;";
			anulReg = connection.prepareStatement(query);
		
			query = "INSERT INTO atencionpostoperatorio(hora, fecha, nombremascota, rut, costo, indicaciones) "+
			   "VALUES(?, ?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public List getAllPostOperatorioActivoBD(){
		ResultSet result;
		List postOperatorios = new ArrayList();
    	PostOperatorio postOperatorio;
		try{
			result =selectAllActivo.executeQuery();
			while(result.next()){  
    			postOperatorio = new PostOperatorio();
    			postOperatorio.medicamentos = result.getString(1).trim();
    			postOperatorio.alimentos = result.getString(2).trim();
    			postOperatorio.indicaciones = result.getString(3).trim();
    			//result.getString(4) corresponde al atrib servicio
    			postOperatorio.shora = result.getString(5).trim();
    			postOperatorio.stfecha = result.getString(6).trim();
    			postOperatorio.costo = result.getString(7).trim();
    			postOperatorio.nombreMascota = result.getString(8).trim();
    			postOperatorio.clienterut = result.getString(9).trim();
    			postOperatorio.apellido = result.getString(10).trim();
    			postOperatorio.nombreCliente = result.getString(11).trim();    			
    			postOperatorios.add(postOperatorio);
    			
    		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return postOperatorios;
	}
	public int AddPostOpeBD(PostOperatorio pos){
		String result = null;
		try 
    	{
			insert.setString(1, pos.shora);
			insert.setString(2, pos.stfecha);
			insert.setString(3, pos.nombreMascota);
			insert.setString(4, pos.clienterut);
			insert.setString(5, pos.costo);
			insert.setString(6, pos.indicaciones);
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	if(result.length()==1){
    		return 1;
    		
    	}
    	else {
    		return   0;  	
		}
    	
    }
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	public int anulAtencionBD(String hora, String rut, String nomMascota){
    	int result=0;
    	try{
    		anulReg.setString(1, hora);
    		anulReg.setString(2, rut);
    		anulReg.setString(3, nomMascota);
    		anulReg.executeQuery();
    		result= anulReg.executeUpdate();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return result;
    }
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List getAllPostNullBD(String nombreMascota, String clienterut)
	    {	
	    	List postOperatorios = new ArrayList();
	    	PostOperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result;
	    		
	    		selectAllPostNull.setString(1, nombreMascota);
	    		selectAllPostNull.setString(2, clienterut);
	    		
	    		result = selectAllPostNull.executeQuery();
				
	    		while(result.next())
	    		{  
	    			postOperatorio = new PostOperatorio();
	    			postOperatorio.indicaciones = result.getString(1).trim();
	    			postOperatorio.shora = result.getString(2).trim();
	    			postOperatorio.stfecha = result.getString(3).trim();
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
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List  getAllPostOperatorio2BD(String nombreMascota, String clienterut)
	    {	
	    	List postOperatorios = new ArrayList ();
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
	    			postOperatorio.indicaciones = result.getString(1).trim();
	    			postOperatorio.shora = result.getString(2).trim();
	    			postOperatorio.stfecha = result.getString(3).trim();
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
		 public List  getAllPostOperatorioAnulBD()
		    {	
		    	List  postOperatorios = new ArrayList();
		    	PostOperatorio postOperatorio;
		    	try 
		    	{
		    		ResultSet result = selectAllElim.executeQuery();
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
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List getAllPostOperatorioBD()
	    {	
	    	List postOperatorios = new ArrayList();
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
