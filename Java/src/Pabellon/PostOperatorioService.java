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
	 * Inserta un registr de postoperatorio en la base de datos
	 * @return Resultado de la operación realizada
	 */
	public int AddPostOpe(PostOperatorio pos)
    {
		int result = 0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD personDB= new PostOperatorioBD(connection);
			result = personDB.AddPostOpeBD(pos);		
			
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
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
		public int anulAtencion(String hora, String rut, String nomMascota, String motivo)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD userDB= new PostOperatorioBD(connection);
			result= userDB.anulAtencionBD(hora, rut, nomMascota, motivo);
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
	public List getAllPostOperatorioAnul()
    {
    	List persons=new ArrayList();
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
	public List getAllPostOperatorio()
    {
    	List persons=new ArrayList();
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
	public List getAllPostOperatorio2(String nombreMascota, String clienterut) {
    	List persons=new ArrayList();
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
	public List getAllPostNull(String nombreMascota, String clienterut)
    {
    	List persons=new ArrayList();
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


	public List getAllVacunacionesV()
    {
		List vacunaciones = new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PostOperatorioBD vacunacionBD= new PostOperatorioBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesV();
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
}

