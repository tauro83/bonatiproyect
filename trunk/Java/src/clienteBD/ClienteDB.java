//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestreo caso.
//======================================================================


package clienteBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transferObjects.ClienteTO;;

public class ClienteDB {

     Connection connection;
	
     /**
     * Este metodo se encarga de realizar la conexion con la base de datos, 
     * para poder ingresar los datos del cliente.  
     * 
     * @langversion ActionScript 3.0
     *

     */		
	public ClienteDB(Connection connection)
	{
		this.connection = connection;
	}
	
	/*public String addCliente(String nombre,String apellido,String apellido2,String rut,String rut2, String telefono,String telefono2,String celular,String celular2,String direccion,String region,String comuna,String email,String email2) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";	
		
		query = "INSERT INTO Cliente(nombre, apellido, apellido2, rut, rut2, telefono, telefono2, celular, celular2, direccion, region, comuna, email, email2)"+
		" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";	
		
         insert = connection.prepareStatement(query);
		
		insert.setString(1, nombre);
		insert.setString(2, apellido);
		insert.setString(3, apellido2);
		insert.setString(4, rut);
		insert.setString(5, rut2);
		insert.setString(6, telefono);
		insert.setString(7, telefono2);		
		insert.setString(8, celular);
		insert.setString(9, celular2);
		insert.setString(10, direccion);
		insert.setString(11, region);
		insert.setString(12, comuna);
		insert.setString(13, email);
		insert.setString(14, email2);
		
		try 
    	{
			result = "Resultado: "+insert.executeUpdate()+" ";
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = result +" "+e.toString(); 
			
		}
		
		return result;
	}*/
	
    /**
     * Este metodo mapea el objeto cliente y se lo envia a la base de datos 
     * con cada uno de los datos ingresados por el cliente y los agrega a la 
     * base de datos.
     * 
     * @langversion ActionScript 3.0
     *

     */			
	
	public String addCliente(ClienteTO client) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";	
		
		query = "INSERT INTO cliente(nombre, apellido, apellido2, rut, rut2, telefono, telefono2, celular, celular2, direccion, region, comuna, email, email2) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";	
		
         insert = connection.prepareStatement(query);
		
		insert.setString(1, client.nombre);
		insert.setString(2, client.apellido);
		insert.setString(3, client.apellido2);
		insert.setString(4, client.rut);
		insert.setString(5, client.rut2);
		insert.setString(6, client.telefono);
		insert.setString(7, client.telefono2);		
		insert.setString(8, client.celular);
		insert.setString(9, client.celular2);
		insert.setString(10, client.direccion);
		insert.setString(11, client.region);
		insert.setString(12, client.comuna);
		insert.setString(13, client.email);
		insert.setString(14, client.email2);
		
		try 
    	{
			result = "Resultado: "+insert.executeUpdate()+" ";
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = result +" "+e.toString(); 
			
		}
		
		return result;
	}
	
	public String getCliente() throws SQLException{
		PreparedStatement serviciosResult = null;
		try 
		{			
			serviciosResult = connection.prepareStatement("SELECT * FROM Cliente;");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		String out="";
		ResultSet result = serviciosResult.executeQuery();
		
		while(result.next())
		{
			out = out + ""+ result.getString(1)+"-";
				
		}
		return out;
	}
	
	
}
