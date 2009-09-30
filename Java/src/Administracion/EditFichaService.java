package Administracion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditDB;
import TransferObjects.Usuario;
import TransferObjects.Mascota2;
import Bd.DBConnectionManager;


public class EditFichaService {
	public Mascota2 masc = new Mascota2();
	
	public int insertFichaE(Mascota2 mascE)
    {
		int result=0;
		
		masc.setDescripcion(mascE.getDescripcion());
		
		
		/*try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditDB personDB= new UsuarioEditDB(connection);
			result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}*/
		return result;
    }

    public Mascota2 getMascotaE()
    {
    		
    	
		return this.masc;
    }
}
