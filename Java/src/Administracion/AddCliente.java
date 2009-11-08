//=======================================================================
//FECHA CREACI�N: 20/09/09
//AUTOR: Nicolas Delgado.
// Comenetario: Clase entidad Cliente de sistema, encapsula informacion de un Cliente
//  Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;

import TransferObjects.Cliente;

import AdministracionBD.AddClienteBD;
import Bd.DBConnectionManager;


/**Registra el Cliente
 * @return Este metodo retorna un string, que indica si el cliente fue registrado
 * Correctamente a la BD.
 */
public class AddCliente {
	
	public static String addCliente(Cliente c) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddClienteBD acbd = new AddClienteBD(connection);		
		return acbd.addCliente(c);
	}

}