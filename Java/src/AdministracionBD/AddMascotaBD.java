//=======================================================================
// FECHA CREACIÓN: 10 de Septiembre de 2009
// AUTOR: Sebastian Arancibia
// …. Clase Mascota
//=======================================================================


package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;



import Bd.DBConnectionManager;
import TransferObjects.Mascota;

/**
 * Clase utilizada para la comunicacion entre capa 2 y 3 (Java y PostgreSQL)
 *
 * @author  Sebastian Arancibia
 * @version 0.1, 22/09/09
 */


public class AddMascotaBD{
	PreparedStatement add;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;
	
	
	/**
	 * Constructor de MascotaBD
	 * @author Sebastian Arancibia
	 * @param connection Enlace para la conexion a la base de datos
	 */
	public AddMascotaBD(Connection connection){
		
		try{
			
			String query="";	
			/**Consulta a la base de datos, Inserta una nueva mascota */
			query = "INSERT INTO mascota(rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?); " +
					"INSERT INTO bitacora2(fecha, usuario, servicio, accion) "+
					"VALUES (?, ?, ?, ?);";		
			add = connection.prepareStatement(query);
			
			/**Consulta a la base de datos, Selecciona todas las mascotas registradas en la base de datos*/
			query = "SELECT rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado " +
					"FROM mascota " +
					"WHERE estado = 'TRUE';";			
			selectAll = connection.prepareStatement(query);
			
			/**Selecciona datos especificos de los clientes presenciales*/
			query = "SELECT rut, nombre, apaterno " +
					"FROM clientepresencial;";
			
			getAllClientes = connection.prepareStatement(query);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Funcion que retorna un cliente con un rut especifico
	 * @param rutCliente Rut del Cliente al que se le quieren seleccionar los datos
	 * @return cliente Cliente que tiene un rut rutCliente
	 */
	public String getCliente(String rutCliente){
    	String cliente = null;
    	try{
    		ResultSet result = getAllClientes.executeQuery();
    		while(result.next()){
    			//System.out.println("COMPARO: |" + result.getString(1).trim() +"| |"+ rutCliente +"|");
    			if((result.getString(1).trim()).equals(rutCliente)){
    				cliente = result.getString(2).trim() +" "+ result.getString(3).trim();
    			}
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return cliente;
	}

	
	/**
	 * Ingresa a una nueva Mascota a la base de datos
	 * @autor Sebastian Arancibia
	 * @param mascota contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	 public int addMascota(Mascota mascota, String usuario){
		int result=0;
    	try{

			add.setString(1, mascota.getRutCliente());
			add.setString(2, mascota.getNombre());
			add.setString(3, mascota.getFechaNacimiento());
			add.setString(4, mascota.getClaseAnimal());
			add.setString(5, mascota.getRaza());
			add.setString(6, mascota.getSexo());
			add.setBoolean(7, true);
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date);
			add.setString(8, fecha);
			add.setString(9, usuario);
			add.setString(10, "Administración");
			add.setString(11, "Registra mascota: "+mascota.getNombre()+" especie: "+mascota.getClaseAnimal());

			
			result= add.executeUpdate();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
    
	/**
	 * Retorna todas las mascotas alojadas en la base de datos
	 * @autor Sebastian Arancibia
	 * @return mascotas Lista de todas las mascotas
	 */
    public ArrayList getAllMascotas(){
    	ArrayList mascotas = new ArrayList();
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
	 * Retorna una lista con las mascotas de rutCliente
	 * @autor Sebastian Arancibia
	 * @param rutCliente es el rut del cliente  que se quiere retornar las mascotas
	 * @return Lista de mascotas o null si no tiene
	 */
    public ArrayList getMascotas(String rutCliente){
    	ArrayList mascotas=new ArrayList();
    	Mascota mascota;
    	
    	try{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next()){
    			if(rutCliente.equals(result.getString(1).trim())){
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
