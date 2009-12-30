package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.Usuario;

public class ClienteElimPurgServiceBD {

		PreparedStatement selectActivos;
		PreparedStatement selectEliminados;
		PreparedStatement eliminar;
		PreparedStatement purgar;
		PreparedStatement reactivar;
		Connection conn;
		
		public ClienteElimPurgServiceBD(Connection connection)
		{
			conn = connection;
			try 
			{
				String query="";			
				
				query = "UPDATE usuario "+
				   "SET nombre=?, apaterno=?, amaterno=?, usuario=?, cargo=?, contrasena=?, "+
					       "servicio=?, pregistrar=?, peditar=?, peliminar=?, ppurgar=? "+
					 "WHERE usuario = ?;";

			query = "SELECT nombre, apaterno,amaterno, rut, telefono, celular, domicilio, region, comuna, correo "+
				"FROM clientepresencial where estado='TRUE';";
				
					
				selectActivos = connection.prepareStatement(query);
				
				query = "SELECT nombre, apaterno,amaterno, rut, telefono, celular, domicilio, region, comuna, correo "+
				"FROM clientepresencial where estado='FALSE';";
				
					
				selectEliminados = connection.prepareStatement(query);
				
				query = "DELETE FROM clientepresencial " +
				"WHERE rut = ?; "+
				 "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
					"VALUES (?, ?, ?, ?);";
				purgar = connection.prepareStatement(query);
				
				query = "UPDATE clientepresencial "+
				   "SET estado='FALSE'" +
				   "Where rut =?; "+
				   "INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
					"VALUES (?, ?, ?, ?);";
				eliminar= connection.prepareStatement(query);
				
				query = "UPDATE clientepresencial "+
				   "SET estado='TRUE'" +
				   "Where rut =?;";
				reactivar= connection.prepareStatement(query);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
	    public int eliminarCliente(String rut, String usuario) throws SQLException
	    {
	    	int result=0;
	    	eliminar.setString(1, rut);
	    	
	    	Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
    		
			eliminar.setString(2, fecha);
			eliminar.setString(3, usuario);
			eliminar.setString(4, "Administración");
			eliminar.setString(5, "Elimina cliente rut: "+rut);
	    	
			eliminar.executeQuery();
			result= eliminar.executeUpdate();
	    	
			return result;
	    	
	    }
	    public int pugarCliente( String rut, String usuario) throws SQLException
	    {
	    	int result=0;
	    	purgar.setString(1, rut);
	    	
	    	Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
    		
			purgar.setString(2, fecha);
			purgar.setString(3, usuario);
			purgar.setString(4, "Administración");
			purgar.setString(5, "Purga cliente rut: "+rut);
	    	
			purgar.executeQuery();
			result= purgar.executeUpdate();
	    	
			return result;
	    	
	    }
	    
	    public int reactivarCliente( String rut) throws SQLException
	    {
	    	int result=0;
	    	reactivar.setString(1, rut);
			reactivar.executeQuery();
			result= reactivar.executeUpdate();
	    	
			return result;
	    	
	    }
	    
		/**
		 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
		 * con los datos de cada usuario en el sistema.
		 * @param 
		 * @return Una lista de objetos de la clase Usuario.
		 */
	    public List getClientesActivosE()
	    {
	    	List clientes=new ArrayList();
	    	Cliente cliente;
	    	try 
	    	{
	    		ResultSet result = selectActivos.executeQuery();
	    		while(result.next())
	    		{
	    			cliente= new Cliente();
	   
	    			cliente.setNombre(result.getString(1));
	    			cliente.setApellido(result.getString(2));
	    		    cliente.setApellido2(result.getString(3));
	    	    	cliente.setRut(result.getString(4));
	    		//	cliente.setRut2(result.getString(2));
	    		//	cliente.setTelefono(result.getString(6));
	    			cliente.setTelefono2(result.getString(5));
	    		//	cliente.setCelular(result.getString(8));
	    			cliente.setCelular2(result.getString(6));
	    			cliente.setDireccion(result.getString(7));
	    			cliente.setRegion(result.getString(8));
	    			cliente.setComuna(result.getString(9));
	    			cliente.setEmail(result.getString(10));
	    		//	cliente.setEmail2(result.getString(14));
	    		//	cliente.setEstado(result.getBoolean(15));
	    			System.out.println(cliente.getNombre());
	    			
	    			clientes.add(cliente);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return clientes;
	    }
	    public List getClientesEliminados()
	    {
	    	System.out.println("LLEGO A CLIENTEEdit BD / getAllClienteE");
	    	List clientes=new ArrayList();
	    	Cliente cliente;
	    	try 
	    	{
	    		ResultSet result = selectEliminados.executeQuery();
	    		while(result.next())
	    		{
	    			cliente= new Cliente();
	   
	    			cliente.setNombre(result.getString(1));
	    			cliente.setApellido(result.getString(2));
	    		    cliente.setApellido2(result.getString(3));
	    	    	cliente.setRut(result.getString(4));
	    		//	cliente.setRut2(result.getString(2));
	    		//	cliente.setTelefono(result.getString(6));
	    			cliente.setTelefono2(result.getString(5));
	    		//	cliente.setCelular(result.getString(8));
	    			cliente.setCelular2(result.getString(6));
	    			cliente.setDireccion(result.getString(7));
	    			cliente.setRegion(result.getString(8));
	    			cliente.setComuna(result.getString(9));
	    			cliente.setEmail(result.getString(10));
	    		//	cliente.setEmail2(result.getString(14));
	    		//	cliente.setEstado(result.getBoolean(15));
	    			System.out.println(cliente.getNombre());
	    			
	    			clientes.add(cliente);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return clientes;
	    }
	}


