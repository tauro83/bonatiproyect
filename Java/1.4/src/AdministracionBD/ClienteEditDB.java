package AdministracionBD;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import Bd.DBConnectionManager;
import TransferObjects.Cliente;

public class ClienteEditDB 
{
	PreparedStatement insert;
	PreparedStatement deletete;
	PreparedStatement selectAll;
	Connection conn;
	String rutillo;
	
	
	public ClienteEditDB(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			query = "UPDATE clientepresencial "+
			   "SET nombre = ?, aPaterno = ?, aMaterno = ?, rut = ?, telefono = ?, celular = ?, domicilio = ?, region = ?, comuna = ?, correo = ?, estado = ? "+
				 " WHERE rut = ?; "+
				 "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
				"VALUES (?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			query = "SELECT nombre,aPaterno,aMaterno,rut,telefono,celular,domicilio,region,comuna,correo,estado "+
			"FROM clientepresencial;";

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
    public int insertClienteE(Cliente person, String rutillo)
    {
    	int result=0;
    	try 
    	{
    		System.out.println(person.nombre);
    		System.out.println(person.email);
    		insert.setString(1, person.getNombre());
			insert.setString(2, person.getApellido());
			insert.setString(3, person.getApellido2());
			insert.setString(4, person.getRut());
			insert.setInt(5, Integer.parseInt(person.telefono));	
			insert.setInt(6, Integer.parseInt(person.celular));	
			insert.setString(7, person.getDireccion());
			insert.setString(8, person.getRegion());
			insert.setString(9, person.getComuna());
			insert.setString(10, person.getEmail());
			insert.setBoolean(11, person.estado);
			insert.setString(12, rutillo);
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR)-1900;
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			insert.setString(13, fecha);
			insert.setString(14, "usuario");
			insert.setString(15, "Administración");
			insert.setString(16, "Edita cliente: "+person.nombre+" "+person.getApellido()+" "+person.getApellido2());
    		
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List getAllClientesE()
    {
    	List persons=new ArrayList();
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
    			person.setTelefono(result.getString(5));
    			person.setCelular(result.getString(6));
    			person.setDireccion(result.getString(7));
    			person.setRegion(result.getString(8));
    			person.setComuna(result.getString(9));
    			person.setEmail(result.getString(10));
 			    
    			

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
