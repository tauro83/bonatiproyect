package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.Consulta;
import TransferObjects.Mascota;



public class AddConsultaBD {
	PreparedStatement add;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;

	

	public AddConsultaBD(Connection connection){
		
		try{
			
			String query="";	
			
			query = "INSERT INTO consulta(rut, nombre, costo, anamnesis, servicio, responsable, hora, fecha) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";			
			add = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado " +
					"FROM mascota;";			
			selectAll = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre " +
					"FROM clientepresencial;";
			
			getAllClientes= connection.prepareStatement(query);
						
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public int addConsulta(Consulta consulta3) throws SQLException
	{
				
    	int result2=0;
    	try{
    		
    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		String h=hora+":"+minutos+":"+segundos;
    		
			add.setString(1, consulta3.getRut().trim());
			add.setString(2, consulta3.getNombre().trim());
			add.setString(3, consulta3.getCosto().trim());
			add.setString(4, consulta3.getAnamnesis().trim());
			add.setString(5, consulta3.getServicio().trim());
			add.setString(6, consulta3.getResponsable().trim());
			add.setString(7, h.trim());
			add.setString(8, consulta3.getFecha().trim());


			result2= add.executeUpdate();
			}
				

    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result2;
    }
	
    
	public Cliente getCliente(String rutCliente){
    	Cliente cliente = null;
    	try{
    		cliente = new Cliente();
    		ResultSet result = getAllClientes.executeQuery();
    		while(result.next()){
    			String s = result.getString(1).trim();
    			if(s.length()>8){
    				s = result.getString(1).substring(0, 8);
	    			if(s.equals(rutCliente)){
	    				cliente.setRut(result.getString(1));
	    				cliente.setNombre(result.getString(2));
	    			}
    			}
    			else{
    				s = result.getString(1).substring(0, 7);
    				if(s.equals(rutCliente)){    					
	    				cliente.setRut(result.getString(1));
	    				cliente.setNombre(result.getString(2));
	    			}
    			}
    			
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return cliente;
	}
    

    public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mascota;
    	try{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next()){
    			mascota= new Mascota();

    			mascota.setRutCliente(result.getString(1));
    			mascota.setNombre(result.getString(2));
    			mascota.setFechaNacimiento(result.getString(3));
    			mascota.setClaseAnimal(result.getString(4));
    			mascota.setRaza(result.getString(5));
    			mascota.setSexo(result.getString(6));
    			mascota.setEstado(result.getBoolean(7));
    			
    			mascotas.add(mascota);
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return mascotas;
    }
    

    public List<Mascota> getMascotas(String rutCliente){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mascota;
    	
    	try{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next()){
    			if(rutCliente.equals(result.getString(1).substring(0, 8))){
    				mascota= new Mascota();

	    			mascota.setRutCliente(result.getString(1));
	    			mascota.setNombre(result.getString(2));
	    			mascota.setFechaNacimiento(result.getString(3));
	    			mascota.setClaseAnimal(result.getString(4));
	    			mascota.setRaza(result.getString(5));
	    			mascota.setSexo(result.getString(6));
	    			mascota.setEstado(result.getBoolean(7));
	    			
	    			mascotas.add(mascota);
    			}
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return mascotas;
    }
    
}
