package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import transferObjects.Usuario;



public class MantenerUsuario {

	Connection connection;
	
	public MantenerUsuario(Connection connection)
	{
		this.connection = connection;
	}

	public String addUsuario(Usuario u) throws SQLException{
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
		insert.setString(6, u.constrasena);
		insert.setString(7, u.servicio);		
		insert.setBoolean(8, u.permisoRegistrar);
		insert.setBoolean(9, u.permisoEditar);
		insert.setBoolean(10, u.permisoEliminar);
		insert.setBoolean(11, u.permisoPurgar);
		
		
		try{
			result = "Resultado: "+insert.executeUpdate()+" ";
		} 
    	catch (SQLException e){    	
			e.printStackTrace();
			result = result +" "+e.toString();			
		}
		
		return result;
	}
	
	public void setUsuario(Usuario u)
	{
	}
        
	
	public void purgUsuario(String nombre)
	{
	}
	
	
	public String getUsuarios() throws SQLException{
		PreparedStatement serviciosResult = null;
		try 
		{			
			serviciosResult = connection.prepareStatement("SELECT * FROM Usuario;");
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
