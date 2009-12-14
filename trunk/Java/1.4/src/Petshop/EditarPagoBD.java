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

import AvisoWeb.AvisoWeb;

/**
 * Clase de la capa 3 que edita un pago en la Base de Datos
 * @author Andres Garrido
 */
public class EditarPagoBD {
	PreparedStatement update;
	
	/**
	 * Constructor de la clase que prepara el statement de inserción de una nueva tabla
	 * en la base de datos dada una conexón como parámetro.
	 * @author Andres_Garrido
	 * @param connection Conexión obtenida con la base de datos.
	 */
	public EditarPagoBD(Connection connection){
		try{
			//preparando la sentencia SQL
			String query = "UPDATE pago SET fecha=?, hora=?, estado=?, total=? "+
						"WHERE fecha=? and hora=?;";


			update = connection.prepareStatement(query);
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * Método de la capa 3 que ejecuta la sentencia SQL preparada anteriormente.
	 * @author Andres_Garrido
	 * @param pago Pago a editar en el sistema.
	 * @return Entero que informa acerca del éxito o fracaso de la operación.
	 */
	public int editarPago(Pago pago, int estado){
		int result = 0;//resultado de la ejecución, 0:fracaso, !0:éxito
		try{
			
			update.setString(1, pago.fecha);
			update.setString(2, pago.hora);
			update.setInt(3, estado);//nuevo estado del pago
			update.setInt(4, pago.total);
			update.setString(5, pago.fecha);
			update.setString(6, pago.hora);
			
			result= update.executeUpdate();//ejecución de la sentencia SQL 
											//con los valores modificados
		} 
    	catch (SQLException e){
			e.printStackTrace();//lanza la excepcion cuando el statement 
								//tiene errores de sintáxis
		}
    	return result;
    }    
}
