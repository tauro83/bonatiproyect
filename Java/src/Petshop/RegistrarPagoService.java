//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Andres Garrido
// Comentarios: Clase capa 2 encargada de registar un aviso web en el sistema
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.SQLException;
import TransferObjects.Producto;
import Bd.DBConnectionManager;

import TransferObjects.Pago;

public class RegistrarPagoService {
	public Producto getProducto(String codigo){
    	Producto p = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			RegistrarPagoServiceBD addMascotaBD = new RegistrarPagoServiceBD(connection);
			p = addMascotaBD.getProducto(codigo);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public int addPago(Pago pago) throws SQLException{
		int result=0;//resultado de la ejecución, 0:fracaso, !0:éxito
    	try {
    		Connection connection=DBConnectionManager.getConnection();
    		RegistrarPagoServiceBD object= new RegistrarPagoServiceBD(connection);
    		result = object.registrarPago(pago);//conexión con capa 3	
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
    }

}
