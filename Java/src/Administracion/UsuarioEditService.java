package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditBD;
import AdministracionBD.UsuarioElimBD;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;

public class UsuarioEditService 
{

	/**
	 * Autor: Jimmy Muñoz
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Usuario contiene los datos de la persona que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int insertUsuarioE(Usuario person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

	public int deleteUser(String clave)
    {
		//System.out.println("Clave: "+clave);
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioElimBD userDB= new UsuarioElimBD(connection);
			
			//System.out.println("Clave: "+clave+" entra al try");
			
			result= userDB.deleteUser(clave);
			
			//System.out.println("Clave: "+clave+" despues de la consulta");
			
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * Autor: Jimmy Muñoz
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada usuario.
	 * @param
	 * @return Lista con objetos de la clase Usuario
	 */
    public List<Usuario> getAllUsuariosE()
    {
    	List<Usuario> persons=new ArrayList<Usuario>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			persons= personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
}
