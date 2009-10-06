package dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transferObjects.Cliente;
import transferObjects.Usuario;

public class BusquedaBD 
{
	PreparedStatement selectAllUsuarios;
	PreparedStatement selectAllClientes;
	
	public BusquedaBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT nombre, aPaterno, aMaterno, cargo, servicio " +
					"FROM usuario;";
			selectAllUsuarios = connection.prepareStatement(query);
			
			query = "SELECT nombre, rut, telefono2, email, apellido, apellido2 " +
					"FROM cliente;";
			selectAllClientes = connection.prepareStatement(query);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
    
    public List<Usuario> getAllUsuarios()
    {	
    	List<Usuario> usuarios = new ArrayList<Usuario>();
    	Usuario usuario;
    
    	try 
    	{
    		ResultSet result = selectAllUsuarios.executeQuery();
    		while(result.next())
    		{  
    			usuario = new Usuario();
    			
    			usuario.setNombre(result.getString(1));
    			usuario.setApellidoPaterno(result.getString(2));
    			usuario.setApellidoMaterno(result.getString(3));
    			usuario.setCargo(result.getString(4));
    			usuario.setServicio(result.getString(5));
    			
    			usuarios.add(usuario);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return usuarios;
    }List<Cliente> clientes = new ArrayList<Cliente>();
    
    public List<Cliente> getAllClientes()
    {	
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	Cliente cliente;
    
    	try 
    	{
    		ResultSet result = selectAllClientes.executeQuery();
    		while(result.next())
    		{  
    			cliente = new Cliente();
    			
    			cliente.setNombre(result.getString(1));
    			cliente.setRut(result.getString(2));
    			cliente.setTelefono2(result.getString(3));
    			cliente.setEmail(result.getString(4));
    			cliente.setApellido(result.getString(5));
    			cliente.setApellido2(result.getString(6));
    			
    			clientes.add(cliente);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return clientes;
    }
}
