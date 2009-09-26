package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Usuario;


public class AddUsuarioBD {

	Connection connection;
	
	public AddUsuarioBD(Connection connection)
	{
		this.connection = connection;
	}
	
	public String addUsuario(Usuario u) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar) "+
				"VALUES (?, ?, ?, ?,?,? ,?,?,? ,?,?);";			
		insert = connection.prepareStatement(query);
		
		insert.setString(1, u.nombre);
		insert.setString(2, u.apellidoMaterno);
		insert.setString(3, u.apellidoMaterno);
		insert.setString(4, u.usuario);
		insert.setString(5, u.cargo);
		insert.setString(6, u.contrasena);
		insert.setString(7, u.servicio);		
		insert.setBoolean(8, u.permisoRegistrar);
		insert.setBoolean(9, u.permisoEditar);
		insert.setBoolean(10, u.permisoEliminar);
		insert.setBoolean(11, u.permisoPurgar);		
		
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
