package PetshopBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import TransferObjects.Producto;

public class EliminarProductoBD {
	private PreparedStatement selectDistintos;
	private PreparedStatement selectDistintosInactivos;
	private PreparedStatement selectDetalle;
	private PreparedStatement Anular;
	private PreparedStatement contar;
	private PreparedStatement contarInactivos;
	private PreparedStatement Reactivar;
	private PreparedStatement EliminarVarios;
	private PreparedStatement Purgar;
	
	Connection connection;
	Connection conn;
	

	
	public  EliminarProductoBD(Connection connection)
	{
		conn = connection;
		try 
		{
		String query="";
		

		query = "SELECT  nombre,precio,categoria, descripcion, stock, codigo "+
		"FROM producto where estado=0;";
		selectDistintos = connection.prepareStatement(query);
		
		query = "SELECT DISTINCT nombre,precio,categoria, descripcion "+
		"FROM producto where estado= 1;";
		selectDistintosInactivos  = connection.prepareStatement(query);
		
		
		query = "SELECT Count(*) AS nombre "+
		"FROM producto where nombre= ? AND precio= ? AND categoria= ? AND descripcion= ? AND estado= 0;";
		
		contar= connection.prepareStatement(query);
		
		query = "SELECT Count(*) AS nombre "+
		"FROM producto where nombre= ? AND precio= ? AND categoria= ? AND descripcion= ? AND estado= 1;";
		
		contarInactivos= connection.prepareStatement(query);
		
		query = "SELECT nombre,precio,categoria,codigo, descripcion "+
		"FROM producto where nombre= ? AND precio= ? AND categoria= ? AND descripcion= ? AND estado= 0;";
		selectDetalle = connection.prepareStatement(query);
		
		
		query = "UPDATE producto "+
		   "SET estado= 1" +
		   "Where codigo =?;";
		
		Anular= connection.prepareStatement(query);
		
		
		query = "UPDATE producto " + "SET estado = 1" + 
		"where nombre= ? and precio= ? and categoria= ? and descripcion= ?";
		
		EliminarVarios = connection.prepareStatement(query);
		
		
		query = "UPDATE producto "+
		   "SET estado= 0" +
		   "Where codigo =?;";
		Reactivar = connection.prepareStatement(query);
	
		query = "DELETE FROM producto where nombre= ? and precio= ? and categoria= ? and descripcion= ?;";
		
		Purgar = connection.prepareStatement(query);
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	 public List<Producto> getProductosActivosTipo()
	    {
		 
	    	List<Producto> productos=new ArrayList<Producto>();
	    	Producto producto;
	    	try 
	    	{
	    		ResultSet result =  selectDistintos.executeQuery();
	    		while(result.next())
	    		{
	    			producto= new Producto();
	    			producto.setNombre(result.getString(1));
	    			producto.setPrecio(result.getString(2));
	    			producto.setCategoria(result.getString(3));
	    			producto.setDescripcion(result.getString(4));
	    			producto.setCantidad(result.getInt(5));
	    			producto.setCodigo(result.getString(6));
	    			
	    			productos.add(producto);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return productos;
	    }
	 
	 
	 
	 public List<Producto> getProductosInactivosTipo()
	    {

	    	List<Producto> productos=new ArrayList<Producto>();
	    	Producto producto;
	    	try 
	    	{
	    		ResultSet result =  selectDistintosInactivos.executeQuery();
	    		while(result.next())
	    		{
	    			producto= new Producto();
	    			producto.setNombre(result.getString(1));
	    			producto.setPrecio(result.getString(2));
	    			producto.setCategoria(result.getString(3));
	    			producto.setDescripcion(result.getString(4));
	    			
	    			productos.add(producto);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	
	    	//CONSULTA 2
	   	 
	   	 for(int i=0; i<productos.size(); i++){
		 try 
	    	{
			 contarInactivos.setString(1, productos.get(i).getNombre());
			 contarInactivos.setString(2, productos.get(i).getPrecio());
			 contarInactivos.setString(3, productos.get(i).getCategoria());
			 contarInactivos.setString(4, productos.get(i).getDescripcion());
		 ResultSet result2 =  contarInactivos.executeQuery();
		 while(result2.next())
		{
			 productos.get(i).setCantidad((result2.getInt(1)));
		}
	    	} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	   	 }
	    	return productos;
	    }
	 
	 public List<Producto> cargarProductosDetalle(Producto pro)
	    {
	    	List<Producto> productos=new ArrayList<Producto>();
	    	Producto producto;
	    	try 
	    	{
				 selectDetalle.setString(1, pro.getNombre());
				 selectDetalle.setString(2, pro.getPrecio());
				 selectDetalle.setString(3, pro.getCategoria());
				 selectDetalle.setString(4, pro.getDescripcion());
	    		
	    		ResultSet result =  selectDetalle.executeQuery();
	    		while(result.next())
	    		{
	    			producto= new Producto();
	    			producto.setNombre(result.getString(1));
	    			producto.setPrecio(result.getString(2));
	    			producto.setCategoria(result.getString(3));
	    			producto.setCodigo(result.getString(4));
	    			producto.setDescripcion(result.getString(5));
	    			
	    			productos.add(producto);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return productos;
	    }
	 
	 public int anularProducto(String codigo) throws SQLException
	    {
	    	int result=0;
	    	Anular.setString(1, codigo);
			Anular.executeQuery();
			result= Anular.executeUpdate();
	    	
			return result;
	    	
	    }
	 
	 public int eliminarVarios(String nombre, String precio, String categoria, String descripcion ) throws SQLException
	 {
		 int result = 0;
		 EliminarVarios.setString(1, nombre);
		 EliminarVarios.setString(2, precio);
		 EliminarVarios.setString(3, categoria);
		 EliminarVarios.setString(4, descripcion);
		 
		 EliminarVarios.executeQuery();
		 result= EliminarVarios.executeUpdate();
		 return result;
	 }

	 public int PurgarProductoTipo(String nombre, String precio, String categoria, String descripcion ) throws SQLException{
			int result=0;
	    	Purgar.setString(1, nombre);
	    	Purgar.setString(2, precio);
	    	Purgar.setString(3, categoria);
	    	Purgar.setString(4, descripcion);
			Purgar.executeQuery();
			result= Purgar.executeUpdate();
	    	
			return result;
	 }

}

