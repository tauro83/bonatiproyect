package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.Consulta;

public class PurgarConsultaBD {
	
	PreparedStatement anular; 			/*Anula una determinada consulta						*/
	PreparedStatement clienteActivas;  	/*Retorna todas las consultas activas de un det cliente */
	PreparedStatement clienteNulas;   	/*Retorna todas las consultas nulas de un det cliente   */
	PreparedStatement clienteTodas;  	/*Retorna todas las consulta de un det cliente          */
	PreparedStatement todasActivas; 	/*Retorna todas las consultas activas de la BD          */
	PreparedStatement todasNulas;		/*Retorna todas las consultas inactivas del sistema 	*/
	PreparedStatement todas;            /*Retorna todas las consultas del sistema				*/ 
	PreparedStatement consultarCliente; /*Retorna el determinado cliente que se encuentra asociado a una consulta*/
	
	Connection conn;
	
	public  PurgarConsultaBD(Connection connection)
	{
		
	conn = connection;
		try 
		{
			String query="";
			
		/*Anular*/
		query= "UPDATE consulta "+ "SET estado = 1 where hora=? and fecha=? and servicio=?;";
		anular = connection.prepareStatement(query);
		
		/*Activas de un cliente */
		query = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado " +
				"FROM consulta "+ "WHERE rut = ? and estado=0;";
		clienteActivas = connection.prepareStatement(query);
		
		/*Nulas de un cliente */
		query = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado " +
		"FROM consulta "+ "WHERE rut = ? and estado=1;";
		clienteNulas = connection.prepareStatement(query);
		
		/*Todas de un cliente*/
		query = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado " +
		"FROM consulta "+ "WHERE rut = ?;";
		clienteTodas = connection.prepareStatement(query);
		
		/*Todas activas */
		query = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado " +
		"FROM consulta "+ "WHERE estado=0;";
		todasActivas = connection.prepareStatement(query);
		
		/*Todas inactivas */
		query = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado " +
		"FROM consulta "+ "WHERE estado=1;";
		todasNulas = connection.prepareStatement(query);
		
		/*Todas*/
		query = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado " +
		"FROM consulta;";
		todas = connection.prepareStatement(query);
		
		/*Averigua cliente a partir de Consulta*/
		query="SELECT nombre, apaterno, amaterno " + "FROM clientepresencial where rut=?;";
		consultarCliente= connection.prepareStatement(query);
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *Metodo que anula una determinada consulta 
	 * @autor Victor Silva
	 * @param Recibe las claver primarias de la consulta y ejecuta la consulta respectiva
	 */
	public int anularConsulta(String hora, String fecha, String servicio) {

		int x=0;
		try{
			anular.setString(1, hora);
			anular.setString(2, fecha);
			anular.setString(3, servicio);
			x= anular.executeUpdate();
    		
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return x;
	}

	/**
	 *Metodo que obtiene las consultas activas de un determinado cliente 
	 * @autor Victor Silva
	 * @param Recibe el rut del cliente y ejecuta la consulta respectiva
	 */
	 public List<Consulta> cargarConsultas(String rut)
	    {
	    	List<Consulta> consultas=new ArrayList<Consulta>();

	    	try 
	    	{
	    		clienteActivas.setString(1, rut);
	    		ResultSet result = clienteActivas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Consulta con= new Consulta();
	    			
	    			con.setAnamnesis(result.getString(1));
	    			con.setServicio(result.getString(2));
	    			con.setHora(result.getString(3));
	    			con.setFecha(result.getString(4));
	    			con.setCosto(result.getString(5));
	    			con.setRut(result.getString(6));
	    			con.setNombre(result.getString(7));
	    			con.setResponsable(result.getString(8));
	    			con.setEstado(result.getInt(9));
	    			
	    			consultas.add(con);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return consultas;
	    }
	 
	 /**
		 *Metodo que obtiene las consultas nulas de un determinado cliente 
		 * @autor Victor Silva
		 * @param Recibe el rut del cliente y ejecuta la consulta respectiva
		 */
	 public List<Consulta> cargarConsultasNulas(String rut)
	    {
	    	List<Consulta> consultas=new ArrayList<Consulta>();

	    	try 
	    	{
	    		clienteNulas.setString(1, rut);
	    		ResultSet result = clienteNulas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Consulta con= new Consulta();
	    			
	    			con.setAnamnesis(result.getString(1));
	    			con.setServicio(result.getString(2));
	    			con.setHora(result.getString(3));
	    			con.setFecha(result.getString(4));
	    			con.setCosto(result.getString(5));
	    			con.setRut(result.getString(6));
	    			con.setNombre(result.getString(7));
	    			con.setResponsable(result.getString(8));
	    			con.setEstado(result.getInt(9));
	    			
	    			consultas.add(con);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return consultas;
	    }
	 
	 /**
		 *Metodo que obtiene todas las consultas de un determinado cliente 
		 * @autor Victor Silva
		 * @param Recibe el rut del cliente y ejecuta la consulta respectiva
		 */
	 public List<Consulta> cargarConsultasTodas(String rut)
	    {
	    	List<Consulta> consultas=new ArrayList<Consulta>();

	    	try 
	    	{
	    		clienteTodas.setString(1, rut);
	    		ResultSet result = clienteTodas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Consulta con= new Consulta();
	    			
	    			con.setAnamnesis(result.getString(1));
	    			con.setServicio(result.getString(2));
	    			con.setHora(result.getString(3));
	    			con.setFecha(result.getString(4));
	    			con.setCosto(result.getString(5));
	    			con.setRut(result.getString(6));
	    			con.setNombre(result.getString(7));
	    			con.setResponsable(result.getString(8));
	    			con.setEstado(result.getInt(9));
	    			
	    			consultas.add(con);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return consultas;
	    }
	 
	 
	 /**
		 *Metodo que obtiene las consultas activas de la BD 
		 * @autor Victor Silva
		 * @param ninguno
		 */
	 
	 public List<Consulta> cargarTodasActivas()
	    {
	    	List<Consulta> consultas=new ArrayList<Consulta>();

	    	try 
	    	{
	    		ResultSet result = todasActivas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Consulta con= new Consulta();
	    			
	    			con.setAnamnesis(result.getString(1));
	    			con.setServicio(result.getString(2));
	    			con.setHora(result.getString(3));
	    			con.setFecha(result.getString(4));
	    			con.setCosto(result.getString(5));
	    			con.setRut(result.getString(6));
	    			con.setNombre(result.getString(7));
	    			con.setResponsable(result.getString(8));
	    			con.setEstado(result.getInt(9));
	    			
	    			consultas.add(con);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return consultas;
	    }
	 
	 /**
		 *Metodo que obtiene las consultas nulas de la BD 
		 * @autor Victor Silva
		 * @param ninguno
		 */
	 public List<Consulta> cargarTodasNulas()
	    {
	    	List<Consulta> consultas=new ArrayList<Consulta>();

	    	try 
	    	{
	    		ResultSet result = todasNulas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Consulta con= new Consulta();
	    			
	    			con.setAnamnesis(result.getString(1));
	    			con.setServicio(result.getString(2));
	    			con.setHora(result.getString(3));
	    			con.setFecha(result.getString(4));
	    			con.setCosto(result.getString(5));
	    			con.setRut(result.getString(6));
	    			con.setNombre(result.getString(7));
	    			con.setResponsable(result.getString(8));
	    			con.setEstado(result.getInt(9));
	    			
	    			consultas.add(con);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return consultas;
	    }
	 
	 /**
		 *Metodo que obtiene todas las consultas de la BD 
		 * @autor Victor Silva
		 * @param ninguno
		 */
	 public List<Consulta> cargarTodas()
	    {
	    	List<Consulta> consultas=new ArrayList<Consulta>();

	    	try 
	    	{
	    		ResultSet result = todas.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Consulta con= new Consulta();
	    			
	    			con.setAnamnesis(result.getString(1));
	    			con.setServicio(result.getString(2));
	    			con.setHora(result.getString(3));
	    			con.setFecha(result.getString(4));
	    			con.setCosto(result.getString(5));
	    			con.setRut(result.getString(6));
	    			con.setNombre(result.getString(7));
	    			con.setResponsable(result.getString(8));
	    			con.setEstado(result.getInt(9));
	    			
	    			consultas.add(con);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return consultas;
	    }
	 
	 /**
		 *Metodo que los datos de un det cliente basandose en una consulta
		 * @autor Victor Silva
		 * @param ninguno
		 */
	 
	 public String ConsultarCliente(String rut){
		
	    	String nombre=new String();
	    	String apellido=new String();
	    	String apellido2=new String();
	    	try 
	    	{
	    		consultarCliente.setString(1, rut);
	    		ResultSet result = consultarCliente.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			nombre    =result.getString(1);
	    			apellido  =result.getString(2);
	    			apellido2 =result.getString(3);
	    			
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return nombre + apellido + apellido2;
		 
	 }
}
