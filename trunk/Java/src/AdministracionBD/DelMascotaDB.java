package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelMascotaDB {
	PreparedStatement delete;
	Connection connection;
	
	public DelMascotaDB(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "UPDATE mascota"+
		   "SET estado =?"+
			 "WHERE rut=? AND nombre=?;";
		delete = connection.prepareStatement(query);
		/*
		String query = "DELETE"+
		"FROM mascota WHERE rut=? AND nombre=?;";

		delete = connection.prepareStatement(query);
		*/
	}

	public int DelMascota(String rut,String nombre){
		int x=0;
		try{
			System.out.println(rut+nombre);
			delete.setBoolean(1, false);
			delete.setString(2, rut);
			delete.setString(3, nombre);
			x= delete.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}
	
}
