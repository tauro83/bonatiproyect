package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.CircularRedirectException;


import AdministracionBD.CitaEditDB;
import TransferObjects.Cita;
import Bd.DBConnectionManager;

public class EditarCitaService {
	
	public int insertCitaE(Cita person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			CitaEditDB personDB= new CitaEditDB(connection);
			result= personDB.insertCitaE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List<Cita> getAllCitasE()
    {
    	List<Cita> persons=new ArrayList<Cita>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			CitaEditDB personDB= new CitaEditDB(connection);
			persons= personDB.getAllCitasE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
    public Cita getCita(String rut)
    {
    	Cita ci = new Cita();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			CitaEditDB personDB= new CitaEditDB(connection);
			ci= personDB.getCitaDB(rut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return ci;
    }

}
