package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditDB;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;

public class UsuarioEditService 
{
	public int insertUsuarioE(Usuario person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditDB personDB= new UsuarioEditDB(connection);
			result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List<Usuario> getAllUsuariosE()
    {
    	List<Usuario> persons=new ArrayList<Usuario>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditDB personDB= new UsuarioEditDB(connection);
			persons= personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
}
