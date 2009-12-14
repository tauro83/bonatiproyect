//=======================================================================
// FECHA CREACIÓN: 24-11-09
// AUTOR: Esteban Cruz
// Clase encargada de realizar la conexion y llamar a la funcion 
// para editar los datos solicitados por el usuario
// en la base de datos. Para ello se consta de 2 funciones 
// principalmente, una que lista los productos y otra que modifica
// los valores del registro
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.editarProductoBD;
import Bd.DBConnectionManager;
import HoteleriaBD.EditHoteleriaBD;
import TransferObjects.Hoteleria;
import TransferObjects.Producto;

public class editarProducto1 {
	
	/**
	* Trata de obtener todos los productos registrados en la base de datos
	* @return Lista con todos los productos registrados
	* @author Esteban Cruz
	*/
	public List getAllVacunaciones()
    {
		List vacunaciones = new ArrayList();
		/**
		* Trata de realizar la conexion y llamar a la funcion
		*/
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			editarProductoBD vacunacionBD= new editarProductoBD(connection);
			vacunaciones = vacunacionBD.getAllVacunaciones();	
			connection.close();
		} 
		/**
		* Captura el error
		*/
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	/**
	 * Trata de modificar los datos solicitados por el usuario en la base de datos
	 * @return 1 si se realiza correctamente, 0 en caso contrario
	 * @author Esteban Cruz
	 */
	public int modificarProducto(String nombre,String descripcion,String precio,String categoria,String codigo)
    {
		int result=0;
		/**
		* Trata de realizar la conexion y llamar a la funcion
		*/
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			editarProductoBD hBD = new editarProductoBD(connection);
			result= hBD.modificarProducto(nombre,descripcion,precio,categoria,codigo);		
			connection.close();
		}
		/**
		* Captura el error
		*/
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
}
