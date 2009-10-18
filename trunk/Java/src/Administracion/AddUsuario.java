package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.Usuario;
import AdministracionBD.AddUsuarioBD;
import Bd.DBConnectionManager;


/**
 * @author Camilo Verdugo
 * @version 2
 *  Clase entidad Usuario de sistema, encapsula informacion de un Usuario y el privilegio de acceso al sistema.
 *  Solo contiene los metodos para hacer get/set de los atributos.
 *  		
 **/
public class AddUsuario {

	/**
	 * 
	 * @return Este metodo retorna un string, que indica si el usuario fue registrado
	 * Correctamente a la BD.
	 */
	public static String addUsuario(Usuario u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddUsuarioBD aubd = new AddUsuarioBD(connection);		
		return aubd.addUsuario(u);
	}
}
