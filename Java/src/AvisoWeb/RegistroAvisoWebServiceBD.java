
//======================================================================
// FECHA  CREACIÓN: 08/11/09
// AUTOR: Cristian Bravo
// Comentarios: Encargada de enviar y recibir datos entre la interfaz
//				y la capa lógica
//=======================================================================


package AvisoWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TransferObjects.aviWeb;
 
public class RegistroAvisoWebServiceBD {
	
	PreparedStatement selectAll;
	
	Connection connection;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @author  "Cristian Bravo"
	 * @return Rconnection Conexión obtenida con la base de datos
	 */
	
	public RegistroAvisoWebServiceBD(Connection connection)
	{
		this.connection = connection;
	}
	public String registroAvisoWebBD(aviWeb aviso)
    {
		System.out.println("LLEGO A AVISO WEB SERVICEBD");
		String result = null;	
		String query="";
		PreparedStatement insert;
		
		try 
    	{
			query = "INSERT INTO Avisoweb (id, nombre, apaterno, telefono0, telefono, celular0, celular, asunto, descripcion ) "+
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";			
	        insert = connection.prepareStatement(query);
	        
	        
	        insert.setInt(1,aviso.getId());
	        insert.setString(2, aviso.getNombre());
	        insert.setString(3, aviso.getApaterno());
	        insert.setString(4, aviso.getTelefono0());
	        insert.setString(5, aviso.getTelefono());
	        insert.setString(6, aviso.getCelular0());
	        insert.setString(7, aviso.getCelular());
	        insert.setString(8, aviso.getAsunto());
	        insert.setString(9, aviso.getDescripcion());
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
	
	/**
	 * Realiza la solicitud del Id de un aviso web
	 * @author  "Cristian Bravo"
	 * @return Resultado de la operación realizada
	 */
	
		public int getUltimo() throws SQLException
		{
			String query="";
			PreparedStatement ultimo;
			try{
			query = "SELECT Max(id) AS id "+
			"FROM avisoweb";
			ultimo = connection.prepareStatement(query);
			ResultSet res= ultimo.executeQuery();
			res.next();
			return res.getInt(1); 
			
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace(); 	
		}
			return 50;
	    	
		}
    
}