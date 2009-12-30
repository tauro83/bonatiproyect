package Administracion;

import java.sql.*;
import java.util.ArrayList;

import java.util.*;

import AdministracionBD.ClienteElimPurgServiceBD;
import Bd.DBConnectionManager;
import TransferObjects.Cliente;

public class ClienteElimPurgService {


	

		public int eliminarCliente(String rut, String usuario)
		{
			int result=0;
			try 
			{
				
			Connection connection=DBConnectionManager.getConnection();
			ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
			
			result= clienteElimPurgServiceBD.eliminarCliente(rut, usuario);
			
			connection.close();
		
			}catch (SQLException e) 
			{
			e.printStackTrace();
			}
			return result;
			
			//System.out.println("Clave: "+clave+" entra al try");
			
		}
		
		public int purgarCliente(String rut, String usuario)
		{
			int result=0;
			try 
			{
				
			Connection connection=DBConnectionManager.getConnection();
			ClienteElimPurgServiceBD clienteElimPurgServiceBD= new ClienteElimPurgServiceBD(connection);
			
			result= clienteElimPurgServiceBD.pugarCliente(rut, usuario);
			
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
		
		public List getClientesActivos()
	    {
	    	List clientes=new ArrayList();
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
		
		public List getClientesEliminados()
	    {
	    	List clientes=new ArrayList();
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


