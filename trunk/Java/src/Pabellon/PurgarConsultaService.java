package Pabellon;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Bd.DBConnectionManager;
import PabellonBD.PurgarConsultaBD;
import TransferObjects.Cliente;
import TransferObjects.Consulta;;



public class PurgarConsultaService {
	Connection connection;
	
	/**
	 *Metodo que anula una determinada consulta 
	 * @autor Victor Silva
	 * @param Recibe las claver primarias de la consulta y las envia al metodo anularConsulta de
	 * la clase PurgarConsultaBD
	 */
	public int anularConsulta(String hora, String fecha, String servicio){
		int result=0;
    	try{
    		connection=DBConnectionManager.getConnection();
    		PurgarConsultaBD object= new PurgarConsultaBD(connection);
			result	= object.anularConsulta(hora,fecha,servicio);
			connection.close();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return result;
	}
	
	/**
	 *Metodo que Retorna todas las consultas activas de un determinado
	 *cliente que se encuentra en la BD
	 * @autor Victor Silva
	 * @param Recibe el rut del cliente y retorna el listado de consultas de este
	 */
	public List<Consulta> cargarConsultas(String rut)
    {
		List<Consulta> consultas = new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			consultas = consuBD.cargarConsultas(rut);	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }

	/**
	 *Metodo que Retorna todas las consultas nulas de un determinado
	 *cliente que se encuentra en la BD
	 * @autor Victor Silva
	 * @param Recibe el rut del cliente y retorna el listado de consultas de este
	 */
	public List<Consulta> cargarConsultasNulas(String rut)
    {
		List<Consulta> consultas = new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			consultas = consuBD.cargarConsultasNulas(rut);	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }
	
	/**
	 *Metodo que Retorna todas las consultas de un determinado
	 *cliente que se encuentra en la BD, esto lo realiza independientemente si esta activa o inactiva
	 * @autor Victor Silva
	 * @param Recibe el rut del cliente y retorna el listado de consultas de este
	 */
	
	public List<Consulta> cargarConsultasTodas(String rut)
    {
		List<Consulta> consultas = new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			consultas = consuBD.cargarConsultasTodas(rut);	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }
	
	
	/**
	 *Metodo que Retorna todas las consultas activas que se encuentra en la BD
	 * @autor Victor Silva
	 * @param ninguno
	 */
	public List<Consulta> cargarTodasActivas()
    {
		List<Consulta> consultas = new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			consultas = consuBD.cargarTodasActivas();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }

	/**
	 *Metodo que Retorna todas las consultas que se encuentra en la BD
	 *independiente si estan activas o no
	 * @autor Victor Silva
	 * @param ninguno
	 */
	public List<Consulta> cargarTodas()
    {
		List<Consulta> consultas = new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			consultas = consuBD.cargarTodas();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }
	
	
	/**
	 *Metodo que Retorna todas las consultas nulas que se encuentra en la BD
	 *independiente si estan activas o no
	 * @autor Victor Silva
	 * @param ninguno
	 */
	
	public List<Consulta> cargarTodasNulas()
    {
		List<Consulta> consultas = new ArrayList<Consulta>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			consultas = consuBD.cargarTodasNulas();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return consultas;
    }

    public String consultarCliente(String rut){
    	String nombre = new String();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			PurgarConsultaBD consuBD= new PurgarConsultaBD(connection);
			nombre = consuBD.ConsultarCliente(rut);	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return nombre;
    }
	
}
