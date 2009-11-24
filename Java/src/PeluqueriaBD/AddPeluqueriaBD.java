package PeluqueriaBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.CatPeluqueria;
import TransferObjects.Cliente;
import TransferObjects.Peluqueria;
import TransferObjects.Mascota;



public class AddPeluqueriaBD {
	PreparedStatement add;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;
	Connection conn;
	public int caduci=0;;
	
	/**
	 * Constructor de AddCirugiaBD
	 * En el cual se declaran las query, para realizar las diferentes acciones, 
	 * tanto de solicitud, como de insercion.
	 * @autor  Jimmy Mu�oz
	 * @param connection Enlace para la conexion a la base de datos
	 */
	public AddPeluqueriaBD(Connection connection){
		conn = connection;
		try{
			
			String query="";	
			
			query = "INSERT INTO Peluqueria(servicio, nombre, clienterut, mascotanombre, hora, responsable, fecha, costo, descripcion) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";			
			add = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado " +
					"FROM mascota;";			
			selectAll = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, apaterno, amaterno " +
					"FROM clientepresencial;";
			
			getAllClientes = connection.prepareStatement(query);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que se comunica con la base de datos, en el cual se registra una nueva cirugia, 
	 * para esto primero se captura la hora del sistema, para realizar el registro, esto se 
	 * almacena en la variable t.
	 * Luego se prepara el statement add en el cual se le ingresan todos los datos para realizar
	 * la insercion en la cirugia.
	 * Una vez completada la insercion anterior, se procede a insertar los diagnosticos, y los 
	 * tipos de cirugia en la tabla diagnostico.
	 * @autor  Jimmy Mu�oz
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserci�n ha fallado.
	 */
    @SuppressWarnings("deprecation")
	public int addPeluqueria(Peluqueria newPeluq, ArrayList<CatPeluqueria> catalogos){
    	int result2=0;
    	try{
    		
    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		Time t = new Time(hora, minutos, segundos);
			
			List<String> ltN = newPeluq.getTiposNombres();
			List<String> ltS = newPeluq.getTiposServicios();
			int n = ltS.size();
			for(int i=0;i<n;i++){
				String tipPel = ltS.get(i);
				String tipNom = ltN.get(i);
				
				if(tipPel != null){
					String costo = getCosto(tipPel,tipNom,catalogos);
					add.setString(1, tipPel);
					add.setString(2, tipNom);
					add.setString(3, newPeluq.getRutCliente());
					add.setString(4, newPeluq.getNombreMascota());
					add.setTime(5, t);
					add.setString(6, newPeluq.getResponsable());
					add.setDate(7, newPeluq.getFecha());
					add.setString(8, costo);
					add.setString(9, newPeluq.getDescripcion());

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
	 * Metodo que obtiene el costo que tiene una determinada vacuna. Y asigna el valor de caducidad 
	 * para posteriormente generar el date que se almacenara.
	 * @autor  Jimmy Mu�oz
	 * @param tc: el nombre de la vacuna que se quiere registrar. vacunas: listado de vacunas 
	 * registradas en el sistema.
	 * @return El costo de la vacuna, en formato String.
	 */
    public String getCosto(String tc,String tc2, ArrayList<CatPeluqueria> catalogos){
    	int largo = catalogos.size();
    	String costo = "0";
    	System.out.println("size "+largo);
    	for(int i=0;i<largo;i++){
    		System.out.println("tc2nom: "+tc2+". cat nombre: "+catalogos.get(i).getNombre()+". tc serv: "+tc+". catServ: "+catalogos.get(i).getServicio()+".");
    		if(tc2.equals(catalogos.get(i).getNombre().trim()) && tc.equals(catalogos.get(i).getServicio().trim())){
    			return catalogos.get(i).getPrecio();
    		}
    	}
    	
    	return costo;
    }
	
    
    /**
	 * Metodo que se comunica con la base de datos, y que solicita todos los clientes existentes, y luego compara los rut,
	 * para verificar si el cliente existe.
	 * @autor  Jimmy Mu�oz
	 * @param El rut del cliente, en una varibale String..
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserci�n ha fallado.
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
    				cliente.setApellido(result.getString(3));
    				cliente.setApellido2(result.getString(4));
    			}
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return cliente;
	}
    
	
    
    /**
	 * Metodo que se comunica con la base de datos, y que recibe los datos de las mascotas existentes en el sistema, 
	 * que pertenecen al cliente, del rut ingresado, los cuales va a�adiendo a un objeto de tipos Mascota, para luego 
	 * se agregados a una lista del tipo Mascota.
	 * @autor  Jimmy Mu�oz
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