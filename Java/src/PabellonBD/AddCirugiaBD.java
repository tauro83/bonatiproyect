package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import Bd.DBConnectionManager;
import TransferObjects.Cirugia;
import TransferObjects.Mascota;
import TransferObjects.tiposCir;

public class AddCirugiaBD {
	PreparedStatement add;
	PreparedStatement addDiag;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;
	
	
	/**
	 * Constructor de MascotaBD
	 * @param connection Enlace para la conexion a la base de datos
	 */
	public AddCirugiaBD(Connection connection){
		
		try{
			
			String query="";	
			
			query = "INSERT INTO Cirugia(clienterut, mascotanombre, hora, responsable, ayudante, fecha, costo) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?);";			
			add = connection.prepareStatement(query);
			
			query = "INSERT INTO Diagnosticos(clienterut, mascotanombre, hora, fecha, diagnostico, nuevafecha, tipocirugia, nuevahora, id) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";			
			addDiag = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado " +
					"FROM mascota;";			
			selectAll = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre " +
					"FROM clientepresencial;";
			
			getAllClientes = connection.prepareStatement(query);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ingresa a una nueva Mascota a la base de datos
	 * @param mascota contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int addCirugia(Cirugia newCirugia){
    	int result=0, result2=0, result1=0;
    	try{

    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		Time t = new Time(hora, minutos, 0);
    		
    		
    		    		
			add.setString(1, newCirugia.getClienteRut());
			add.setString(2, newCirugia.getMascotaNombre());
			add.setTime(3, t);
			add.setString(4, newCirugia.getVeterinario());
			add.setString(5, newCirugia.getAyudante());
			add.setString(6, newCirugia.getFecha());
			add.setString(7, newCirugia.getCosto());
			
			result1= add.executeUpdate();
			
			/*"INSERT INTO diagnostico(clienterut, mascotanombre, hora, fecha, diagnostico, nuevafecha, tipocirugia, nuevahora) "+
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?);"*/
			
			List<tiposCir> ltc = newCirugia.getTiposCirugias();
			int n = ltc.size();
			for(int i=0;i<n;i++){
				tiposCir tc = (tiposCir)ltc.get(i);
				if(tc != null){
					String s = Integer.toString(i);
					addDiag.setString(1, newCirugia.getClienteRut());
					addDiag.setString(2, newCirugia.getMascotaNombre());
					addDiag.setTime(3, t);
					addDiag.setString(4, newCirugia.getFecha());
					addDiag.setString(5, newCirugia.getDiagnostico());
					addDiag.setString(6, newCirugia.getFecha());
					addDiag.setString(7, tc.getCirugias());
					addDiag.setTime(8, t);
					addDiag.setString(9, s);
					
					result2= addDiag.executeUpdate();
				}
				
			}
			
			/*List<tiposCir> ltc = newCirugia.getTiposCirugias();
			
			tiposCir tc = (tiposCir)ltc.get(0);
			String s = Integer.toString(0);
			System.out.println("inicio");
			addDiag.setString(1, newCirugia.getClienteRut());
			addDiag.setString(2, newCirugia.getMascotaNombre());
			addDiag.setTime(3, t);
			addDiag.setString(4, newCirugia.getFecha());
			addDiag.setString(5, newCirugia.getDiagnostico());
			addDiag.setString(6, newCirugia.getNuevaFecha());
			addDiag.setString(7, tc.getCirugias());
			addDiag.setTime(8, t);
			addDiag.setString(9, s);
			System.out.println("fin");
			
			result2= addDiag.executeUpdate();
			*/
		
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result2;
    }
	
	public String getCliente(String rutCliente){
    	String cliente = null;
    	try{
    		ResultSet result = getAllClientes.executeQuery();
    		while(result.next()){
    			if((result.getString(1).trim()).equals(rutCliente)){
    				cliente = result.getString(2);
    			}
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return cliente;
	}
    
	/**
	 * Retorna todas las mascotas alojadas en la base de datos
	 *
	 * @return Lista de todas las mascotas
	 */
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
    
	/**
	 * Retorna una lista con las mascotas de @param
	 * @param rutCliente es el rut del cliente  que se quiere retornar las mascotas
	 * @return Lista de mascotas o null si no tiene
	 */
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