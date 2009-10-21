package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import TransferObjects.PostOperatorio;

public class EditarPostOperatorioBD {
	Connection connection;
	PreparedStatement update;
	public EditarPostOperatorioBD(Connection connection) throws SQLException{
		this.connection = connection;
		String query = "UPDATE atencionpostoperatorio"+
		   "SET medicamentos= ?, alimentos= ?, indicaciones=?, servicio=?, hora=?,"+ 
		       "fecha=?, costo=?, nombremascota=?, rut=?, apellido=?, nombrecliente=?"+
		 "WHERE hora=? AND fecha=? AND servicio=?;";

			 update = connection.prepareStatement(query);
	}
	public int editarPostOperatorio(List<String> lista){
		int result=0;
		try{
			
			update.setString(1, lista.get(0));
			update.setString(2, lista.get(1));
			update.setString(3, lista.get(2));
			update.setString(4, lista.get(3));
			update.setString(5, lista.get(4));
			update.setString(6, lista.get(5));
			update.setString(7, lista.get(6));
			update.setString(8, lista.get(7));
			update.setString(9, lista.get(8));
			update.setString(10, lista.get(9));
			update.setString(11, lista.get(10));
			
			update.setString(12, lista.get(4));
			update.setString(13, lista.get(5));
			update.setString(14, lista.get(3));
			result  = update.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
