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
	public int delMascota(String rut, String nombre, boolean status, String usuario){
			int result=0;
		
		try{			
			DelMascotaDB mascotaDB= new DelMascotaDB(connection);
			result= mascotaDB.DelMascota(rut, nombre,status, usuario);	
			connection.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}
