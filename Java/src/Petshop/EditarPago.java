//=======================================================================
// FECHA CREACI�N: 24/11/09
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
 * Clase que ejecuta la edici�n de un registro de Aviso Web
 * de la Base de Datos.
 * @author Andres_Garrido
 */
public class EditarPago {
	Connection conn;
	
	/**
	 * Constructor de la clase que obtiene la conex�n con la base de datos.
	 * @author Andres_Garrido
	 */
	public EditarPago(){
		conn=DBConnectionManager.getConnection();
	}
	/**
	 * M�todo que conecta con la capa 3 entreg�ndole la conexi�n a la base de datos,
	 * el pago a editar y el nuevo estado de �ste.
	 * @param pago Pago a editar en el sistema.
	 * @return Entero que informa acerca del �xito o fracaso de la operaci�n.
	 * @throws SQLException
	 */
	public int editarPago(Pago pago, int estado) throws SQLException{
		int result=0;//resultado de la ejecuci�n, 0:fracaso, !0:�xito
		EditarPagoBD object= new EditarPagoBD(conn);
		result = object.editarPago(pago, estado);//conexi�n con capa 3
		conn.close();
		return result;
    }
}
