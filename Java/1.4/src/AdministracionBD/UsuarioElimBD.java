//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR: Erwin Díaz 
// Clase encargada de declarar los scripts que luego serán
// ejecutados en la base de datos
//=======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


import TransferObjects.UsuarioElim;


/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin Díaz
 *
 */
public class UsuarioElimBD 
{
	PreparedStatement insert;
	PreparedStatement selectAll;
	PreparedStatement deleteUsuario;
	PreparedStatement eliminar;
	PreparedStatement selectAllPurg;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public UsuarioElimBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "INSERT INTO persons(rut, name, lastname) "+
					"VALUES (?, ?, ?);";			
			insert = connection.prepareStatement(query);
			
			query = "DELETE FROM usuario " +
			"WHERE usuario = ?; " +
			"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
			"VALUES (?, ?, ?, ?);";
			
			deleteUsuario = connection.prepareStatement(query);

			query = "SELECT nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar "+
				"FROM usuario where estado='FALSE';";
			selectAllPurg = connection.prepareStatement(query);

			query = "SELECT nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar "+
				"FROM usuario where estado='TRUE';";
			selectAll = connection.prepareStatement(query);
			
			query = "UPDATE usuario "+
			   "SET estado = 'FALSE' " +
			   "WHERE usuario = ?; " +
			   "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
			   "VALUES (?, ?, ?, ?);";
			eliminar= connection.prepareStatement(query);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Elimina un usuario de la base de datos
	 * @param clave Nombre de usuario obtenido desde la capa de interfáz con el usuario
	 * @return 1 si se ha eliminado correctamente, -1 o 0 la eliminación ha fallado
	 */
    public int deleteUser(String clave)
    {
    	int result=0;
    	try 
    	{
    		deleteUsuario.setString(1, clave);
    		Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
    		
    		deleteUsuario.setString(2, fecha);
    		deleteUsuario.setString(3, "usuario");
    		deleteUsuario.setString(4, "Administración");
    		deleteUsuario.setString(5, "Purga el usuario: "+clave);
			
			deleteUsuario.executeQuery();
			result= deleteUsuario.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    
    /**
     * Trata de obtener todos los usuarios registrados en la base de datos
     * @return Lista con todos los usuarios registrados
     */
	public List getAllUsuariosP()
    {
    	List persons=new ArrayList();
    	UsuarioElim person;
    	try 
    	{
    		ResultSet result = selectAllPurg.executeQuery();
    		while(result.next())
    		{
    			person= new UsuarioElim();
   
    			person.setNombre(result.getString(1));
    			person.setApellidoPaterno(result.getString(2));
    			person.setApellidoMaterno(result.getString(3));
    			person.setUsuario(result.getString(4));
    			person.setCargo(result.getString(5));
    			person.setContrasena(result.getString(6));
    			person.setServicio(result.getString(7));
    			person.setEditar(result.getBoolean(8));
 			    person.setRegistrar(result.getBoolean(8));
    			person.setEliminar(result.getBoolean(10));
    			person.setPurgar(result.getBoolean(11));
    			person.convetParam();
    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
    
	/**
	 * Funcion que permite ocultar un usuario
	 * @param clave es el nombre de usuario
	 * con este parámetro se hace la selección de
	 * una tupla en la base de datos
	 * @return retorna el estado de la conexion
	 */
    public int hideUser(String clave)
    {
    	int result=0;
    	try 
    	{

    		eliminar.setString(1, clave);
    		
    		Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
    		eliminar.setString(2, fecha);
    		eliminar.setString(3, "usuario");
    		eliminar.setString(4, "Administración");
    		eliminar.setString(5, "Elimina el usuario: "+clave);
			
    		eliminar.executeQuery();
    		result= eliminar.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    /**
     * 
     * @return Lista con todos usuarios registrados en la base de datos
     */
    public List getAllUsuariosE()
    {
    	List persons=new ArrayList();
    	UsuarioElim person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new UsuarioElim();
   
    			person.setNombre(result.getString(1));
    			person.setApellidoPaterno(result.getString(2));
    			person.setApellidoMaterno(result.getString(3));
    			person.setUsuario(result.getString(4));
    			person.setCargo(result.getString(5));
    			person.setContrasena(result.getString(6));
    			person.setServicio(result.getString(7));
    			person.setEditar(result.getBoolean(8));
 			    person.setRegistrar(result.getBoolean(8));
    			person.setEliminar(result.getBoolean(10));
    			person.setPurgar(result.getBoolean(11));
    			person.convetParam();
    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
}
