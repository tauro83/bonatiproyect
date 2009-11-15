package AvisoWeb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.AvisoWeb;

public class AvisoWebService {

	/**
	 * Trata de obtener todos los avisos web registrados en la base de datos
	 * @return Lista con todos los avisos web registrados
	 * @author Esteban Cruz
	 */
	public List<AvisoWeb> getAllAvisosWeb()
    {
		List<AvisoWeb> avisosweb = new ArrayList<AvisoWeb>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			//Funcion
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return avisosweb;
    }
	
	/**
	 * Crea la conexion a la base de datos para registrar un aviso web
	 * @param usuario contiene los datos del aviso web que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 * @author  Esteban Cruz
	 */
	public int addAvisoWeb(AvisoWeb usuario){
		int result=0;
		try{
			Connection connection=DBConnectionManager.getConnection();
			//Funcion
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
    }
}
