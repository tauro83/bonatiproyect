package Peluqueria;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.httpclient.CircularRedirectException;



import PeluqueriaBD.EditarPeluServiceBD;
import TransferObjects.Peluqueria;
import Bd.DBConnectionManager;

public class EditarPeluService {
	
	public int editarPeluqueria(Peluqueria pelu)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarPeluServiceBD peluqueriaDB= new EditarPeluServiceBD(connection);//,consulta.getRut()
			result= peluqueriaDB.editarPeluqueria(pelu);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List<Peluqueria> getAllPeluquerias(String rutCliente, String nombreMascota)
    {
    	List<Peluqueria> peluquerias =new ArrayList<Peluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarPeluServiceBD peluqueriaDB= new EditarPeluServiceBD(connection);
			peluquerias = peluqueriaDB.getAllPeluquerias(rutCliente, nombreMascota);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return peluquerias;
    }
    
    
    
    
   

}
