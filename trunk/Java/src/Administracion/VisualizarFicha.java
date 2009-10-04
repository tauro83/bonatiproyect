package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import Bd.DBConnectionManager;

public class VisualizarFicha {
	
	public static String visualizarFicha() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		return "";
	}
}

