package Administracion;



import java.sql.Connection;
import java.sql.SQLException;
import AdministracionBD.DeleteCitaServiceBD;
import Bd.DBConnectionManager;

public class DeleteCitaService {
	Connection connection;
	public DeleteCitaService(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public int purgarCita(String cliente, String hora){
		int result=0;
		
		try{			
			DeleteCitaServiceBD citaDB= new DeleteCitaServiceBD(connection);
			result= citaDB.purgarCita(cliente, hora);	
			connection.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}
