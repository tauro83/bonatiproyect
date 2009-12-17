//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestro caso.
//======================================================================


package AdministracionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;


import TransferObjects.Cliente;


public class AddClienteBD {

	Connection connection;
	
	/**
	 * Constructor de la conexion
	 * @param connection es el enlace a la BD
	 */
	
	public AddClienteBD(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * Registra el Cliente en la BD, con sus respectivos datos.
	 * @param c transferobject Cliente
	 */
	public String addCliente(Cliente c) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO clientepresencial (nombre,aPaterno,aMaterno,rut,telefono,celular,domicilio,region,comuna,correo,estado) "+
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); " +
		"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
		"VALUES (?, ?, ?, ?);";	
		insert = connection.prepareStatement(query);
		
		if(c.telefono.equals("") && c.telefono2.equals("")){
			c.telefono="0";
			c.telefono2="0";
		}
		
		if(c.celular.equals("") && c.celular2.equals("")){
			c.celular="0";
			c.celular2="0";
		}
		
		
		insert.setString(1, c.nombre);
		insert.setString(2, c.apellido);
		insert.setString(3, c.apellido2);
		insert.setString(4, c.rut+c.rut2);	
		insert.setInt(5, Integer.parseInt(c.telefono+c.telefono2));		
		insert.setInt(6, Integer.parseInt(c.celular+c.celular2));
		insert.setString(7,c.direccion);
		insert.setString(8,c.region);	
		insert.setString(9,c.comuna);
		insert.setString(10,c.email);
		insert.setBoolean(11,c.estado);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)-1900;
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		Date date = new Date(year,month, day);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fecha = formatter.format(date);
		insert.setString(12, fecha);
		insert.setString(13, "usuario");
		insert.setString(14, "Administración");
		insert.setString(15, "Registra cliente: "+c.nombre+" "+c.apellido+" "+c.apellido2);
		//insert.setString(14,c.rut2);
		
		
		try 
    	{
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+ e.toString(); 
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	
    	if(result.length()>1){
    		return "2";
    	}
    	
    	else {
    		return   "0";  	
		}
	}
	
}

