//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR: Erwin Díaz 
// Clase encargada de realizar todas las conexiones para
// para eliminar o purgar un usuario de la base de datos
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.UsuarioElim;
import AdministracionBD.UsuarioElimBD;
import Bd.DBConnectionManager;

/**
 * Clase encargada de realizar todas las conexiones para
   para eliminar o purgar un usuario de la base de datos
 * @author Erwin Díaz
 *
 */
public class UsuarioElimService 
{
	/**
	 * 
	 * @param clave cadena que representa el nombre de usuario para ser
	   comparado con otro existene en la base de datos, si coincide entonces
	   esa fila es eliminada
	 * @return Resultado de la operación, si es > 0 se realizó con éxito, no se realizó
	   la operación en caso contrario
	 */
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
			Connection connection=DBConnectionManager.getConnection();
			UsuarioElimBD userDB= new UsuarioElimBD(connection);
			result= userDB.hideUser(clave);
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * Funcion que inserta objetos del tipo usuarioElim en un array
	 * para enviarlo a la capa 1
	 * @return
	 */
	public List getAllUsuariosP()
    {
    	List persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioElimBD personDB= new UsuarioElimBD(connection);
			persons= personDB.getAllUsuariosP();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	
	
	/**
	 * Trata de obtener todos los usuarios registrados en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public List getAllUsuariosE()
    {
    	List persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioElimBD personDB= new UsuarioElimBD(connection);
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
