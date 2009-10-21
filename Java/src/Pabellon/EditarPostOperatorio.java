package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;

import PabellonBD.EditarPostOperatorioBD;
import TransferObjects.PostOperatorio;

import Bd.DBConnectionManager;

public class EditarPostOperatorio {
	Connection connection;
	public EditarPostOperatorio(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public int editarPostOperatorio(PostOperatorio p, String hora, String fecha, String servicio) throws SQLException{
		EditarPostOperatorioBD object = new EditarPostOperatorioBD(connection);
		int result = object.editarPostOperatorio(p,hora,fecha,servicio);
		connection.close();
		return result;
	}

}
