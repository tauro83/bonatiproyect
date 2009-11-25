//=======================================================================
// FECHA CREACIÓN: 24-11-09
// AUTOR: Esteban Cruz
// Clase encargada de consultar a la base de datos y llamar a la  
// funcion para editar los datos solicitados por el usuario
// en la base de datos. Para ello se consta de 2 funciones 
// principalmente, una que lista los productos y otra que modifica
// los valores del registro
//=======================================================================

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
	 * @author Esteban Cruz
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
		/**
		* Captura el error
		*/
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Este metodo obteniene todos los registros de producto que se encuentran
	 * en la base de datos del sistema
	 * @return Lista con todos los registros de productos
	 * @author Esteban Cruz
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
			/**
			* Captura el error
			*/
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	    }
	 
		/**
		* Trata de modificar los datos solicitados por el usuario en la base de datos
		* @return 1 si se realiza correctamente, 0 en caso contrario
		* @author Esteban Cruz
		*/
	    public int modificarProducto(String nombre,String descripcion,String precio,String categoria,String codigo)
	    {
	    	int result=0;
			/**
			* Trata de cambiar los valores dados por el usuario
			*/
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
			/**
			* Captura el error
			*/
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return result;
	    }


}
