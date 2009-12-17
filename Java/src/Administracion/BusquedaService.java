//=======================================================================
// FECHA CREACIÓN: 06/10/09
// AUTOR: Esteban Cruz
// Clase de busqueda del sistema, dentro de esta se pueden realizar 
// busquedas para: Mascota, Cliente, Atencion, Producto, Aviso, Usuario
// Obtiene los datos desde la BD
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import AdministracionBD.BusquedaBD;

import TransferObjects.Mascota;
import TransferObjects.Usuario;
import TransferObjects.Cliente;
import TransferObjects.Atencion;
import TransferObjects.Producto;

public class BusquedaService 
{
	/**
	 *  Trata de obtener todos los usuarios registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos los usuarios registrados
	 **/
	public List getAllUsuarios()
    {
		List usuarios = new ArrayList();
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
	
	/**
	 *  Trata de obtener todos los clientes registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos los clientes registrados
	 **/
	public List getAllClientes()
    {
		List clientes = new ArrayList();
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
	
	/**
	 *  Trata de obtener todos las mascotas registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos las mascotas registrados
	 **/
	public List getAllMascotas()
    {	
    	List mascotas = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BusquedaBD busquedaBD= new BusquedaBD(connection);
			mascotas= busquedaBD.getAllMascotas();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return mascotas;
    }
	
	/**
	 *  Trata de obtener todos las atenciones registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos las atenciones registrados
	 **/
	public List getAllAtenciones()
    {	
    	List atenciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BusquedaBD busquedaBD= new BusquedaBD(connection);
			atenciones= busquedaBD.getAllAtenciones();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return atenciones;
    }
	
	/**
	 *  Trata de obtener todos los productos registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos los productos registrados
	 **/
	public List getAllProductos()
    {	
    	List productos = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BusquedaBD busquedaBD= new BusquedaBD(connection);
			productos= busquedaBD.getAllProductos();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return productos;
    }
}
