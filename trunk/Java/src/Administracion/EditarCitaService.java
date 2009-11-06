package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.CircularRedirectException;


import AdministracionBD.CitaEditDB;
import TransferObjects.Cita;
import Bd.DBConnectionManager;


	/**
	 * @autor Raul Lopez
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Cita contiene los datos de la cita que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
public class EditarCitaService {
	
	public int insertCitaE(Cita person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			CitaEditDB personDB= new CitaEditDB(connection, person.cliente);
			//,person.cliente
			result= personDB.insertCitaE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

	/**
	 * @autor: Raul Lopez
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada Cita.
	 * @param
	 * @return Lista con objetos de la clase Cita
	 */
    public List<Cita> getAllCitasE()
    {
    	List<Cita> persons=new ArrayList<Cita>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			CitaEditDB personDB= new CitaEditDB(connection);
			persons= personDB.getAllCitasE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
	
	/**
	 * @autor: Raul Lopez
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada usuario.
	 * @param String que corresponde al rut del cliente
	 * @return Objeto de clase Cita
	 */
    public Cita getCita(String rut)
    {
    	Cita ci = new Cita();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			CitaEditDB personDB= new CitaEditDB(connection);
			ci= personDB.getCitaDB(rut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return ci;
    }

}
