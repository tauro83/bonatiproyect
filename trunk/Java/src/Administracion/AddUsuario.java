package Administracion;

import java.sql.Connection;
import java.sql.SQLException;

import TransferObjects.Usuario;

import AdministracionBD.AddUsuarioBD;
import Bd.DBConnectionManager;

public class AddUsuario {

	
	public static String addUsuario(Usuario u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddUsuarioBD aubd = new AddUsuarioBD(connection);		
		return aubd.addUsuario(u);
	}
}
