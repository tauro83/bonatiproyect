package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Usuario;



public class UsuarioEditDB 
{
	PreparedStatement insert;
	PreparedStatement selectAll;
	Connection conn;
	
	
	public UsuarioEditDB(Connection connection)
	{
		conn = connection;
		try 
		{
			String query="";			
			/*query = "UPDATE usuario "+
			   "SET nombre=?, apaterno=?, amaterno=?, usuario=?, cargo=?, contrasena=?, "+
				       "servicio=?, pregistrar=?, peditar=?, peliminar=?, ppurgar=? "+
				 "WHERE idUsuario = ?;";*/
			query = "UPDATE usuario "+
			   "SET nombre=?, apaterno=?, amaterno=?, usuario=?, cargo=?, contrasena=?, "+
				       "servicio=?, pregistrar=?, peditar=?, peliminar=?, ppurgar=? "+
				 "WHERE usuario = ?;";
;			
			//query="SELECT Escuela FROM Usuarios WHERE User = '"+usuario+"'"
			
			insert = connection.prepareStatement(query);
			
			
			query = "SELECT nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar "+
			"FROM usuario;";
			
			/*query = "SELECT nombre, apaterno, amatrno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar" +
					"FROM usuario;";*/			
			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
		
	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int insertUsuarioE(Usuario person)
    {
    	int result=0;
    	try 
    	{
			insert.setString(1, person.getNombre());
			insert.setString(2, person.getApellidoPaterno());
			insert.setString(3, person.getApellidoMaterno());
			insert.setString(4, person.getUsuario());
			insert.setString(5, person.getCargo());
			insert.setString(6, person.getContrasena());
			insert.setString(7, person.getServicio());
			insert.setBoolean(8, person.getPermisoRegistrar());
			insert.setBoolean(9, person.getPermisoEditar());
			insert.setBoolean(10, person.getPermisoEliminar());
			insert.setBoolean(11, person.getPermisoPurgar());
			insert.setString(12, person.getUsuario());
			
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List<Usuario> getAllUsuariosE()
    {
    	List<Usuario> persons=new ArrayList<Usuario>();
    	Usuario person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new Usuario();
   
    			person.setNombre(result.getString(1));
    			person.setApellidoPaterno(result.getString(2));
    			person.setApellidoMaterno(result.getString(3));
    			person.setUsuario(result.getString(4));
    			person.setCargo(result.getString(5));
    			person.setContrasena(result.getString(6));
    			System.out.println("Cont del result: "+result.getString(6)+"Cont del person: "+person.getContrasena());
    			person.setServicio(result.getString(7));
    			person.setPermisoEditar(result.getBoolean(8));
 			    person.setPermisoRegistrar(result.getBoolean(8));
    			person.setPermisoEliminar(result.getBoolean(10));
    			person.setPermisoPurgar(result.getBoolean(11));

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
