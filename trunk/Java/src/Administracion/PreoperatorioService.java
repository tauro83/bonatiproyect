package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.PreoperatorioBD;
import Bd.DBConnectionManager;
import TransferObjects.Preoperatorio;;


public class PreoperatorioService {
	
    public List<Preoperatorio> getAllDatos()
    {
    	List<Preoperatorio> atencionPre=new ArrayList<Preoperatorio>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PreoperatorioBD atencionPreoDB= new PreoperatorioBD(connection);
			atencionPre= atencionPreoDB.getAllDatos();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return atencionPre;
    }
}
