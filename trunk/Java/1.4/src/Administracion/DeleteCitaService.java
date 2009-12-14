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
	/**
	 * @autor Raul Lopez
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param String rut cliente......
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int purgarCita(String fecha, String hora, String servicio, String responsable){
		int result=0;
		
		try{			
			DeleteCitaServiceBD citaDB= new DeleteCitaServiceBD(connection);
			result= citaDB.purgarCita(fecha, hora, servicio, responsable);	
			connection.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}
