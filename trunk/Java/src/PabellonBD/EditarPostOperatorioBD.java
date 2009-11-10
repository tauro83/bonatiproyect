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
		   "SET medicamentos=?, alimentos=?, indicaciones=?, servicio=?, hora=?,"+ 
		       "fecha=?, costo=?, nombremascota=?, rut=?, apellido=?, nombrecliente=? "+
		 "WHERE hora=? AND fecha=? AND servicio=?;";

			 update = connection.prepareStatement(query);
	}
	/**
	 * @author Andres Garrido
	 * @version 1
	 * Por facilidad de implementacion esta funcion toma una lista con los elementos a actualizar
	 * en la base de datos y los rellena en la sentencia sql para luego ejecutarla
	 */
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
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
