//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Andres Garrido
// Comentarios: Clase capa 3 encargada de registar un aviso web en el sistema
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import TransferObjects.Pago;
/**
 * Clase que ejecuta la inserción de un nuevo registro de Aviso Web en la 
 * Base de Datos
 * @author Andres Garrido
 */
public class RegistrarPagoServiceBD {
	PreparedStatement insert;
	
	/**
	 * Constructor de la clase que prepara el statement de inserción de una nueva tabla
	 * en la base de datos
	 * @author Andres_Garrido
	 * @param connection Conexión obtenida con la base de datos
	 */
	public RegistrarPagoServiceBD(Connection connection){
		try{
			//preparando la sentencia SQL
			String query = "INSERT INTO pago(fecha, hora, estado, total) "+
						"VALUES (?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * Método de la capa 3 que ejecuta la sentencia SQL preparada anteriormente
	 * @author Andres_Garrido
	 * @param pago Pago a registrar en el sistema
	 * @return Entero que informa acerca del éxito o fracaso de la operación
	 */
	public int registrarPago(Pago pago){
		int result = 0;//resultado de la ejecución, 0:fracaso, !0:éxito
		try{
			insert.setString(1, pago.fecha);
			insert.setString(2, pago.hora);
			insert.setInt(3, 1);
			insert.setInt(4, pago.total);
			
			result= insert.executeUpdate();//ejecución de la sentencia SQL 
											//con los valores modificados
		} 
    	catch (SQLException e){
			e.printStackTrace();//lanza la excepcion cuando el statement 
								//tiene errores de sintáxis
		}
    	return result;
    }    
}
