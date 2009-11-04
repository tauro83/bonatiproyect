package PoliclinicoBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteControlBD {

	PreparedStatement delete;
	public DeleteControlBD(Connection conn) throws SQLException {
		String query = "delete from atencioncontrol " +
				"where hora=? and fecha=? and responsable=?;";
		delete = conn.prepareStatement(query);
	}

	public int deleteControl(String hora, Date fecha, String responsable) {
		int x=0;
		try{
			delete.setString(1, hora);
			delete.setDate(2, fecha);
			delete.setString(3, responsable);
			x= delete.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

}
