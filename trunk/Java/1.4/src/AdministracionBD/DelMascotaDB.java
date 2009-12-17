package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DelMascotaDB {
	PreparedStatement delete;
	Connection connection;
	
	public DelMascotaDB(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "UPDATE mascota "+
		   "SET estado =? "+
			 "WHERE rut=? AND nombre=?; " +
			 "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
			   "VALUES (?, ?, ?, ?);";
		delete = connection.prepareStatement(query);
		
	}

	public int DelMascota(String rut,String nombre,boolean status){
		int x=0;
		try{
			delete.setBoolean(1, status);
			delete.setString(2, rut);
			delete.setString(3, nombre);
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			delete.setString(4, fecha);
			delete.setString(5, "usuario");
			delete.setString(6, "Administración");
			delete.setString(7, "Elimina mascota: "+nombre);
			x= delete.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}
	
}
