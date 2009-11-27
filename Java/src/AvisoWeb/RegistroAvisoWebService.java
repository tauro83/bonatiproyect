
//======================================================================
// FECHA  CREACIÓN: 08/11/09
// AUTOR: Cristian Bravo
// Comentarios: Encargada de enviar y recibir datos entre la interfaz
//				y la capa lógica
//=======================================================================



package AvisoWeb;

import java.sql.Connection;
import java.sql.SQLException;
import AvisoWeb.AvisoWeb;
import AvisoWeb.RegistroAvisoWebServiceBD;
import Bd.DBConnectionManager;
import TransferObjects.aviWeb;


public class RegistroAvisoWebService {

	/**
	 * Trata de registrar en la  base de datos
	 * @author  "Cristian Bravo"
	 * @return Resultado de la operación realizada
	 */
	
	public String RegistroAvisoWeb(aviWeb aviso)throws SQLException
    {
		
			Connection connection=DBConnectionManager.getConnection();
			RegistroAvisoWebServiceBD avisoDB= new RegistroAvisoWebServiceBD(connection);
			return avisoDB.registroAvisoWebBD(aviso);
	
    }
	
	/**
	 * Funcion que obtiene el ultimo Id del registro de un aviso Web
	 * @author  "Cristian Bravo"
	 * @return Resultado de la operación realizada
	 */
	
	public int getUltimo()
	{
		int ultimo=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			RegistroAvisoWebServiceBD avisoDB= new RegistroAvisoWebServiceBD(connection);
			ultimo= avisoDB.getUltimo();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return ultimo;
		
	}

}