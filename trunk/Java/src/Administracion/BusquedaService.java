package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import AdministracionBD.BusquedaBD;

import TransferObjects.Usuario;
import TransferObjects.Cliente;

public class BusquedaService 
{
	
	public List<Usuario> getAllUsuarios()
    {
		List<Usuario> usuarios = new ArrayList<Usuario>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BusquedaBD busquedaBD= new BusquedaBD(connection);
			usuarios= busquedaBD.getAllUsuarios();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return usuarios;
    }
	
	public List<Cliente> getAllClientes()
    {
		List<Cliente> clientes = new ArrayList<Cliente>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BusquedaBD busquedaBD= new BusquedaBD(connection);
			clientes= busquedaBD.getAllClientes();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
    }
}
