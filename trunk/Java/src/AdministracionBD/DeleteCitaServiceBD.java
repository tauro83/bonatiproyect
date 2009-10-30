package AdministracionBD;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCitaServiceBD {
	PreparedStatement deleteCita;
	Connection connection;
	
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
