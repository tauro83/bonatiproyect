package Administracion;

import java.sql.Connection;
import java.sql.SQLException;

import AdministracionBD.DelMascotaDB;
import Bd.DBConnectionManager;

public class DelMascota {
	Connection connection;
	public DelMascota(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public int delMascota(String rut, String nombre){
		int result=0;
		
		try{			
			DelMascotaDB mascotaDB= new DelMascotaDB(connection);
			result= mascotaDB.DelMascota(rut, nombre);	
			connection.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}
