package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.CircularRedirectException;


import AdministracionBD.MascotaEditDB;
import TransferObjects.Mascota;
import Bd.DBConnectionManager;

public class EditarMascotaService {
	
	public int insertMascotaE(Mascota person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MascotaEditDB personDB= new MascotaEditDB(connection);
			result= personDB.insertMascotaE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List<Mascota> getAllMascotasE()
    {
    	List<Mascota> persons=new ArrayList<Mascota>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MascotaEditDB personDB= new MascotaEditDB(connection);
			//persons= personDB.getAllMascotasE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
    public Mascota getMascota(String rut)
    {
    	Mascota mas = new Mascota();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MascotaEditDB personDB= new MascotaEditDB(connection);
			//mas= personDB.getMascotaDB(rut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return mas;
    }

}
