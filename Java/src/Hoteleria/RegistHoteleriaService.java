package Hoteleria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import HoteleriaBD.RegistHoteleriaBD;
import AdministracionBD.AddCitaBD;
import Bd.DBConnectionManager;
import TransferObjects.Cliente;
import TransferObjects.Hoteleria;;;

public class RegistHoteleriaService {
	
	public static String registrarHoteleria(Hoteleria a) throws SQLException
	{
		Connection connection = DBConnectionManager.getConnection();
		RegistHoteleriaBD hot = new RegistHoteleriaBD(connection);
		return hot.registrarHoteleria(a);
	}
		
	
	
	public List<Cliente> getClientesActivos()
    {
    	List<Cliente> clientes=new ArrayList<Cliente>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddCitaBD addCitaBD= new AddCitaBD(connection);
			clientes= addCitaBD.getClientesActivosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
    }
	}
	



	