package Pabellon;


import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.PostOperatorio;
import PabellonBD.AddPostOperatorioBD;
import Bd.DBConnectionManager;


public class AddPostOperatorioService {
	
	public static int addPostOperatorio(PostOperatorio postOpe) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddPostOperatorioBD postOpeBD = new AddPostOperatorioBD(connection);		
		return postOpeBD.registroPostOperatorio(postOpe);
	}

}