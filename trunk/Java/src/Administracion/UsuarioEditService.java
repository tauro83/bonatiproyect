package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditBD;
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
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

	public int deleteUser(String clave)
    {
		//System.out.println("Clave: "+clave);
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioElimBD userDB= new UsuarioElimBD(connection);
			
			//System.out.println("Clave: "+clave+" entra al try");
			
			result= userDB.deleteUser(clave);
			
			//System.out.println("Clave: "+clave+" despues de la consulta");
			
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
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
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
