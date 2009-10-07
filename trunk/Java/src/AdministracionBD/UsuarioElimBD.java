//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR: Erwin Díaz 
// Comentario: Clase encargada de declarar los scripts que luego serán
// ejecutados en la base de datos
//=======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					"WHERE usuario = ?;";
			deleteUsuario = connection.prepareStatement(query);
			
			query = "SELECT nombre, apaterno, usuario, cargo, servicio, pregistrar, peditar, peliminar, ppurgar " +
					"FROM usuario;";		
			selectAll = connection.prepareStatement(query);
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
     * 
     * @return Lista con todos usuarios registrados en la base de datos
     */
    public List<UsuarioElim> getAllUsers()
    {
    	List<UsuarioElim> persons=new ArrayList<UsuarioElim>();
    	UsuarioElim person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new UsuarioElim();
    			person.setNombre(result.getString(1));
    			person.setApellido(result.getString(2));
    			person.setUsuario(result.getString(3));
    			person.setCargo(result.getString(4));
    			person.setServicio(result.getString(5));
    			person.setRegistrar(result.getBoolean(6));
    			person.setEditar(result.getBoolean(7));
    			person.setEliminar(result.getBoolean(8));
    			person.setPurgar(result.getBoolean(9));
    			
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
