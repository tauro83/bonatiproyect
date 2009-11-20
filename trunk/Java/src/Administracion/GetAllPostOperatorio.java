package Administracion;

import Bd.DBConnectionManager;
import Pabellon.AddPreOperatorioService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;
import TransferObjects.PostOperatorio;
/**
 * @author Andres Garrido
 * @version 1
 * clase que obtiene todas las filas existentes en Post Operatorio
 */
public class GetAllPostOperatorio {
	Connection connection;
	PreparedStatement selectAll;
	public GetAllPostOperatorio(){
		//creamos una nueva conexion y preparamos la sentencia para
		//luego ser llamada
		try{    		
			connection=DBConnectionManager.getConnection();
			String query = "SELECT *" +
					"FROM atencionpostoperatorio";
			selectAll = connection.prepareStatement(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * @author Andres Garrido
	 * @version 1
	 * método que toma todas las filas de post operatorio y las agrupa en una lista
	 * la cual es enviada a flex
	 */
	public List<PostOperatorio> getAllPostOperatorio(){
		List<PostOperatorio> lista=new ArrayList<PostOperatorio>();
    	PostOperatorio post;		
    	String hora,costo;
		Date fecha;
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			hora = result.getString(5).trim();
    			fecha = result.getDate(6);
    			costo = result.getString(7).trim();
    			post = new PostOperatorio(hora, fecha, costo);
    			post.setMedicamentos(result.getString(1).trim());
    			post.setAlimentos(result.getString(2).trim());
    			post.setIndicaciones(result.getString(3).trim());
    			post.setServicio(result.getString(4).trim());
    			post.setNombreMascota(result.getString(8).trim());
    			post.setRut(result.getString(9));
    			post.setApellidoDueño(result.getString(10).trim());
    			post.setNombreDueño(result.getString(11).trim());
    			lista.add(post);
    			
    		}
    		connection.close();
		} 
    	catch (SQLException e) 
    	{
			System.out.println("Error en GetAllPostOperatorio, detalle: "+e.getMessage());
		}
    	
    	return lista;
		
	}

}
