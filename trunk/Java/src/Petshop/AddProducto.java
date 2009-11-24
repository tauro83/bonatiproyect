//=======================================================================
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad Producto, encapsula informacion de un producto ofrecido en petshop
//  Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.Producto;
import Bd.DBConnectionManager;

public class AddProducto {

	/**
	 * Registra el producto. Este objeto es enviado a la capa 3, para ser registrado en la BD
	 * @return Este metodo retorna un string, que indica si el producto fue registrado
	 * Correctamente a la BD.
	 */
	public static String addProducto(Producto p) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		//AddProductoBD aprod = new AddProductoBD(connection);		
		return "";
		//return aubd.addUsuario(u);
	}
}
