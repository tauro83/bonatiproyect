package HoteleriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.Hoteleria;

public class RegistHoteleriaBD {
	PreparedStatement selectActivos;
	PreparedStatement insertar;
	Connection connection;
	Connection conn;
	
	public RegistHoteleriaBD(Connection connection)
	{
		conn = connection;
		try 
		{
		String query="";
		
		query = "INSERT INTO atencionalojamiento (servicio,hora,fechaingreso,costo,responsable,cliente,mascota,canil,fechasalida) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? );";			
		insertar = connection.prepareStatement(query);
		
		query = "SELECT nombre, apaterno,amaterno, rut, telefono, celular, domicilio, region, comuna, correo "+
		"FROM clientepresencial where estado='TRUE';";

	
		selectActivos = connection.prepareStatement(query);
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	
	public String registrarHoteleria(Hoteleria a) throws SQLException
	{
		Calendar c = Calendar.getInstance();
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int minutos = c.get(Calendar.MINUTE);
		//int segundos = c.get(Calendar.SECOND);
		
		String t = hora + ":" + minutos;
		
		String result = null;			
		
		
		insertar.setString(1, a.getServicio());
		insertar.setString(2, t);
		insertar.setDate(3,   a.getFechaIngreso());
		insertar.setString(4, a.getCosto());
		insertar.setString(5, a.getResponsable());
		insertar.setString(6, a.getCliente());
		insertar.setString(7, a.getMascota());
		insertar.setInt(8, a.getCanil());
		insertar.setDate(9, a.getFechaSalida());
		try 
    	{
			result=""+insertar.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+e.toString(); 
			
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
	}
	
	public List<Cliente> getClientesActivosE()
    {
    	List<Cliente> clientes=new ArrayList<Cliente>();
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
    			cliente.setTelefono2(result.getString(5));
    			cliente.setCelular2(result.getString(6));
    			cliente.setDireccion(result.getString(7));
    			cliente.setRegion(result.getString(8));
    			cliente.setComuna(result.getString(9));
    			cliente.setEmail(result.getString(10));
    			
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
