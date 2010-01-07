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
	public String addCliente(Cliente c, String usuario) throws SQLException
	{
		String result = null;
		int r=0;
		PreparedStatement insert;
		PreparedStatement insertSinTeCe;
		PreparedStatement insertSinTe;
		PreparedStatement insertSinCe;
		String query="";		
		
		query = "INSERT INTO clientepresencial (nombre,aPaterno,aMaterno,rut,telefono,celular,domicilio,region,comuna,correo,estado) "+
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); " +
		"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
		"VALUES (?, ?, ?, ?);";	
		insert = connection.prepareStatement(query);
		
		query = "INSERT INTO clientepresencial (nombre,aPaterno,aMaterno,rut,domicilio,region,comuna,correo,estado) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); " +
		"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
		"VALUES (?, ?, ?, ?);";	
		insertSinTeCe = connection.prepareStatement(query);
		
		query = "INSERT INTO clientepresencial (nombre,aPaterno,aMaterno,rut,celular,domicilio,region,comuna,correo,estado) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); " +
		"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
		"VALUES (?, ?, ?, ?);";	
		insertSinTe = connection.prepareStatement(query);
		
		query = "INSERT INTO clientepresencial (nombre,aPaterno,aMaterno,rut,telefono,domicilio,region,comuna,correo,estado) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); " +
		"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
		"VALUES (?, ?, ?, ?);";	
		insertSinCe = connection.prepareStatement(query);
		
		if(!c.telefono.equals("") && !c.telefono2.equals("") && c.celular.equals("") && c.celular2.equals("")){
			insertSinCe.setString(1, c.nombre);
			insertSinCe.setString(2, c.apellido);
			insertSinCe.setString(3, c.apellido2);
			insertSinCe.setString(4, c.rut+c.rut2);
			insertSinCe.setInt(5, Integer.parseInt(c.telefono+c.telefono2));	
			insertSinCe.setString(6, c.direccion);
			insertSinCe.setString(7, c.region);	
			insertSinCe.setString(8, c.comuna);
			insertSinCe.setString(9, c.email);
			insertSinCe.setBoolean(10, c.estado);
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR)-1900;
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			insertSinCe.setString(11, fecha);
			insertSinCe.setString(12, usuario);
			insertSinCe.setString(13, "Administración");
			insertSinCe.setString(14, "Registra cliente: "+c.nombre+" "+c.apellido+" "+c.apellido2);
			r=1;
		}
		
		if(c.telefono.equals("") && c.telefono2.equals("") && !c.celular.equals("") && !c.celular2.equals("")){
			insertSinTe.setString(1, c.nombre);
			insertSinTe.setString(2, c.apellido);
			insertSinTe.setString(3, c.apellido2);
			insertSinTe.setString(4, c.rut+c.rut2);
			insertSinTe.setInt(5, Integer.parseInt(c.celular+c.celular2));
			insertSinTe.setString(6, c.direccion);
			insertSinTe.setString(7, c.region);	
			insertSinTe.setString(8, c.comuna);
			insertSinTe.setString(9, c.email);
			insertSinTe.setBoolean(10, c.estado);
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR)-1900;
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			insertSinTe.setString(11, fecha);
			insertSinTe.setString(12, usuario);
			insertSinTe.setString(13, "Administración");
			insertSinTe.setString(14, "Registra cliente: "+c.nombre+" "+c.apellido+" "+c.apellido2);
			r=2;
		}
		
		if(c.telefono.equals("") && c.telefono2.equals("") && c.celular.equals("") && c.celular2.equals("")){
			insertSinTeCe.setString(1, c.nombre);
			insertSinTeCe.setString(2, c.apellido);
			insertSinTeCe.setString(3, c.apellido2);
			insertSinTeCe.setString(4, c.rut+c.rut2);			
			insertSinTeCe.setString(5, c.direccion);
			insertSinTeCe.setString(6, c.region);	
			insertSinTeCe.setString(7, c.comuna);
			insertSinTeCe.setString(8, c.email);
			insertSinTeCe.setBoolean(9, c.estado);
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR)-1900;
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			insertSinTeCe.setString(10, fecha);
			insertSinTeCe.setString(11, usuario);
			insertSinTeCe.setString(12, "Administración");
			insertSinTeCe.setString(13, "Registra cliente: "+c.nombre+" "+c.apellido+" "+c.apellido2);
			r=3;
		}
		
		if(!c.telefono.equals("") && !c.telefono2.equals("") && !c.celular.equals("") && !c.celular2.equals("")){
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
			insert.setString(13, usuario);
			insert.setString(14, "Administración");
			insert.setString(15, "Registra cliente: "+c.nombre+" "+c.apellido+" "+c.apellido2);
			//insert.setString(14,c.rut2);
			r=4;
		}
		
		
		
		try 
    	{
			if(r==1){
				result=""+insertSinCe.executeUpdate();
				//System.out.println("1");
			}
			
			if(r==2){
				result=""+insertSinTe.executeUpdate();
				//System.out.println("2");
			}
			
			if(r==3){
				result=""+insertSinTeCe.executeUpdate();
				//System.out.println("3");
			}
			
			if(r==4){
				result=""+insert.executeUpdate();
				//System.out.println("4");
			}
			
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

