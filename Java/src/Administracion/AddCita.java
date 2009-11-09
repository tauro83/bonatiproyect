package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cita;
import TransferObjects.Cliente;
import TransferObjects.Mascota;
import AdministracionBD.AddCitaBD;
import Bd.DBConnectionManager;

public class AddCita {

	public static String addCita(Cita c) throws SQLException {
		Connection connection = DBConnectionManager.getConnection();
		AddCitaBD acbd = new AddCitaBD(connection);
		return acbd.addCita(c);
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
	
	
	public List<Mascota> getMascotas(String rut)
    {
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddCitaBD addCitaBD= new AddCitaBD(connection);
			mascotas= addCitaBD.getMascotas(rut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return mascotas;
    }

}
