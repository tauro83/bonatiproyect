package AdministracionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarHoteleriaServiceBD {
	PreparedStatement delete;
	Connection connection;
	
	public EliminarHoteleriaServiceBD(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "DELETE "+
		"FROM atencionAlojamiento WHERE fechaIngreso=? AND fechaSalida=? AND canil=?;";

		delete = connection.prepareStatement(query);
		
	}

	public int eliminarHoteleria(Date fechaIngreso, Date fechaSalida, int canil){
		int x=0;
		try{
			delete.setDate(1, fechaIngreso);
			delete.setDate(2, fechaSalida);
			delete.setInt(3, canil);
			x= delete.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

}
