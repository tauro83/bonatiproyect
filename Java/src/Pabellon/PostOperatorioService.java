//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz
// Comentarios: Encargada de enviar y recibir datos entre la interfaz
//				y la capa lógica
//=======================================================================

package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.PostOperatorio;
import PabellonBD.PostOperatorioBD;
import AdministracionBD.UsuarioElimBD;
import Bd.DBConnectionManager;

public class PostOperatorioService{
	
	/**
	 * Elimina un registro en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public int elimAtencion(String hora, String rut, String nomMascota)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD userDB= new PostOperatorioBD(connection);
			result= userDB.elimAtencionBD(hora, rut, nomMascota);
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	/**
	 * Elimina un registro en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public int anulAtencion(String hora, String rut, String nomMascota)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD userDB= new PostOperatorioBD(connection);
			result= userDB.anulAtencionBD(hora, rut, nomMascota);
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	/**
	 * Trata de obtener todos los usuarios registrados en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public List<PostOperatorio> getAllPostOperatorioAnul()
    {
    	List<PostOperatorio> persons=new ArrayList<PostOperatorio>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD personDB= new PostOperatorioBD(connection);
			persons= personDB.getAllPostOperatorioAnulBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	
	/**
	 * Trata de obtener todos los usuarios registrados en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public List<PostOperatorio> getAllPostOperatorio()
    {
    	List<PostOperatorio> persons=new ArrayList<PostOperatorio>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD personDB= new PostOperatorioBD(connection);
			persons= personDB.getAllPostOperatorioBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	/**
	 * Trata de obtener todos los usuarios registrados en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public List<PostOperatorio> getAllPostOperatorio2(String nombreMascota, String clienterut)
    {
    	List<PostOperatorio> persons=new ArrayList<PostOperatorio>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD personDB= new PostOperatorioBD(connection);
			persons= personDB.getAllPostOperatorio2BD(nombreMascota,clienterut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	/**
	 * Trata de obtener todos los usuarios registrados en la base de datos
	 * @return Lista con todos los usuarios registrados
	 */
	public List<PostOperatorio> getAllPostNull(String nombreMascota, String clienterut)
    {
    	List<PostOperatorio> persons=new ArrayList<PostOperatorio>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD personDB= new PostOperatorioBD(connection);
			persons= personDB.getAllPostNullBD(nombreMascota,clienterut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
}

