//=======================================================================
// AUTOR: Sebastian Arancibia.
// Descripcion: Clase entidad Pago, encapsula informacion de un pago ofrecido en petshop
//  Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.DetallePago;
import Bd.DBConnectionManager;

public class RegistrarPagoService {

	/**
	 * Registra el pago. Este objeto es enviado a la capa 3, para ser registrado en la BD
	 * @return Este metodo retorna un string, que indica si el pago fue registrado
	 * Correctamente a la BD.
	 */
	public static String registrarPago(DetallePago p) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		//AddProductoBD aprod = new AddProductoBD(connection);		
		return "";
		//return aubd.addUsuario(u);
	}
}
