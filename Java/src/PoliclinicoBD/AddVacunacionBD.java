package PoliclinicoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.Vacuna;
import TransferObjects.Mascota;


public class AddVacunacionBD {
	PreparedStatement add;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;
	
	
	/**
	 * Constructor de AddCirugiaBD
	 * En el cual se declaran las query, para realizar las diferentes acciones, tanto de solicitud, como de insercion.
	 * @param connection Enlace para la conexion a la base de datos
	 */
	public AddVacunacionBD(Connection connection){
		
		try{
			
			String query="";	
			
			query = "INSERT INTO Vacuna(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";			
			add = connection.prepareStatement(query);
			
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
	 * Autor: Jimmy Muñoz
	 * Metodo que se comunica con la base de datos, en el cual se registra una nueva cirugia, para esto primero se
	 * captura la hora del sistema, para realizar el registro, esto se almacena en la variable t.
	 * Luego se prepara el statement add en el cual se le ingresan todos los datos para realizar la insercion en la cirugia.
	 * Una vez completada la insercion anterior, se procede a insertar los diagnosticos, y los tipos de cirugia en la tabla 
	 * diagnostico.
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado.
	 */
    @SuppressWarnings("deprecation")
	public int addCirugia(Vacuna newVacuna){
    	int result2=0;
    	try{

    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		Time t = new Time(hora, minutos, segundos);
			Date fecha = c.getTime();
			
			List<String> ltv = newVacuna.getTiposVacunas();
			int n = ltv.size();
			for(int i=0;i<n;i++){
				String tc = ltv.get(i);
				if(tc != null){
					add.setString(1, tc);
					add.setString(2, newVacuna.getClienteRut());
					add.setString(3, newVacuna.getMascotaNombre());
					add.setTime(4, t);
					add.setString(5, newVacuna.getVeterinario());
					add.setDate(6, newVacuna.getFecha());
					add.setString(7, newVacuna.getCosto());
					add.setDate(8, newVacuna.getFechaCaducidad());
					add.setString(9, newVacuna.getDescripcion());

					result2= add.executeUpdate();
				}
				
			}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result2;
    }
	
    
    /**
	 * Autor: Jimmy Muñoz
	 * Metodo que se comunica con la base de datos, y que solicita todos los clientes existentes, y luego compara los rut,
	 * para verificar si el cliente existe.
	 * @param El rut del cliente, en una varibale String..
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado.
	 */
	public Cliente getCliente(String rutCliente){
    	Cliente cliente = null;
    	try{
    		cliente = new Cliente();
    		ResultSet result = getAllClientes.executeQuery();
    		while(result.next()){
    			String s = result.getString(1).substring(0, 8);
    			if(s.equals(rutCliente)){
    				cliente.setRut(result.getString(1));
    				cliente.setNombre(result.getString(2));
    			}
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return cliente;
	}
    
	
    
    /**
	 * Autor: Jimmy Muñoz
	 * Metodo que se comunica con la base de datos, y que recibe los datos de las mascotas existentes en el sistema, 
	 * que pertenecen al cliente, del rut ingresado, los cuales va añadiendo a un objeto de tipos Mascota, para luego 
	 * se agregados a una lista del tipo Mascota.
	 * @param El rut del cliente del cual se quieren obtener las mascotas.
	 * @return Lista con las mascotas del sistema que pertenecen a este cliente, esto en una lista de objetos Mascota.
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