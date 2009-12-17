//=======================================================================
// FECHA CREACIÓN: 10 de Noviembre de 2009
// AUTOR: Sebastian Arancibia
// …. Clase para la comunicacion entre flex y java 
//=======================================================================

package Hoteleria;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import HoteleriaBD.EditHoteleriaBD;
import TransferObjects.Hoteleria;
import Bd.DBConnectionManager;

public class EditHoteleriaService {
	/**
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * 
	 * @autor Sebastian Arancibia
	 * @param h contiene los datos del registro de Hoteleria que se quiere editar.
	 * @param fea Fecha de Entrada antigua a la modificacion
	 * @param fsa Fecha de Salida antigua a la modificacion
	 * @param ca Canil antiguo a la modificacion
	 * @return result 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int editarHoteleria(Hoteleria h, Date fea, Date fsa, int ca)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditHoteleriaBD hBD = new EditHoteleriaBD(connection);
			result= hBD.editarHoteleria(h, fea, fsa, ca);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

}
