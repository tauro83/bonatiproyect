package AdministracionBD;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCitaServiceBD {
	PreparedStatement deleteCita, elimBloqueados;
	Connection connection;
	
	/**
	 * @autor: Raúl López
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @param Connection, que permite conectarse con la base de datos.
	 * @return void. Solo captura algun error si es que hubiera en la base de datos.
	 */
	public DeleteCitaServiceBD(Connection connection) throws SQLException{
		
		try 
		{
			
			String query="";
			query = "DELETE FROM cita " +
			"WHERE fecha = ? AND hora = ? AND servicio = ? AND responsable = ?;";
			
			deleteCita = connection.prepareStatement(query);
			
			query = "DELETE FROM horasBloqueadas " +
			"WHERE fecha = ? AND hora = ? AND servicio = ? AND responsable = ?;";
			elimBloqueados = connection.prepareStatement(query);

			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	/**@autor: Raúl López
	 * Elimina a una nueva persona a la base de datos
	 * @param String cliente contiene el rut el cual corresponderá a la cita que se valla a eliminar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */

	public int purgarCita(String fecha, String hora, String servicio, String responsable){
		
		int result=0;
    	try 
    	{
    		if(servicio.equals("No Disponible")){
    			elimBloqueados.setString(1, fecha);
    			elimBloqueados.setString(2, hora);
    			elimBloqueados.setString(3, servicio);
    			elimBloqueados.setString(4, responsable);
    			
    			elimBloqueados.executeQuery();
    			
    			result = elimBloqueados.executeUpdate();
    		}
    		else{
	    		deleteCita.setString(1, fecha);
	    		deleteCita.setString(2, hora);
	    		deleteCita.setString(3, servicio);
	    		deleteCita.setString(4, responsable);
	    		
				deleteCita.executeQuery();
				
				result= deleteCita.executeUpdate();
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
		
	}

}
