//=======================================================================
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad Usuario de sistema, encapsula informacion de un Usuario y el privilegio de acceso al sistema.
//  Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.Usuario;
import AdministracionBD.AddUsuarioBD;
import Bd.DBConnectionManager;

public class AddUsuario {

	/**Registra el usuario
	 * @return Este metodo retorna un string, que indica si el usuario fue registrado
	 * Correctamente a la BD.
	 */
	public static String addUsuario(Usuario u, String usuario) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddUsuarioBD aubd = new AddUsuarioBD(connection);
		String retorno = aubd.addUsuario(u, usuario);
		connection.close();
		return retorno;
		
	}
}
