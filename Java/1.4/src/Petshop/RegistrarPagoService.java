//=======================================================================
// FECHA CREACI�N: 24/11/09
// AUTOR: Andres Garrido
// Comentarios: Clase capa 2 encargada de registar un aviso web en el sistema
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.Pago;
import Bd.DBConnectionManager;

public class RegistrarPagoService {
	Connection conn;
	/**
	 * Constructor de la clase que obtiene la conexion con la base de datos
	 * @author Andres_Garrido
	 * 
	 */
	public RegistrarPagoService(){
		conn=DBConnectionManager.getConnection();
	}
	/**
	 * M�todo que conecta con la capa 3 entreg�ndole una conexion establecida
	 * con la base de datos.
	 * @param pago Pago a registrar en el sistema.
	 * @return Entero que informa acerca del �xito o fracaso de la operaci�n.
	 * @throws SQLException
	 */
	public int registrarPago(Pago pago) throws SQLException{
		int result=0;//resultado de la ejecuci�n, 0:fracaso, !0:�xito
		RegistrarPagoServiceBD object= new RegistrarPagoServiceBD(conn);
		result = object.registrarPago(pago);//conexi�n con capa 3
		conn.close();
		return result;
    }
	public Producto getProducto(String codigo){
		System.out.println("qwqqqqqqqqqqqqqqqqqqqqqqqqqqq " + codigo);
		Producto p = new Producto();
		RegistrarPagoServiceBD object= new RegistrarPagoServiceBD(conn);
		p = object.getProducto(codigo);
		return p;
	}
}
