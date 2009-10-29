package AdministracionBD;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCitaServiceBD {
	PreparedStatement delete;
	Connection connection;
	//int x=0;
	public DeleteCitaServiceBD(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "DELETE FROM cita"+
		"WHERE rutcliente = ?" + " AND hora = ?;";

		delete = connection.prepareStatement(query);
		
	}


	public int purgarCita(String cliente,String hora){
		System.out.println(cliente);
		System.out.println(hora);
		int x=0;
		try{
			delete.setString(1, cliente);
			delete.setString(2, hora);
			delete.executeQuery();
			x= delete.executeUpdate();
			System.out.println("No entra al Try");
		} 
    	catch (SQLException e) 
    	{
    		System.out.println("Si entra al catch");
			e.printStackTrace();
		}
		return x;
		
	}

}
