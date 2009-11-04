package Policlinico;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import PoliclinicoBD.GetAllControlesBD;
import TransferObjects.Control;
import PoliclinicoBD.DeleteControlBD;

public class DeleteControl {
	Connection connection;
	/**
	 * Este metodo hace el llamado a la clase equivalente en la capa de BD.
	 */
	public int deleteControl(String hora, Date fecha, String responsable){
		int result=0;
    	try{
    		connection=DBConnectionManager.getConnection();
    		DeleteControlBD object= new DeleteControlBD(connection);
			result	= object.deleteControl(hora,fecha,responsable);
			connection.close();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return result;
	}
}
