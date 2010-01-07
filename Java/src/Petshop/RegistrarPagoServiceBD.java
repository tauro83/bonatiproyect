//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Andres Garrido
// Comentarios: Clase capa 3 encargada de registar un aviso web en el sistema
//=======================================================================

package Petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import TransferObjects.Pago;
import TransferObjects.Producto;;
/**
 * Clase que ejecuta la inserción de un nuevo registro de Aviso Web en la 
 * Base de Datos
 * @author Andres Garrido
 */
public class RegistrarPagoServiceBD {
	PreparedStatement select;
	PreparedStatement insert;
	
	public RegistrarPagoServiceBD(Connection connection){
		
		try{	
			String query="";	
			
			query = "SELECT nombre, precio, categoria, codigo, descripcion, estado " +
					"FROM producto " +
					"WHERE codigo = ? ;";

			select = connection.prepareStatement(query);
			
			query = "INSERT INTO pago(fecha, hora, estado, total) " +
		    		"VALUES (?, ?, ?, ?);";
			
			insert = connection.prepareStatement(query);

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Producto getProducto(String codigo){
		Producto p = new Producto();
    	try{
    		select.setString(1, codigo);
    		ResultSet result = select.executeQuery();
			
    		while(result.next()){
        		p.nombre = result.getString(1).trim();
    			p.precio = result.getString(2).trim();
    			p.categoria = result.getString(3).trim();
    			p.codigo = codigo;
    			p.descripcion = result.getString(5);
    		}

		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(p.nombre);
    	return p;
	}
	
	@SuppressWarnings("deprecation")
	public int registrarPago(Pago p){
    	//System.out.println("wiiiiiiiiiiiiiiiiiiii");
		int result=0;
    	try{

			insert.setDate(1, p.fechaPago);
			insert.setTime(2, new Time(System.currentTimeMillis()));
			insert.setInt(3, 0);
			insert.setInt(4, p.total);
			

			result= insert.executeUpdate();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result;
		
	}
	
	
}
