//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestreo caso.
//======================================================================


package AdministracionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Cliente;



public class AddClienteBD {

	Connection connection;
	
	public AddClienteBD(Connection connection)
	{
		this.connection = connection;
	}
	
	public String addCliente(Cliente c) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO Cliente (nombre,apellido,apellido2,rut,telefono,telefono2,celular,celular2,direccion,region,comuna,email,email2) "+
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";			
		insert = connection.prepareStatement(query);
		
		insert.setString(1, c.nombre);
		insert.setString(2, c.apellido);
		insert.setString(3, c.apellido2);
		insert.setString(4, c.rut+c.rut2);	
		insert.setString(5, c.telefono);
		insert.setString(6, c.telefono2);		
		insert.setString(7, c.celular);
		insert.setString(8, c.celular2);
		insert.setString(9,c.direccion);
		insert.setString(10,c.region);	
		insert.setString(11,c.comuna);
		insert.setString(12,c.email);
		insert.setString(13,c.email2);
		//insert.setString(14,c.rut2);
		
		
		try 
    	{
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+ e.toString(); 
			
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
	}
	
}

