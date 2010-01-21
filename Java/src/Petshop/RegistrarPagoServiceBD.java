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
import TransferObjects.Producto;
import TransferObjects.DetallePago;
/**
 * Clase que ejecuta la inserción de un nuevo registro de Aviso Web en la 
 * Base de Datos
 * @author Andres Garrido
 */
public class RegistrarPagoServiceBD {
	PreparedStatement select;
	PreparedStatement insert;
	PreparedStatement insertdetalle;
	
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
			
			query = "INSERT INTO detallepago(fecha, hora, codigoproducto, cantidad, subtotal) " +
		    		"VALUES (?, ?, ?, ?, ?);";
			
			insertdetalle = connection.prepareStatement(query);;


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
    	return p;
	}
	
	@SuppressWarnings("deprecation")
	public int registrarPago(Pago p){
    	//System.out.println("wiiiiiiiiiiiiiiiiiiii");
		int result=0;
    	try{

    		//Time t = new Time(System.currentTimeMillis());
    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		Time t = new Time(hora, minutos, segundos);
			insert.setDate(1, p.fechaPago);
			insert.setTime(2, t);
			insert.setInt(3, 0);
			insert.setInt(4, p.total);
			
			/*for(int i = 0; i < p.detalle.size(); i++){
				DetallePago dp = (DetallePago)p.detalle.get(i);
				if(dp != null){
					insertdetalle.setDate(1, p.fechaPago);
					insertdetalle.setTime(2, t);
					insertdetalle.setInt(3, dp.cantidad);
					insertdetalle.setInt(4, dp.subtotal);
				}

			}*/

			result= insert.executeUpdate();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result;
		
	}
	
	
}
