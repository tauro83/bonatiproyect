package AdministracionBD;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCitaServiceBD {
	PreparedStatement deleteCita;
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
					"WHERE rutcliente = ?;";
			deleteCita = connection.prepareStatement(query);

			
			
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

	public int purgarCita(String cliente){
		System.out.println(cliente);
		int result=0;
    	try 
    	{
    		deleteCita.setString(1, cliente);
			deleteCita.executeQuery();
			result= deleteCita.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
		
	}

}
