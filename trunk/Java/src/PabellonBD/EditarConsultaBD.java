package PabellonBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.Consulta;

public class EditarConsultaBD 
{
	PreparedStatement insert;
	PreparedStatement deletete;
	PreparedStatement selectAll;
	PreparedStatement selectOne;
	Connection conn;
	String rutillo;
	String rut;
	
	
	public EditarConsultaBD(Connection connection)
	{
		
		conn = connection;
		try 
		{
			
			String query="";
			
			query = "UPDATE consulta"+
			   " SET anamnesis=?, servicio = ?, hora = ?, fecha = ?,costo = ?, rut = ?, nombre = ?, responsable = ? "+
				 "WHERE rut = ? AND servicio = ? AND hora = ? AND fecha = ?;";
			insert = connection.prepareStatement(query);
			
			query = "SELECT anamnesis, servicio, hora, fecha, costo,  rut, nombre, responsable "+
			"FROM consulta "+
			"WHERE rut = ?;";
			selectOne = connection.prepareStatement(query);
			
			query = "SELECT anamnesis, servicio, hora, fecha, costo,  rut, nombre, responsable "+
			"FROM consulta where rut = ?;";

			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	


	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int editarConsulta(Consulta consulta)
    {
    	
    	int result=0;
    	try 
    	{
    		
    		
    		System.out.println(consulta.getAnamnesis()+".");
    		System.out.println(consulta.getRut()+".");
    		
    		

    		insert.setString(1, consulta.getAnamnesis());
    		insert.setString(2, consulta.getServicio());
    		insert.setString(3, consulta.getHora());
    		insert.setString(4, consulta.getFecha());
			insert.setString(5, consulta.getCosto());
    		insert.setString(6, consulta.getRut());
    		insert.setString(7, consulta.getNombre());
			insert.setString(8, consulta.getResponsable());
			insert.setString(9, consulta.getRut());
			insert.setString(10, consulta.getServicio());
			insert.setString(11, consulta.getHora());
			insert.setString(12, consulta.getFecha());
			
			
			result= insert.executeUpdate();
			System.out.println(+result);
			
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List getAllConsultas(String rutCliente)
    {
    	List  consultas=new ArrayList();

    	try 
    	{
    		selectAll.setString(1, rutCliente);
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			  System.out.println("rut: "+rutCliente+".");
    		  
    			  Consulta consulta= new Consulta();
    			  consulta.setAnamnesis(result.getString(1));
    			  consulta.setServicio(result.getString(2));
    			  consulta.setHora(result.getString(3));
    			  consulta.setFecha(result.getString(4));
    			  consulta.setCosto(result.getString(5));
    			  consulta.setRut(result.getString(6));
    			  consulta.setNombre(result.getString(7));
    			  consulta.setResponsable(result.getString(8));
    			  
    			  consultas.add(consulta);
    		
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return consultas;
    }
    
   
}
