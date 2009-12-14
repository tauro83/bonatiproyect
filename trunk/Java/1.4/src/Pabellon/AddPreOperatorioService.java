package Pabellon;


import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.Preoperatorio;
import PabellonBD.AddPreOperatorioBD;
import Bd.DBConnectionManager;


public class AddPreOperatorioService {
	
	public static int addPreoperatorio(Preoperatorio u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddPreOperatorioBD aubd = new AddPreOperatorioBD(connection);		
		return aubd.addPreoperatorio(u);
	}

}