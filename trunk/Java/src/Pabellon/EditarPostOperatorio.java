package Pabellon;

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
	public EditarPostOperatorio(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * @author Andres Garrido
	 * @version 1
	 * clase que toma una lista que viene de la capa 1 y la traspasa a la capa 2
	 * mediante EditarPostOperatorioBD
	 */
	public int editarPostOperatorio(List l) throws SQLException{
		EditarPostOperatorioBD object = new EditarPostOperatorioBD(connection);
		
		
		int result = object.editarPostOperatorio(l);
		connection.close();
		return result;
	}

}
