package Policlinico;
//=======================================================================
//FECHA CREACIÓN: 02/11/09 
//AUTOR: Andrés Garrido
//Clase que contecta la capa 2 con la 3
//=======================================================================

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import Bd.DBConnectionManager;
import PoliclinicoBD.DeleteControlBD;
/**
 * @author Andres Garrido
 * @version 1
 * Clase que conecta la capa 2 con la 3, en este caso con la clase
 * DeleteControlBD
 */
public class DeleteControl {
	Connection connection;
	/**
	 * Este metodo hace el llamado a la clase equivalente en la capa de BD.
	 * elimina un control registrado en el sistema, dado una hora, fecha y responsable para
	 * poder identificarla de manera única
	 * @param hora hora en que se realizó el control
	 * @param fecha fecha en que realizó el control
	 * @param responsable persona que encargada del control
	 * @return variable entera que determina si la eliminacion fue correcta o no
	 */
	public int deleteControl(String hora, Date fecha, String responsable, String motivo){
		int result=0;
    	try{
    		connection=DBConnectionManager.getConnection();
    		DeleteControlBD object= new DeleteControlBD(connection);
			result	= object.deleteControl(hora,fecha,responsable, motivo);
			connection.close();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return result;
	}
}
