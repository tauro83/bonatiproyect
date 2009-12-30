//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Jimmy Muñoz
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestreo caso, almacenando los datos de los usuarios, y recuperando datos.
//======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


import TransferObjects.Usuario;



public class UsuarioEditBD 
{
	PreparedStatement insert;
	PreparedStatement selectAll;
	Connection conn;

	
	/**
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @autor  Jimmy Muñoz
	 * @param Connection, que permite conectarse con la base de datos.
	 * @return void. Solo captura algun error si es que hubiera en la base de datos.
	 */
	public UsuarioEditBD(Connection connection)
	{
		conn = connection;
		try 
		{
			String query="";			
			
			query = "UPDATE usuario "+
			   "SET nombre=?, apaterno=?, amaterno=?, usuario=?, cargo=?, contrasena=?, "+
				       "servicio=?, pregistrar=?, peditar=?, peliminar=?, ppurgar=? "+
				 "WHERE usuario = ?; " +
				 "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
			   "VALUES (?, ?, ?, ?);";
			
			insert = connection.prepareStatement(query);
			
			query = "SELECT nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar "+
			"FROM usuario where estado='TRUE';";
				
			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @autor  Jimmy Muñoz
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int insertUsuarioE(Usuario person, String usuario)
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
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			insert.setString(13, fecha);
			insert.setString(14, usuario);
			insert.setString(15, "Administración");
			insert.setString(16, "Edita el usuario: "+person.usuario+" nombre: "+person.nombre +" apellido paterno: "+ person.apellidoPaterno);			
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
	 * con los datos de cada usuario en el sistema.
	 * @autor  Jimmy Muñoz
	 * @return Una lista de objetos de la clase Usuario.
	 */
    public List getAllUsuariosE()
    {
    	List persons=new ArrayList();
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
