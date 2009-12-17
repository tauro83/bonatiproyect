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
	public String addCatalogo(CatPeluqueria u)
    {
		String result = "0";
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddCatalogoBD personDB = new AddCatalogoBD(connection);
			result = personDB.regCatalogo(u);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

}
