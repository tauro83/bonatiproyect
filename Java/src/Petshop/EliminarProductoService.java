package Petshop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PetshopBD.EliminarProductoBD;
import Bd.DBConnectionManager;

import TransferObjects.Producto;

public class EliminarProductoService {


	public List<Producto> getProductosActivosTipo()
    {
    	List<Producto> productosTipo=new ArrayList<Producto>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EliminarProductoBD eliminarBD= new EliminarProductoBD(connection);
			productosTipo= eliminarBD.getProductosActivosTipo();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return productosTipo;
    }
	
	public List<Producto> getProductosInactivosTipo()
    {
    	List<Producto> productosTipo=new ArrayList<Producto>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EliminarProductoBD eliminarBD= new EliminarProductoBD(connection);
			productosTipo= eliminarBD.getProductosInactivosTipo();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return productosTipo;
    }
	
	public List<Producto> cargarProductosDetalle(Producto pro)
    {
    	List<Producto> productos=new ArrayList<Producto>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EliminarProductoBD eliminarBD= new EliminarProductoBD(connection);
			productos= eliminarBD.cargarProductosDetalle(pro);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return productos;
    }
	
	public int anularProducto(String codigo)
	{
		int result=0;
		try 
		{
			
		Connection connection=DBConnectionManager.getConnection();
		EliminarProductoBD eliminarBD= new EliminarProductoBD(connection);

		result= eliminarBD.anularProducto(codigo);
		
		connection.close();
	
		}catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return result;
		
	}
	
	public int eliminarVarios(String nombre, String precio, String categoria, String descripcion )
	 {
		int result = 0;
		
		try 
		{
			
		Connection connection=DBConnectionManager.getConnection();
		EliminarProductoBD eliminarBD= new EliminarProductoBD(connection);

		result= eliminarBD.eliminarVarios(nombre, precio, categoria, descripcion);
		
		connection.close();
	
		}catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return result;
	 }

	public int PurgarProductoTipo(String nombre, String precio, String categoria, String descripcion ){
		
		int result=0;
		try 
		{
			
		Connection connection=DBConnectionManager.getConnection();
		EliminarProductoBD eliminarBD= new EliminarProductoBD(connection);

		result= eliminarBD.PurgarProductoTipo(nombre,precio,categoria, descripcion );
		
		connection.close();
	
		}catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return result;
	}
}
