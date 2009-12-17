//=======================================================================
// FECHA CREACI�N: 12/09/09

package AdministracionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


import Bd.DBConnectionManager;
import TransferObjects.Mascota;

public class MascotaEditDB 
{
	PreparedStatement insert;
	Connection conn;
	String rutillo;
	
	/**
	 * Autor: Cristian Bravo
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @param Connection, que permite conectarse con la base de datos.
	 * @return void. Solo captura algun error si es que hubiera en la base de datos.
	 */
	
	public MascotaEditDB(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			query = "UPDATE mascota"+
			   " SET rut=?, nombre=?, fechanacimiento=?, claseanimal=?, raza=?, sexo=? "+
				 "WHERE rut = ? AND nombre = ?; " +
				 "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
			   "VALUES (?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Autor: Cristian Bravo
	 * Ingresa a una nueva mascota a la base de datos
	 * @param person contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserci�n ha fallado
	 */
    public int insertMascotaE(Mascota person)
    {
    	
    	int result=0;
    	try 
    	{
    		System.out.println(person.getRutCliente()+".");
    		System.out.println(person.getNombre()+".");
    		System.out.println(person.getFechaNacimiento()+".");
    		System.out.println(person.getClaseAnimal()+".");
    		System.out.println(person.getRaza()+".");
    		System.out.println(person.getSexo()+".");
    		
    		
    		insert.setString(1, person.getRutCliente().trim());
			insert.setString(2, person.getNombre().trim());
			insert.setString(3, person.getFechaNacimiento().trim());
			insert.setString(4, person.getClaseAnimal().trim());
			insert.setString(5, person.getRaza().trim());
			insert.setString(6, person.getSexo().trim());
			insert.setString(7, person.getRutCliente().trim());
			insert.setString(8, person.getNombre().trim());
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			insert.setString(9, fecha);
			insert.setString(10, "usuario");
			insert.setString(11, "Administraci�n");
			insert.setString(12, "Edita mascota: "+person.getNombre()+" especie: "+person.getClaseAnimal());
		
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }

}