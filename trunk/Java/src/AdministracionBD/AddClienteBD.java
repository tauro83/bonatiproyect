//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestro caso.
//======================================================================


package AdministracionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public int consultarCli(Cliente c) throws SQLException{
		
		int result = 0;
		ResultSet cliente; 
		PreparedStatement select;
		String query="";
		query = "SELECT rut "+
				"FROM clientepresencial "+
				"WHERE rut = ? ;";
		select = connection.prepareStatement(query);
		select.setString(1, c.rut+c.rut2);
		try 
    	{
			int val=0;
			cliente = select.executeQuery();
			while(cliente.next())
	    	{
				val++;
	    	}
			if(val<2){
				result=1;
			}
    	}
		catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
	}
	
	
	/**
	 * Registra el Cliente en la BD, con sus respectivos datos.
	 * @param c transferobject Cliente
	 */
	public String addCliente(Cliente c, String usuario) throws SQLException
	{
		
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO clientepresencial( rut, telefono, celular, nombre, apaterno, amaterno, correo, estado, Domicilio, comuna, region) "+ 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); " + "INSERT INTO bitacora2(fecha, usuario, servicio, accion) VALUES (?, ?, ?, ?);";	
		insert = connection.prepareStatement(query);
		
		insert.setString(1, c.rut+c.rut2);
		if(c.telefono.trim().equals("")){
			insert.setNull(2, 0);
		}else{
			insert.setInt(2,Integer.parseInt(c.telefono+c.telefono2));
		}
		if(c.celular.trim().equals("")){
			insert.setNull(3, 0);
		}else{
			insert.setInt(3,Integer.parseInt(c.celular+c.celular2));
		}
		insert.setString(4, c.nombre);
		insert.setString(5, c.apellido);
		insert.setString(6, c.apellido2);
		insert.setString(7, c.email);
		insert.setBoolean(8, c.estado);
		insert.setString(9, c.direccion);
		insert.setString(10, c.comuna);
		insert.setString(11, c.region);
		/*Bitacora*/
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)-1900;
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		Date date = new Date(year,month, day);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fecha = formatter.format(date);
		insert.setString(12, fecha);
		insert.setString(13, usuario);
		insert.setString(14, "Administración");
		insert.setString(15, "Registra cliente: "+c.nombre+" "+c.apellido+" "+c.apellido2);

		
		
		try 
    	{
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+e.toString(); 
			
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
    	
    }
	
}

