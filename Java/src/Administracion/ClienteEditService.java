package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.ClienteEditDB;
import TransferObjects.Cliente;
import Bd.DBConnectionManager;

public class ClienteEditService {
	
	public int insertClienteE(Cliente person, String rutillo, String usuario)
    {
		int result=0;
		
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ClienteEditDB personDB= new ClienteEditDB(connection);
			result= personDB.insertClienteE(person, rutillo, usuario);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List getAllClientesE()
    {
    	List persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			ClienteEditDB personDB= new ClienteEditDB(connection);
			persons= personDB.getAllClientesE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }

}

