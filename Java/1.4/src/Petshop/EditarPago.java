//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Andres Garrido
// Comentarios: Clase capa 2 encargada de editar un aviso web del sistema
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;

import TransferObjects.Pago;

import AvisoWeb.AvisoWeb;
import Bd.DBConnectionManager;

/**
 * Clase que ejecuta la edición de un registro de Aviso Web
 * de la Base de Datos.
 * @author Andres_Garrido
 */
public class EditarPago {
	Connection conn;
	
	/**
	 * Constructor de la clase que obtiene la conexón con la base de datos.
	 * @author Andres_Garrido
	 */
	public EditarPago(){
		conn=DBConnectionManager.getConnection();
	}
	/**
	 * Método que conecta con la capa 3 entregándole la conexión a la base de datos,
	 * el pago a editar y el nuevo estado de éste.
	 * @param pago Pago a editar en el sistema.
	 * @return Entero que informa acerca del éxito o fracaso de la operación.
	 * @throws SQLException
	 */
	public int editarPago(Pago pago, int estado) throws SQLException{
		int result=0;//resultado de la ejecución, 0:fracaso, !0:éxito
		EditarPagoBD object= new EditarPagoBD(conn);
		result = object.editarPago(pago, estado);//conexión con capa 3
		conn.close();
		return result;
    }
}
