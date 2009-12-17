package Administracion;

import Bd.DBConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Alojamiento;
/**
 * @author Andres Garrido
 * @version 1
 * clase que obtiene todos los servicios activos de hoteleria
 */
public class GetAllHoteleriaService {
	Connection connection;
	PreparedStatement selectAll;
	public GetAllHoteleriaService(){
		//creamos una nueva conexion y preparamos la sentencia para
		//luego ser llamada
		try{    		
			connection=DBConnectionManager.getConnection();
			String query = "SELECT *" +
					"FROM atencionalojamiento";
			selectAll = connection.prepareStatement(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * @author Andres Garrido
	 * @version 1
	 * método que toma todas las filas de alojamiento y las agrupa en una lista
	 * la cual es enviada a flex
	 */
	public List getAllHoteleria(){
		List lista=new ArrayList();
    	Alojamiento hotel;		
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			
    			hotel = new Alojamiento();
    			hotel.setServicio(result.getString(1));
    			hotel.setHora(result.getString(2));
    			hotel.setFechaIngreso(result.getDate(3));
    			hotel.setCosto(result.getString(4));
    			hotel.setResponsable(result.getString(5));
    			hotel.setCliente(result.getString(6));
    			hotel.setMascota(result.getString(7));
    			hotel.setCanil(result.getInt(8));
    			hotel.setFechaSalida(result.getDate(9));
    			hotel.setComentario(result.getString(10));
    			hotel.setDiasEstadia(result.getInt(11));
    			hotel.setEliminado(result.getBoolean(12));
    			lista.add(hotel);
    			
    		}
		} 
    	catch (SQLException e) 
    	{
			System.out.println("Error en GetAllPostOperatorio, detalle: "+e.getMessage());
		}
    	
    	return lista;
		
	}

}
