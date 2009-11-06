package PoliclinicoBD;
//=======================================================================
//FECHA CREACIÓN: 02/11/09 
//AUTOR: Andrés Garrido
//Clase que contecta la capa 2 con la 3
//=======================================================================

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * @author Andres Garrido
 * @version 1
 * Clase de la capa 3 que borra un control de la base de datos
 */
public class DeleteControlBD {

	PreparedStatement delete;
	/**
	 * Constructor de la clase que recibe una conexion creada a la BD
	 * y que prepara el statement para borrar un control
	 * @param conn Conexion creada a partir de DBConnectionManager
	 */
	public DeleteControlBD(Connection conn) throws SQLException {
		String query = "delete from atencioncontrol " +
				"where hora=? and fecha=? and responsable=?;";
		delete = conn.prepareStatement(query);
	}
	/**
	 * Este metodo ejecuta el script de borrado para un control
	 * registrado en el sistema, dado una hora, fecha y responsable para
	 * poder identificarla de manera única
	 * @param hora hora en que se realizó el control
	 * @param fecha fecha en que realizó el control
	 * @param responsable persona que encargada del control
	 * @return variable entera que determina si la eliminacion fue correcta o no
	 */
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
