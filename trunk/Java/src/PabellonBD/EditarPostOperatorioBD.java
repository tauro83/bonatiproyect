package PabellonBD;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import TransferObjects.PostOperatorio;

public class EditarPostOperatorioBD {
	Connection connection;
	PreparedStatement update;
	String query;
	public EditarPostOperatorioBD(Connection connection) throws SQLException{
		this.connection = connection;
		 query = "UPDATE atencionpostoperatorio "+
		   "SET medicamentos=?, alimentos=?, indicaciones=?, servicio=?, hora=?,"+ 
		       "fecha=?, costo=?, nombremascota=?, rut=?, apellido=?, nombrecliente=? "+
		 "WHERE hora=? AND fecha=? AND servicio=?;";

			 update = connection.prepareStatement(query);
	}
	public int editarPostOperatorio(List lista){
		int result=0;
		try{
			
			update.setString(1, (String) lista.get(0));
			update.setString(2, (String) lista.get(1));
			update.setString(3, (String) lista.get(2));
			update.setString(4, (String) lista.get(3));
			update.setString(5, (String) lista.get(4));
			update.setDate(6, new java.sql.Date(((Date) lista.get(5)).getTime()));
			update.setString(7, (String) lista.get(6));
			update.setString(8, (String) lista.get(7));
			update.setString(9, (String) lista.get(8));
			update.setString(10,(String)  lista.get(9));
			update.setString(11, (String) lista.get(10));
			
			update.setString(12, (String) lista.get(4));
			update.setDate(13,new java.sql.Date(((Date) lista.get(5)).getTime()));
			update.setString(14, (String) lista.get(3));
			
			result  = update.executeUpdate();
			System.out.println((String) lista.get(4)+"   "+lista.get(5)+"   "+lista.get(3)+" "+result);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
