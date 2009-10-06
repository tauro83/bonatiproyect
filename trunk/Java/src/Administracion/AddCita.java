package Administracion;

import java.sql.Connection;
import java.sql.SQLException;

import TransferObjects.Cita;
import AdministracionBD.AddCitaBD;
import Bd.DBConnectionManager;

public class AddCita {

	public static String addCita(Cita c) throws SQLException {
		Connection connection = DBConnectionManager.getConnection();
		AddCitaBD acbd = new AddCitaBD(connection);
		return acbd.addCita(c);
	}

}
