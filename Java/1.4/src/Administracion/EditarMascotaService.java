//=======================================================================
// FECHA CREACIÓN: 12/09/09

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.CircularRedirectException;


import AdministracionBD.MascotaEditDB;
import TransferObjects.Mascota;
import Bd.DBConnectionManager;

public class EditarMascotaService {
	
	/**
	 * @autor Cristian BRavo
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Mascota contiene los datos de la mascota que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	
	public int insertMascotaE(Mascota person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MascotaEditDB personDB= new MascotaEditDB(connection);
			result= personDB.insertMascotaE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }

	/**
	 * Autor: Cristian Bravo
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada mascota.
	 * @param
	 * @return Lista con objetos de la clase Mascota
	 */
	
    public List getAllMascotasE()
    {
    	List persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MascotaEditDB personDB= new MascotaEditDB(connection);
			//persons= personDB.getAllMascotasE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persons;
    }
    public Mascota getMascota(String rut)
    {
    	Mascota mas = new Mascota();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MascotaEditDB personDB= new MascotaEditDB(connection);
			//mas= personDB.getMascotaDB(rut);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return mas;
    }

}
