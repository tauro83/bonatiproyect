package PabellonBD;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import TransferObjects.PostOperatorio;
/**
 * @author Andres Garrido
 * @version 1
 * clase que edita la informacion de una tupla de Post operatorio
 * dada una hora, fecha y servicio
 */
public class EditarPostOperatorioBD {
	Connection connection;
	PreparedStatement update;
	String query;
	/**
	 * Constructor de la clase que recibe una conexion creada para la base de datos
	 * y que prepara el statemnt para la actualizacion del post operatorio
	 * @param connection Una conexion a la base de datos
	 * @throws SQLException
	 */
	public EditarPostOperatorioBD(Connection connection) throws SQLException{
		this.connection = connection;
		 query = "UPDATE atencionpostoperatorio "+
		   "SET indicaciones=?, hora=?, fecha=? "+
		 "WHERE hora=? AND fecha=? AND servicio='Pabellon';";

			 update = connection.prepareStatement(query);
	}
	/**
	 * @author Andres Garrido
	 * @version 1
	 * Por facilidad de implementacion esta funcion toma una lista con los elementos a actualizar
	 * en la base de datos y los rellena en la sentencia sql para luego ejecutarla
	 */
	public int editarPostOperatorio(String fecha, String hora,String fecha2, String hora2, String indicaciones){
		int result=0;
		try{
			update.setString(1, indicaciones);
			update.setString(2, hora2);
			update.setString(3, fecha2);
			update.setString(4, hora);
			update.setString(5, fecha);
			result  = update.executeUpdate();
			System.out.println("ASDASDASDS  "+result);
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
