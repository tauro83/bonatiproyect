package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PurgarMascotaDB {
	PreparedStatement delete;
	Connection connection;
	
	public PurgarMascotaDB(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "DELETE "+
		"FROM mascota WHERE rut=? AND nombre=?; " +
		"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
		"VALUES (?, ?, ?, ?);";

		delete = connection.prepareStatement(query);
		
	}

	public int purgarMascota(String rut,String nombre){
		int x=0;
		try{
			delete.setString(1, rut);
			delete.setString(2, nombre);
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			delete.setString(3, fecha);
			delete.setString(4, "usuario");
			delete.setString(5, "Administración");
			delete.setString(6, "Purga mascota: "+nombre);
			
			x= delete.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

}
