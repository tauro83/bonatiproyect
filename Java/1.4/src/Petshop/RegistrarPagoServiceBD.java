//=======================================================================
// FECHA CREACI�N: 24/11/09
// AUTOR: Andres Garrido
// Comentarios: Clase capa 3 encargada de registar un aviso web en el sistema
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import TransferObjects.Pago;
/**
 * Clase que ejecuta la inserci�n de un nuevo registro de Aviso Web en la 
 * Base de Datos
 * @author Andres Garrido
 */
public class RegistrarPagoServiceBD {
	PreparedStatement insert;
	PreparedStatement select;
	
	/**
	 * Constructor de la clase que prepara el statement de inserci�n de una nueva tabla
	 * en la base de datos
	 * @author Andres_Garrido
	 * @param connection Conexi�n obtenida con la base de datos
	 */
	public RegistrarPagoServiceBD(Connection connection){
		try{
			//preparando la sentencia SQL
			String query = "INSERT INTO pago(fecha, hora, estado, total) "+
						"VALUES (?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			query = "SELECT nombre, precio, categoria, codigo, descripcion, estado "+
					"FROM producto " +
					"WHERE codigo=? and estado=0;";
			select = connection.prepareStatement(query);
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * M�todo de la capa 3 que ejecuta la sentencia SQL preparada anteriormente
	 * @author Andres_Garrido
	 * @param pago Pago a registrar en el sistema
	 * @return Entero que informa acerca del �xito o fracaso de la operaci�n
	 */
	public int registrarPago(Pago pago){
		int result = 0;//resultado de la ejecuci�n, 0:fracaso, !0:�xito
		
		try{
			insert.setString(1, pago.fecha);
			insert.setString(2, pago.hora);
			insert.setInt(3, 1);
			insert.setInt(4, pago.total);
			
			result= insert.executeUpdate();//ejecuci�n de la sentencia SQL 
											//con los valores modificados
		} 
    	catch (SQLException e){
			e.printStackTrace();//lanza la excepcion cuando el statement 
								//tiene errores de sint�xis
		}
    	return result;
    }  
	public Producto getProducto(String codigo){
		Producto p = new Producto();
		ResultSet result;
		try {
			select.setString(1, codigo);
			result = select.executeQuery();
			p.nombre = result.getString(1).trim();
			p.precio = result.getString(2).trim();
			p.categoria = result.getString(3).trim();
			p.codigo = codigo;
			p.descripcion = result.getString(5);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
}
