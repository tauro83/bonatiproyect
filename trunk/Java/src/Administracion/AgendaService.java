package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import AdministracionBD.UsuarioEditDB;
import Agenda.Agenda;
import Bd.DBConnectionManager;

public class AgendaService 
{
	public int addAgenda(Agenda agenda)
    {
		int result=0;
		try 
		{
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

    public List<Agenda> getAgenda(String fecha){
    	List<Agenda> agendas=new ArrayList<Agenda>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			//UsuarioEditDB personDB= new UsuarioEditDB(connection);
			//agendas= personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return agendas;
    }
}
