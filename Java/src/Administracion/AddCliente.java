package Administracion;

import java.sql.Connection;
import java.sql.SQLException;

import TransferObjects.Cliente;

import AdministracionBD.AddClienteBD;
import Bd.DBConnectionManager;


public class AddCliente {
	
	public static String addCliente(Cliente c) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		AddClienteBD acbd = new AddClienteBD(connection);		
		return acbd.addCliente(c);
	}

}
