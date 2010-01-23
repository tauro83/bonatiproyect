package AdministracionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarHoteleriaServiceBD {
	PreparedStatement retirar;
	Connection connection;
	
	public EliminarHoteleriaServiceBD(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "UPDATE antencionAlojamiento"+
		"SET estado='2' WHERE fechaIngreso=? AND fechaSalida=? AND canil=?;";

		retirar = connection.prepareStatement(query);
		
	}

	public int eliminarHoteleria(Date fechaIngreso, Date fechaSalida, int canil){
		int x=0;
		try{
			retirar.setDate(1, fechaIngreso);
			retirar.setDate(2, fechaSalida);
			retirar.setInt(3, canil);
			x= retirar.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

}
