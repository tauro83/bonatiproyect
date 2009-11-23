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
import Bd.DBConnectionManager;

public class PostOperatorioService{
	
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
}

