package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	public int editarPostOperatorio(List l) throws SQLException{
		EditarPostOperatorioBD object = new EditarPostOperatorioBD(connection);
		
		
		int result = object.editarPostOperatorio(l);
		connection.close();
		return result;
	}

}
