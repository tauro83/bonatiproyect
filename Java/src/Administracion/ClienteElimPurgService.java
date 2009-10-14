package Administracion;

import java.sql.*;
import java.util.ArrayList;



import flex.messaging.io.*;
import java.util.*;

import AdministracionBD.ClienteElimPurgServiceBD;
import Bd.DBConnectionManager;
import TransferObjects.Cliente;

public class ClienteElimPurgService {


	

		public int eliminarCliente(String rut)
		{
			int result=0;
			try 
			{
				
			Connection connection=DBConnectionManager.getConnection();
			ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
			
			result= clienteElimPurgServiceBD.eliminarCliente(rut);
			
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
			
			result= clienteElimPurgServiceBD.pugarCliente(rut);
			
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
		
		public List<Cliente> getClientesActivos()
	    {
	    	List<Cliente> clientes=new ArrayList<Cliente>();
	    	try 
			{
				Connection connection=DBConnectionManager.getConnection();
				ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
				clientes= clienteElimPurgServiceBD.getClientesActivosE();		
				connection.close();
			} 
	    	catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return clientes;
	    }
		
		public List<Cliente> getClientesEliminados()
	    {
	    	List<Cliente> clientes=new ArrayList<Cliente>();
	    	try 
			{
				Connection connection=DBConnectionManager.getConnection();
				ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
				clientes= clienteElimPurgServiceBD.getClientesEliminados();		
				connection.close();
			} 
	    	catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return clientes;
	    }
		
	}


