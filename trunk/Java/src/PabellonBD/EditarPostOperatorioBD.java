package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.PostOperatorio;

public class EditarPostOperatorioBD {
	Connection connection;
	PreparedStatement update;
	public EditarPostOperatorioBD(Connection connection) throws SQLException{
		this.connection = connection;
		String query = "UPDATE atencionpostoperatorio"+
		   "SET medicamentos=?, alimentos=?, indicaciones=?, servicio=?, hora=?,"+ 
		       "fecha=?, costo=?"+
		 "WHERE hora=? AND fecha=? AND servicio=?;";

			 update = connection.prepareStatement(query);
	}
	public int editarPostOperatorio(PostOperatorio p, String hora,String fecha, String servicio){
		int result=0;
		try{
			update.setString(1, p.getMedicamentos());
			update.setString(2, p.getAlimentos());
			update.setString(3, p.getIndicaciones());
			update.setString(4, p.getServicio());
			update.setString(5, p.getHora());
			update.setString(6, p.getFecha());
			update.setString(7, p.getCosto());
			
			update.setString(8, hora);
			update.setString(9, fecha);
			update.setString(10, servicio);
			result  = update.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
