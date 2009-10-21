package Administracion;

import Bd.DBConnectionManager;
import Clinica.PreOperatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;
import TransferObjects.PostOperatorio;

public class GetAllPostOperatorio {
	Connection connection;
	PreparedStatement selectAll;
	public GetAllPostOperatorio(){
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
	public List<PostOperatorio> getAllPostOperatorio(){
		List<PostOperatorio> lista=new ArrayList<PostOperatorio>();
    	PostOperatorio post;		
    	String hora,fecha,costo;
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			hora = result.getString(5);
    			fecha = result.getString(6);
    			costo = result.getString(7);
    			post = new PostOperatorio(hora, fecha, costo);
    			post.setMedicamentos(result.getString(1));
    			post.setAlimentos(result.getString(2));
    			post.setIndicaciones(result.getString(3));
    			post.setServicio(result.getString(4));
    			post.setNombreMascota(result.getString(8));
    			post.setRut(result.getString(9));
    			post.setApellidoDueño(result.getString(10));
    			post.setNombreDueño(result.getString(11));
    			lista.add(post);
    			
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return lista;
		
	}

}
