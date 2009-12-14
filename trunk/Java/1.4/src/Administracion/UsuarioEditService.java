//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Jimmy Muñoz
// Comenetario: Esta Clase desarrolla la conexion entre java y flex, enviando
// y recibiendo datos.
//======================================================================

package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditBD;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;

public class UsuarioEditService 
{

	/**
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @autor Jimmy Muñoz
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

	/**
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada usuario.
	 * @autor Jimmy Muñoz
	 * @param
	 * @return Lista con objetos de la clase Usuario
	 */
    public List getAllUsuariosE()
    {
    	List persons=new ArrayList();
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
