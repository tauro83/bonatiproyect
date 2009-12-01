package PetshopBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.Producto;

public class EliminarProductoBD {
	PreparedStatement selectActivos;
	PreparedStatement selectEliminados;
	PreparedStatement eliminar;
	PreparedStatement purgar;
	PreparedStatement reactivar;
	Connection conn;
	
	public EliminarProductoBD(Connection connection)
	{
		conn = connection;
		try 
		{
			String query="";			
			
			query = "UPDATE producto "+
			   "SET nombre=?, precio=?, categoria=?, codigo=?,"+
				       
				 "WHERE codigo = ?;";

		
				
			selectActivos = connection.prepareStatement(query);
			
			query = "SELECT nombre, precio,categoria, codigo "+
			"FROM producto where estado='FALSE';";
			
				
			selectEliminados = connection.prepareStatement(query);
			
			query = "DELETE FROM producto " +
			"WHERE codigo = ?;";
			purgar = connection.prepareStatement(query);
			
			query = "UPDATE producto "+
			   "SET estado='FALSE'" +
			   "Where codigo =?;";
			eliminar= connection.prepareStatement(query);
			
			query = "UPDATE producto "+
			   "SET estado='TRUE'" +
			   "Where rut =?;";
			reactivar= connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public int eliminarCliente( String rut) throws SQLException
    {
    	int result=0;
    	eliminar.setString(1, rut);
		eliminar.executeQuery();
		result= eliminar.executeUpdate();
    	
		return result;
    	
    }
    public int pugarCliente( String codigo) throws SQLException
    {
    	int result=0;
    	purgar.setString(1, codigo);
		purgar.executeQuery();
		result= purgar.executeUpdate();
    	
		return result;
    	
    }
    
    public int reactivarCliente( String codigo) throws SQLException
    {
    	int result=0;
    	reactivar.setString(1, codigo);
		reactivar.executeQuery();
		result= reactivar.executeUpdate();
    	
		return result;
    	
    }
    
	
}
