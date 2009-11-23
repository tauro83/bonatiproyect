package Hoteleria;

import java.sql.Connection;
import java.sql.SQLException;

import HoteleriaBD.RegistHoteleriaBD;
import Bd.DBConnectionManager;
import TransferObjects.Hoteleria;

public class RegistHoteleriaService {
	
	public static String registrarHoteleria(Hoteleria a) throws SQLException
	{
		Connection connection = DBConnectionManager.getConnection();
		RegistHoteleriaBD hot = new RegistHoteleriaBD(connection);
		return hot.registrarHoteleria(a);
	}
		
	
	
	public boolean consultar(String rut, String nombre) throws SQLException
    {
		Connection connection = DBConnectionManager.getConnection();
		RegistHoteleriaBD hot = new RegistHoteleriaBD(connection);
		return hot.consultar(rut,nombre);
    }
}
	



	