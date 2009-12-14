//=======================================================================
// FECHA CREACIÓN: 10 de Septiembre de 2009
// AUTOR: Sebastian Arancibia
// …. Clase para la comunicacion entre flex y java 
//=======================================================================

package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import AdministracionBD.UsuarioEditDB;
import Agenda.Bitacora;
import Bd.DBConnectionManager;

public class BitacoraService 
{
	/**
	 * Clase utilizada para la comunicacion entre capa 1 y 2 (Flex y Java)
	 *
	 * @author  Sebastian Arancibia
	 * @version 0.1, 22/09/09
	 * @return result resultado de la operacion 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int insertUsuarioE(Bitacora bitacora)
    {
		int result=0;
		try {
			Connection connection=DBConnectionManager.getConnection();
			//UsuarioEditDB personDB= new UsuarioEditDB(connection);
			//result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

	/**
	 * Crea la conexion a la base de datos para retornar las acciones realizadas en la agenda
	 * @author  Sebastian Arancibia
	 * @return bitacoras lista de operaciones realizada en la agenda
	 */
    public List getAllBitacora()
    {
    	List bitacoras=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			//UsuarioEditDB personDB= new UsuarioEditDB(connection);
			//bitacoras = personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bitacoras;
    }
}
