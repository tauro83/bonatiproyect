package AdministracionBD;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.Cliente;

public class ClienteEditDB 
{
	PreparedStatement insert;
	PreparedStatement deletete;
	PreparedStatement selectAll;
	Connection conn;
	String rutillo;
	
	
	public ClienteEditDB(Connection connection, String rutillo)
	{
		this.rutillo=rutillo;
		conn = connection;
		try 
		{
			String query="";
			
			query = "UPDATE clientepresencial "+
			   "SET nombre=?, apellido=?, apellido2=?, rut=?, rut2=?, telefono=?, telefono2=?, celular=?, celular2=?, direccion=?, region=? ,comuna=?, email=?, email2=? "+
				 " WHERE rut="+rutillo+";";
			insert = connection.prepareStatement(query);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ClienteEditDB(Connection connection)
	{
		conn = connection;
		try 
		{		
			String query="";
			query = "SELECT nombre, apellido, apellido2, rut, rut2, telefono, telefono2, celular, celular2, direccion, region,comuna,email, email2 "+
			"FROM Cliente;";

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
    public int insertClienteE(Cliente person)
    {
    	int result=0;
    	try 
    	{
    		
    		insert.setString(1, person.getNombre());
			insert.setString(2, person.getApellido());
			insert.setString(3, person.getApellido2());
			insert.setString(4, person.getRut());
			insert.setString(5, person.getRut2());
			insert.setString(6, person.getTelefono());
			insert.setString(7, person.getTelefono2());
			insert.setString(8, person.getCelular());
			insert.setString(9, person.getCelular2());
			insert.setString(10, person.getDireccion());
			insert.setString(11, person.getRegion());
			insert.setString(12, person.getComuna());
			insert.setString(13, person.getEmail());
			insert.setString(14, person.getEmail2());
			
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List<Cliente> getAllClientesE()
    {
    	List<Cliente> persons=new ArrayList<Cliente>();
    	Cliente person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new Cliente();
   
    			person.setNombre(result.getString(1));
    			person.setApellido(result.getString(2));
    			person.setApellido2(result.getString(3));
    			person.setRut(result.getString(4));
    			person.setRut2(result.getString(5));
    			person.setTelefono(result.getString(6));
    			person.setTelefono2(result.getString(7));
    			person.setCelular(result.getString(8));
    			person.setCelular2(result.getString(9));
    			person.setDireccion(result.getString(10));
    			person.setRegion(result.getString(11));
    			person.setComuna(result.getString(12));
    			person.setEmail(result.getString(13));
 			    person.setEmail2(result.getString(14));
    			

    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
}
