//=======================================================================
// FECHA CREACIÓN: 15/09/09
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
	
	public boolean pRegistrar(Usuario login){
		boolean registrar=false;
    	try
    	{
    		Connection connection=DBConnectionManager.getConnection();
			LoginBD LoginBD= new LoginBD(connection);
			registrar = LoginBD.pRegistrar(login);
			connection.close();
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return registrar;
	}
	
	public boolean pEditar(Usuario login){
		boolean editar=false;
    	try
    	{
    		Connection connection=DBConnectionManager.getConnection();
			LoginBD LoginBD= new LoginBD(connection);
			editar = LoginBD.pEditar(login);
			connection.close();
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return editar;
	}
	
	public boolean pEliminar(Usuario login){
		boolean eliminar=false;
    	try
    	{
    		Connection connection=DBConnectionManager.getConnection();
			LoginBD LoginBD= new LoginBD(connection);
			eliminar = LoginBD.pEliminar(login);
			connection.close();
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return eliminar;
	}
	
	public boolean pPurgar(Usuario login){
		boolean purgar=false;
    	try
    	{
    		Connection connection=DBConnectionManager.getConnection();
			LoginBD LoginBD= new LoginBD(connection);
			purgar = LoginBD.pPurgar(login);
			connection.close();
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return purgar;
	}
}
