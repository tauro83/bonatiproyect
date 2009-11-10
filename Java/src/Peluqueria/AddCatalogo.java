//=======================================================================
// FECHA CREACI�N: 29/10/09
// AUTOR: Erwin D�az
// DESCRIPCION: Agrega un cat�logo a la base de datos
//=======================================================================

package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.CatPeluqueria;
import PeluqueriaBD.AddCatalogoBD;
import Bd.DBConnectionManager;


/**
 * Clase que agrega un cat�logo a la base de datos
 * @author Erwin D�az
 *
 */
public class AddCatalogo {

	/**
	 * 
	 * @return Este metodo retorna un string, que indica si el usuario fue registrado
	 * Correctamente a la BD.
	 */
	public static String addCatalogo(CatPeluqueria u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddCatalogoBD addCat = new AddCatalogoBD(connection);
		System.out.println("llega______---->");
		return addCat.addCatalogo(u);
	}
}
