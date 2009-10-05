package Agenda;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import AdministracionBD.UsuarioEditDB;
import Bd.DBConnectionManager;
import AgendaBD.DiaAgendaDB;
import Agenda.DiaAgenda;

public class DiaAgendaServices 
{
    public List <DiaAgenda> getDiaAgenda(String fecha){
    	System.out.println("Recibo: "+ fecha);
    	List<DiaAgenda> citas=new ArrayList<DiaAgenda>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			DiaAgendaDB diaAgendaDB= new DiaAgendaDB(connection);
			citas = diaAgendaDB.getDiaAgenda(fecha);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return citas;
    }
}
