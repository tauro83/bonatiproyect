//=======================================================================
// FECHA CREACIÓN: 15 Septiembre
// AUTOR: Esteban Cruz
// Clase de login del sistema, dentro de esta se puede realizar 
// comprobacion para el login, haciendo el llamado a la funcion 
// correspondiente
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;

import Bd.DBConnectionManager;
import AdministracionBD.LoginBD;

import TransferObjects.Usuario;

public class LoginService
{
	/**
	 *  Obtiene los usuarios existentes en la base de datos, 
	 *  y verifica que el login ingresado sea correcto
	 *  @author  "Esteban Cruz"
	 *  @return 1 si el login ingresado es correcto, de lo 
	 *  contrario 0
	 **/
	public int existLogin(Usuario login){
	    	
	    int result=0;
	    	try
	    	{
	    		Connection connection=DBConnectionManager.getConnection();
				LoginBD LoginBD= new LoginBD(connection);
				result= LoginBD.existLogin(login);
				connection.close();
	    	}
	    	catch (SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return result;
	}
}
