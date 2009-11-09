package AdministracionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cita;
import TransferObjects.Cliente;
import TransferObjects.Mascota;


public class AddCitaBD {
	PreparedStatement selectActivos;
	PreparedStatement selectMascotas;
	PreparedStatement insert;
	Connection connection;
	Connection conn;
	
	public AddCitaBD(Connection connection)
	{
		conn = connection;
		try 
		{
		String query="";
		
		query = "INSERT INTO Cita (rutcliente,nombremascota,fecha,hora,servicio,responsable) "+
		"VALUES (?, ?, ?, ?,?,? );";			
		insert = connection.prepareStatement(query);

		query = "SELECT nombre, apaterno,amaterno, rut, telefono, celular, domicilio, region, comuna, correo "+
		"FROM clientepresencial where estado='TRUE';";

	
		selectActivos = connection.prepareStatement(query);
		
		
		query = "SELECT rut, nombre,fechanacimiento, claseanimal, raza, sexo "+
		"FROM mascota where rut = ?;";


		selectMascotas = connection.prepareStatement(query);
		
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public String addCita(Cita c) throws SQLException
	{
		String result = null;			
		
		
		insert.setString(1, c.cliente.trim());
		insert.setString(2, c.mascota);
		insert.setString(3, c.fecha);
		insert.setString(4, c.hora);
		insert.setString(5, c.servicio);
		insert.setString(6, c.usuario);
		try 
    	{
			result=""+insert.executeUpdate();
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
	 public List<Mascota> getMascotas(String rut)
	    {
	    	List<Mascota> mascotas=new ArrayList<Mascota>();
	    	Mascota mascota;
	    	try 
	    	{
	    		selectMascotas.setString(1, rut);
	    		ResultSet result = selectMascotas.executeQuery();
	    		while(result.next())
	    		{
	    			mascota= new Mascota();
	   
	    			mascota.setRutCliente(result.getString(1));
	    		    mascota.setNombre(result.getString(2));
	    		    mascota.setFechaNacimiento(result.getString(3));
	    		    mascota.setClaseAnimal(result.getString(4));
	    		    mascota.setRaza(result.getString(5));
	    		    mascota.setSexo(result.getString(6));
	    		    
	    		    
	    			
	    			mascotas.add(mascota);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return mascotas;
	    }	
}