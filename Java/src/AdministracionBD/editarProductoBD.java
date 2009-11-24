package AdministracionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Hoteleria;
import TransferObjects.Producto;

public class editarProductoBD {
	PreparedStatement selectAllVacunaciones;
	PreparedStatement update;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public editarProductoBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT descripcion, precio, categoria, codigo, nombre " +
					"FROM producto;";
			
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "UPDATE producto"+
			   " SET descripcion=?, precio=?, categoria=?, nombre=?, codigo=? "+
				 "WHERE codigo=?;";
			
			update = connection.prepareStatement(query);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos del sistema, este metodo se encarga de filtrar por el nombre
	 * apelido, rut , nombre de la mascota,raza y sexo para arrojar esto datos en el primer
	 * panel.
	 * @return Lista con todos los registros de peluquería.
	 */
	 public List<Producto> getAllVacunaciones()
	    {	
		 List<Producto> vacunaciones = new ArrayList<Producto>();
		 Producto vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		
	    		while(result.next())
	    		{  
	    			
	    			vacu = new Producto();
	    			vacu.setDescripcion(result.getString(1).trim());	
	    			vacu.setPrecio(result.getString(2).trim());
	    			vacu.setCategoria(result.getString(3).trim());
	    			vacu.setCodigo(result.getString(4).trim());
	    			vacu.setNombre(result.getString(5).trim());
	    			vacunaciones.add(vacu);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	    }
	 
	    public int modificarProducto(String nombre,String descripcion,String precio,String categoria,String codigo)
	    {
	    	int result=0;
	    	try 
	    	{
	    		//Insercion de a la base de datos
				update.setString(1, descripcion);
				update.setString(2, precio);
				update.setString(3, categoria);
				update.setString(4, nombre);	
				update.setString(5, codigo);
				update.setString(6, codigo);
				
				//update.executeQuery();
					
				result= update.executeUpdate();
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return result;
	    }


}
