package Pabellon;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.httpclient.CircularRedirectException;



import PabellonBD.EditarConsultaBD;
import TransferObjects.Consulta;
import Bd.DBConnectionManager;

public class EditarConsultaService {
	
	public int insertConsulta(Consulta consulta)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarConsultaBD consultaDB= new EditarConsultaBD(connection);
			result= consultaDB.insertConsulta(consulta);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List<Consulta> getAllConsultas()
    {
    	List<Consulta> consultas=new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarConsultaBD consultaDB= new EditarConsultaBD(connection);
			consultas= consultaDB.getAllConsultas();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }
    public Consulta getConsulta(String rut)
    {
    	Consulta co = new Consulta();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarConsultaBD consultaDB= new EditarConsultaBD(connection);
			co= consultaDB.getConsultaDB(rut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return co;
    }

}
