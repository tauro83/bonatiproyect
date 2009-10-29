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
	
	
	public EditarConsultaBD(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			query = "UPDATE consulta"+
			   " SET rut=?, responsable=?, servicio=?, fecha=?,hora=?, costo=?, anamnesis=? "+
				 "WHERE rut = ?;";
			insert = connection.prepareStatement(query);
			
			query = "SELECT rut, responsable, servicio, fecha, hora,  costo, anamnesis "+
			"FROM consulta "+
			"WHERE rut = ?;";
			selectOne = connection.prepareStatement(query);
			
			query = "SELECT rut, responsable, servicio, fecha, hora, costo, anamnesis "+
			"FROM consulta;";

			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/*
	public CitaEditDB(Connection connection)
	{
		conn = connection;
		try 
		{		
			String query="";
			query = "SELECT rutcliente, nombremascota, fecha, hora, servicio, responsable "+
			"FROM cita;";

			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	*/

	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int insertConsulta(Consulta consulta)
    {
    	
    	int result=0;
    	try 
    	{
    		/*
    		System.out.println(person.getCliente()+".");
    		System.out.println(person.getFecha()+".");
    		System.out.println(person.getHora()+".");
    		System.out.println(person.getMascota()+".");
    		System.out.println(person.getServicio()+".");
    		System.out.println(person.getUsuario()+".");
    		*/
    		insert.setString(1, consulta.getRut());
			insert.setString(2, consulta.getResponsable());
			insert.setString(3, consulta.getServicio());
			insert.setString(4, consulta.getFecha());
			insert.setString(5, consulta.getHora());
			insert.setString(6, consulta.getCosto());
			insert.setString(7, consulta.getAnamnesis());
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List<Consulta> getAllConsultas()
    {
    	List<Consulta> consultas=new ArrayList<Consulta>();
    	Consulta consulta;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			consulta= new Consulta();
   
    			consulta.setRut(result.getString(1));
    			consulta.setResponsable(result.getString(2));
    			consulta.setServicio(result.getString(3));
    			consulta.setFecha(result.getString(4));
    			consulta.setHora(result.getString(5));
    			consulta.setCosto(result.getString(6));
    			consulta.setAnamnesis(result.getString(7));
    			

    			consultas.add(consulta);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return consultas;
    }
    
    public Consulta getConsultaDB(String rutnew)
    {
    	Consulta consulta = new Consulta();
    	try 
    	{   
    		
    		selectOne.setString(1, rutnew);
    		ResultSet result = selectOne.executeQuery();
    		while(result.next())
    		{
    			consulta.setRut(result.getString(1));
    			consulta.setResponsable(result.getString(2));
    			consulta.setServicio(result.getString(3));
    			consulta.setFecha(result.getString(4));
    			consulta.setHora(result.getString(5));
    			consulta.setCosto(result.getString(6));
    			consulta.setAnamnesis(result.getString(7));
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return consulta;
    }
}
