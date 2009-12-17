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
		
	/**
	 * @autor: Raúl López
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @param Connection, que permite conectarse con la base de datos.
	 * @return void. Solo captura algun error si es que hubiera en la base de datos.
	 */
	public CitaEditDB(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			System.out.println("Entro a editar la CITA");
			query = "UPDATE cita"+
			   " SET rutcliente = ?, nombremascota = ?, fecha =?, hora = ?,servicio = ?, responsable = ? "+
				 "WHERE fecha = ? AND hora = ? AND servicio = ? AND responsable = ?;";
			insert = connection.prepareStatement(query);
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @autor: Raúl López
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @param Connection, que permite conectarse con la base de datos, String que corresponde al rut del cliente que se quiere encontrar
	 * @return void. Solo captura algun error si es que hubiera en la base de datos.
	 */
	
	/*
	public CitaEditDB(Connection connection, String rut)
	{
		this.rut= rut;
		//this.hora=hora;
		//this.servicio=servicio;
		//this.responsable= responsable;
		conn = connection;
		try 
		{		
			String query = "UPDATE cita " +
			"SET rutcliente = ?, nombremascota = ?, fecha = ?, hora = ?, servicio = ?, responsable = ? " +
		    "WHERE rutcliente = "+rut+";";
			 insert = connection.prepareStatement(query);
			 //rutcliente = "+rut+";";
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	*/

	/**@autor: Raúl López
	 * Ingresa a una nuevacita a la base de datos
	 * @param person contiene los datos de la cita que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int insertCitaE(Cita person, String fech, String hor, String servi, String respon)
    {
    	
    	int result=0;
    	try 
    	{
    		/*
    		System.out.println(person.getCliente()+".");
    		System.out.println(person.getFecha()+".");
    		System.out.println(person.getHora()+".");
    		*/
    		
    		System.out.println(fech);
    		System.out.println(hor);
    		System.out.println(servi);
    		System.out.println(respon);
    		
    		insert.setString(1, person.getCliente());
			insert.setString(2, person.getMascota());
			insert.setString(3, person.getFecha());
			insert.setString(4, person.getHora());
			insert.setString(5, person.getServicio());
			insert.setString(6, person.getUsuario());
			
			insert.setString(7, fech);
			insert.setString(8, hor);
			insert.setString(9, servi);
			insert.setString(10, respon);
			
			
			result = insert.executeUpdate();
			
			System.out.println(+result);
			
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**@autor: Raúl López
	 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
	 * con los datos de cada usuario en el sistema.
	 * @param 
	 * @return Una lista de objetos de la clase Cita.
	 */
    public List getAllCitasE()
    {
    	List persons=new ArrayList();
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
    
	/**@autor: Raúl López
	 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
	 * con los datos de cada usuario en el sistema.
	 * @param 
	 * @return Un objeto de clase Cita.
	 */
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
