package Hoteleria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import HoteleriaBD.RegistHoteleriaBD;
import Bd.DBConnectionManager;
import TransferObjects.Hoteleria;
import TransferObjects.Mascota;

public class RegistHoteleriaService {
	
	public static int registrarHoteleria(Hoteleria a) throws SQLException
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
	
	/**
	 *Metodo que Retorna todas mascotas de un cliente que no esten en alojadas en hoteleria
	 * @autor Victor Silva
	 * @param ninguno
	 */
	public List<Mascota> cargarMascotas(String rut)
    {
		List<Mascota> mascotas = new ArrayList<Mascota>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			RegistHoteleriaBD hot= new RegistHoteleriaBD(connection);
			mascotas = hot.cargarMascotas(rut);	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return mascotas;
    }
}
	



	