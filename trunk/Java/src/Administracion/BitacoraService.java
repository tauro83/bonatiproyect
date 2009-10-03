package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import AdministracionBD.UsuarioEditDB;
import Agenda.Bitacora;
import Bd.DBConnectionManager;

public class BitacoraService 
{
	public int insertUsuarioE(Bitacora bitacora)
    {
		int result=0;
		try {
			Connection connection=DBConnectionManager.getConnection();
			//UsuarioEditDB personDB= new UsuarioEditDB(connection);
			//result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List<Bitacora> getAllBitacora()
    {
    	List<Bitacora> bitacoras=new ArrayList<Bitacora>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			//UsuarioEditDB personDB= new UsuarioEditDB(connection);
			//bitacoras = personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bitacoras;
    }
}
