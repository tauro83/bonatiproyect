package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurgarMascotaDB {
	PreparedStatement delete;
	Connection connection;
	
	public PurgarMascotaDB(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "DELETE "+
		"FROM mascota WHERE rut=? AND nombre=?;";

		delete = connection.prepareStatement(query);
		
	}

	public int purgarMascota(String rut,String nombre){
		int x=0;
		try{
			delete.setString(1, rut);
			delete.setString(2, nombre);
			x= delete.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

}
