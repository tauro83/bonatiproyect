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
		
		String query = "UPDATE atencionAlojamiento "+
		"SET estado='2', fechaSalida=? " +
		"WHERE fechaIngreso=? AND fechaSalida=? AND canil=?;";

		retirar = connection.prepareStatement(query);
		
	}

	public int eliminarHoteleria(Date fechaIngreso, Date fechaSalida, int canil){
		int x=0;
		java.util.Date today = new java.util.Date();
		Date d = new Date(today.getTime());
		System.out.println(d.toString());
		try{
			retirar.setDate(1, d);
			retirar.setDate(2, fechaIngreso);
			retirar.setDate(3, fechaSalida);
			retirar.setInt(4, canil);
			x= retirar.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

}
