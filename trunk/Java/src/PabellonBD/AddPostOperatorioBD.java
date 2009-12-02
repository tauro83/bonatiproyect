//======================================================================
// FECHA  CREACIÓN: 08/11/09
// AUTOR: Cristian Bravo
// Comentarios: Encargada de enviar y recibir datos entre la interfaz
//				y la capa lógica
//=======================================================================


package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.PostOperatorio;
 
public class AddPostOperatorioBD {
	
	PreparedStatement selectAll;
	
	Connection connection;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @author  "Cristian Bravo"
	 * @return Rconnection Conexión obtenida con la base de datos
	 */
	
	public AddPostOperatorioBD(Connection connection)
	{
		this.connection = connection;
	}
	public String registroPostOperatorio(PostOperatorio postOpe)
    {
		System.out.println("LLEGO A postOperatorioBD");
		String result = null;	
		String query="";
		PreparedStatement insert;
		
		try 
    	{
			query = "INSERT INTO atencionpostoperatorio(medicamentos, alimentos, indicaciones, hora, fecha, costo, nombremascota, rut) "+
			"VALUES (?, ?, ?, ?,?,? ,?,?);";			
	        insert = connection.prepareStatement(query);
	        
	        
	        insert.setString(1,postOpe.getMedicamentos());
	        insert.setString(2, postOpe.getAlimentos());
	        insert.setString(3, postOpe.getIndicaciones());
	        insert.setString(4, postOpe.getHora());
	        insert.setString(5, postOpe.getSfecha());
	        insert.setString(6, postOpe.getCosto());
	        insert.setString(7, postOpe.getNombreMascota());
	        insert.setString(8, postOpe.getRut());
	        
			result=""+insert.executeQuery();
    	} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+e.toString(); 
			
		}
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
    	
    }
	
}