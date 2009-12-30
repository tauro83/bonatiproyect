package Petshop;

import java.sql.*;
import java.util.ArrayList;

import java.util.*;

import AdministracionBD.ClienteElimPurgServiceBD;
import Bd.DBConnectionManager;
import TransferObjects.Producto;


public class EliminarProductoService {

	public int eliminarProducto(String codigo)
	{
		int result=0;
		try 
		{
			
		Connection connection=DBConnectionManager.getConnection();
		ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
		
		//result= clienteElimPurgServiceBD.eliminarCliente(codigo);
		
		connection.close();
	
		}catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return result;
		
		//System.out.println("Clave: "+clave+" entra al try");
		
	}
	
	public int purgarCliente(String rut)
	{
		int result=0;
		try 
		{
			
		Connection connection=DBConnectionManager.getConnection();
		ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
		
		//result= clienteElimPurgServiceBD.pugarCliente(rut);
		
		connection.close();
	
		}catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return result;
		
		//System.out.println("Clave: "+clave+" entra al try");
		
	}
	
	public int reactivarCliente(String rut)
	{
		int result=0;
		try 
		{
			
		Connection connection=DBConnectionManager.getConnection();
		ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
		
		result= clienteElimPurgServiceBD.reactivarCliente(rut);
		
		connection.close();
	
		}catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return result;
		
		//System.out.println("Clave: "+clave+" entra al try");
		
	}
	
	

	
	
	
}
