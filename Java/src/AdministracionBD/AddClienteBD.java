//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestro caso.
//======================================================================


package AdministracionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Cliente;


public class AddClienteBD {

	Connection connection;
	
	/**
	 * Constructor de la conexion
	 * @param connection es el enlace a la BD
	 */
	
	public AddClienteBD(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * Registra el Cliente en la BD, con sus respectivos datos.
	 * @param c transferobject Cliente
	 */
	public String addCliente(Cliente c) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO clientepresencial (nombre,aPaterno,aMaterno,rut,telefono,celular,domicilio,region,comuna,correo,estado) "+
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";			
		insert = connection.prepareStatement(query);
		
		insert.setString(1, c.nombre);
		insert.setString(2, c.apellido);
		insert.setString(3, c.apellido2);
		insert.setString(4, c.rut+c.rut2);	
		insert.setInt(5, Integer.parseInt(c.telefono+c.telefono2));		
		insert.setInt(6, Integer.parseInt(c.celular+c.celular2));
		insert.setString(7,c.direccion);
		insert.setString(8,c.region);	
		insert.setString(9,c.comuna);
		insert.setString(10,c.email);
		insert.setBoolean(11,c.estado);
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
    	
    	if(result.length()>1){
    		return "2";
    	}
    	
    	else {
    		return   "0";  	
		}
	}
	
}

