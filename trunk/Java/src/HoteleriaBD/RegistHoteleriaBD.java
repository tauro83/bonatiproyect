package HoteleriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.Hoteleria;
import TransferObjects.Mascota;

public class RegistHoteleriaBD {
	PreparedStatement selectActivos;
	PreparedStatement consultar;
	PreparedStatement insertar;
	PreparedStatement listarMascotas;
	Connection connection;
	Connection conn;
	
	public RegistHoteleriaBD(Connection connection)
	{
		conn = connection;
		try 
		{
		String query="";
		
		query = "INSERT INTO atencionalojamiento (servicio,hora,fechaingreso,costo,responsable,cliente,mascota,canil,fechasalida, comentario) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";			
		insertar = connection.prepareStatement(query);
		
		query = "SELECT nombre, apaterno,amaterno, rut, telefono, celular, domicilio, region, comuna, correo "+
		"FROM clientepresencial where estado='TRUE';";

	
		selectActivos = connection.prepareStatement(query);
		
		query = "SELECT eliminado "+
		"FROM atencionalojamiento where cliente=? AND mascota=? AND eliminado='FALSE';";

	
		consultar = connection.prepareStatement(query);
		
		
		query = "SELECT nombre "+
		"FROM mascota where rut=? AND atencionalojamiento.cliente !=?;";
		
//		SELECT Nombre_Categoría, NombreProducto
//		FROM Categorias INNER JOIN Productos
//		ON Categorias.IDCategoria = Productos.IDCategoria;

		query = "SELECT DISTINCT nombre " + "FROM mascota INNER JOIN atencionalojamiento ON mascota.rut != atencionalojamiento.cliente AND mascota.rut = ?;";
		
		listarMascotas = connection.prepareStatement(query);

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	
	public int registrarHoteleria(Hoteleria a) throws SQLException
	{
		Calendar c = Calendar.getInstance();
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int minutos = c.get(Calendar.MINUTE);
		//int segundos = c.get(Calendar.SECOND);
		
		String t = hora + ":" + minutos;
		
		int result=0;			
		
		
		insertar.setString(1, a.getServicio());
		insertar.setString(2, t);
		insertar.setDate(3,   a.getFechaIngreso());
		insertar.setString(4, a.getCosto());
		insertar.setString(5, a.getResponsable());
		insertar.setString(6, a.getCliente());
		insertar.setString(7, a.getMascota());
		insertar.setInt(8, a.getCanil());
		insertar.setDate(9, a.getFechaSalida());
		insertar.setString(10, a.getComentario());
		try 
    	{
			result=insertar.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			
		}
    	return result;
	}
	public boolean consultar(String rut, String nombre)throws SQLException
    {
		ResultSet result = null;
		boolean resultado = false;
	try 
    	{
		consultar.setString(1, rut);
		consultar.setString(2, nombre);
		result= consultar.executeQuery();
		resultado = result.getBoolean(1);
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return resultado;
	
}
	
	
		
    	/**
	 *Metodo que obtiene las mascotas de un cliente que no esten en hoteleria
	 * @autor Victor Silva
	 * @param Recibe el rut del cliente y ejecuta la consulta respectiva
	 */
	 public List<Mascota> cargarMascotas(String rut)
	    {
	    	List<Mascota> mascotas=new ArrayList<Mascota>();

	    	try 
	    	{
	    		listarMascotas.setString(1, rut);
//	    		listarMascotas.setString(2, rut);
	    		ResultSet result = listarMascotas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Mascota mas= new Mascota();
	    			
	    			mas.setNombre(result.getString(1));
	    			
	    			mascotas.add(mas);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return mascotas;
	    }
	
}
