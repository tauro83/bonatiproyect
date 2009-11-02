package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.Cirugia;
import TransferObjects.Cliente;
import TransferObjects.Mascota;


public class AddCirugiaBD {
	PreparedStatement add;
	PreparedStatement addDiag;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;
	
	
	/**
	 * Constructor de AddCirugiaBD
	 * En el cual se declaran las query, para realizar las diferentes acciones, tanto de solicitud, como de insercion.
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
					"FROM mascota WHERE estado='TRUE';";			
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
	public int addCirugia(Cirugia newCirugia){
    	int result2=0;
    	try{

    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		Time t = new Time(hora, minutos, segundos);
    		
    		
    		    		
			add.setString(1, newCirugia.getClienteRut());
			add.setString(2, newCirugia.getMascotaNombre());
			add.setTime(3, t);
			add.setString(4, newCirugia.getVeterinario());
			add.setString(5, newCirugia.getAyudante());
			add.setString(6, newCirugia.getFecha());
			add.setString(7, newCirugia.getCosto());
			
			result2= add.executeUpdate();
			
			List<String> ltc = newCirugia.getTiposCirugias();
			int n = ltc.size();
			for(int i=0;i<n;i++){
				String tc = ltc.get(i);
				if(tc != null){
					String s = Integer.toString(i);
					addDiag.setString(1, newCirugia.getClienteRut());
					addDiag.setString(2, newCirugia.getMascotaNombre());
					addDiag.setTime(3, t);
					addDiag.setString(4, newCirugia.getFecha());
					addDiag.setString(5, newCirugia.getDiagnostico());
					addDiag.setString(6, newCirugia.getFecha());
					addDiag.setString(7, tc);
					addDiag.setTime(8, t);
					addDiag.setString(9, s);
					
					result2= addDiag.executeUpdate();
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
    				cliente.setRut(s);
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