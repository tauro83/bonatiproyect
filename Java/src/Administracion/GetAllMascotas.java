package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import TransferObjects.Mascota;

import AdministracionBD.GetAllMascotasDB;
import Bd.DBConnectionManager;

public class GetAllMascotas {
	Connection connection;
	
	public GetAllMascotas(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<Mascota> getAllMascotas() throws SQLException{
		GetAllMascotasDB object= new GetAllMascotasDB(connection);
		return object.getAllMascotas();
	}

}
