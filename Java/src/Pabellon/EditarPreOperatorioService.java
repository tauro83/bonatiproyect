package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Preoperatorio;
import Bd.DBConnectionManager;
import PabellonBD.EditarPreOperatorioBD;

public class EditarPreOperatorioService {
	Connection connection;

	public int editarPreOperatorio(Preoperatorio preo, String rut, String fecha, String hora){
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarPreOperatorioBD pOBD= new EditarPreOperatorioBD(connection);
			result= pOBD.editarPreOperatorio(preo, rut,fecha,hora);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public List<Preoperatorio> cargarPreO(String rut)
    {
		List<Preoperatorio> preoperatorios = new ArrayList<Preoperatorio>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarPreOperatorioBD preoBD= new EditarPreOperatorioBD(connection);
			preoperatorios = preoBD.cargarPreO(rut);	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return preoperatorios;
    }
	
}
