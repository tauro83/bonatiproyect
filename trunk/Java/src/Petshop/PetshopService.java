//=======================================================================
//FECHA CREACI�N: 20/11/09
//AUTOR: Erwin D�az
//Comentarios: Transfiere datos entre la capa l�gica y la base de datos
//			   y entre la interf�z y la capa l�gica
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;

import TransferObjects.Producto;
import Petshop.PetshopBD;
import Bd.DBConnectionManager;

public class PetshopService {

	/**
	 * Trata de editar el aviso registrado en la base de datos
	 * @return Resultado de la operaci�n realizada
	 */
	public int regProducto(Producto p)
    {
		int result = 0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PetshopBD personDB= new PetshopBD(connection);
			result = personDB.regProductoBD(p);		
			
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
}
