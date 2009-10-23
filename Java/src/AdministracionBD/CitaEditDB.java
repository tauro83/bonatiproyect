package AdministracionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.Cita;

public class CitaEditDB 
{
	PreparedStatement insert;
	PreparedStatement deletete;
	PreparedStatement selectAll;
	PreparedStatement selectOne;
	Connection conn;
	String rutillo;
	
	
	public CitaEditDB(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			query = "UPDATE cita"+
			   " SET rutcliente=?, nombremascota=?, fecha=?, hora=?, servicio=?, responsable=? "+
				 "WHERE rutcliente = ?;";
			insert = connection.prepareStatement(query);
			
			query = "SELECT rutcliente, nombremascota, fecha, hora, servicio, responsable "+
			"FROM cita "+
			"WHERE rutcliente = ?;";
			selectOne = connection.prepareStatement(query);
			
			query = "SELECT rutcliente, nombremascota, fecha, hora, servicio, responsable "+
			"FROM cita;";

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
    public int insertCitaE(Cita person)
    {
    	
    	int result=0;
    	try 
    	{
    		System.out.println(person.getCliente()+".");
    		System.out.println(person.getFecha()+".");
    		System.out.println(person.getHora()+".");
    		System.out.println(person.getMascota()+".");
    		System.out.println(person.getServicio()+".");
    		System.out.println(person.getUsuario()+".");
    		
    		insert.setString(1, person.getCliente());
			insert.setString(2, person.getMascota());
			insert.setString(3, person.getFecha());
			insert.setString(4, person.getHora());
			insert.setString(5, person.getServicio());
			insert.setString(6, person.getUsuario());
			insert.setString(7, person.getCliente());
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List<Cita> getAllCitasE()
    {
    	List<Cita> persons=new ArrayList<Cita>();
    	Cita person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new Cita();
   
    			person.setCliente(result.getString(1));
    			person.setMascota(result.getString(2));
    			person.setFecha(result.getString(3));
    			person.setHora(result.getString(4));
    			person.setServicio(result.getString(5));
    			person.setUsuario(result.getString(6));
    			

    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
    
    public Cita getCitaDB(String rutnew)
    {
    	Cita person = new Cita();
    	try 
    	{   
    		
    		selectOne.setString(1, rutnew);
    		ResultSet result = selectOne.executeQuery();
    		while(result.next())
    		{
    			person.setCliente(result.getString(1));
    			person.setMascota(result.getString(2));
    			person.setFecha(result.getString(3));
    			person.setHora(result.getString(4));
    			person.setServicio(result.getString(5));
    			person.setUsuario(result.getString(6));
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return person;
    }
}
