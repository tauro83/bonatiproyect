package Pabellon;
//=======================================================================
//FECHA CREACIÓN: 15/10/09 
//AUTOR: Andrés Garrido
//Clase que contecta la capa 2 con la 3
//=======================================================================

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import PabellonBD.EditarPostOperatorioBD;
import TransferObjects.PostOperatorio;

import Bd.DBConnectionManager;
/**
 * @author Andres Garrido
 * @version 1
 * Clase de la capa 2 que nos conecta con la capa 3
 */
public class EditarPostOperatorio {
	Connection connection;
	/**
	 * Constructor de la clase que crea una conexion con la base 
	 * de datos a través de DBConnectionManager
	 */
	public EditarPostOperatorio(){
		
	}
	/**
	 * Método que edita un registro de post operatorio a partir de 
	 * una lista de atributos a actualizar
	 * @param l Lista con todos los atributos a actualizar de un post operatorio
	 * @return Entero que representa si la actualización fue exitosa o no.
	 * @throws SQLException
	 */
	public int editarPostOperatorio(String fecha, String hora, String fecha2, String hora2,String indic) throws SQLException{
		connection=DBConnectionManager.getConnection();
		EditarPostOperatorioBD object = new EditarPostOperatorioBD(connection);
		
		
		int result = object.editarPostOperatorio(fecha, hora, fecha2, hora2,indic);
		connection.close();
		return result;
	}

}
