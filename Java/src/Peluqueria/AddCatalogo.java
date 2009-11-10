//=======================================================================
// FECHA CREACIÓN: 29/10/09
// AUTOR: Erwin Díaz
// DESCRIPCION: Agrega un catálogo a la base de datos
//=======================================================================

package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.CatPeluqueria;
import PeluqueriaBD.AddCatalogoBD;
import Bd.DBConnectionManager;


/**
 * Clase que agrega un catálogo a la base de datos
 * @author Erwin Díaz
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
