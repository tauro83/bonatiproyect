package MantenerUsuario;

import java.sql.Connection;
import java.sql.SQLException;

import transferObjects.Usuario;
import MantenerUsuarioBD.AddUsuarioBD;
import bd.DBConnectionManager;

public class AddUsuario {

	
	public static String addUsuario(Usuario u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddUsuarioBD aubd = new AddUsuarioBD(connection);		
		return aubd.addUsuario(u);
	}
}
