package AdministracionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Cita;


public class AddCitaBD {

	Connection connection;
	
	public AddCitaBD(Connection connection)
	{
		this.connection = connection;
	}
	
	public String addCita(Cita c) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO Cita (rutcliente,nombremascota,fecha,hora,servicio,responsable) "+
				"VALUES (?, ?, ?, ?,?,? );";			
		insert = connection.prepareStatement(query);
		
		insert.setString(1, c.cliente.trim());
		insert.setString(2, c.mascota);
		insert.setString(3, c.fecha);
		insert.setString(4, c.hora);
		insert.setString(5, c.servicio);
		insert.setString(6, c.usuario);
		try 
    	{
			result=""+insert.executeUpdate();
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