package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import AdministracionBD.PurgarMascotaDB;
import Bd.DBConnectionManager;

public class PurgarMascota {
	Connection connection;
	public PurgarMascota(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public int purgarMascota(String rut, String nombre, String usuario){
		int result=0;
		
		try{			
			PurgarMascotaDB mascotaDB= new PurgarMascotaDB(connection);
			result= mascotaDB.purgarMascota(rut, nombre, usuario);	
			connection.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}
