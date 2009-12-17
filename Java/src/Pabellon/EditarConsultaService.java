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
	
	public int editarConsulta(Consulta consulta)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarConsultaBD consultaDB= new EditarConsultaBD(connection);//,consulta.getRut()
			result= consultaDB.editarConsulta(consulta);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

    public List getAllConsultas(String rutCliente)
    {
    	List consultas=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarConsultaBD consultaDB= new EditarConsultaBD(connection);
			consultas= consultaDB.getAllConsultas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }
    
    
   

}
