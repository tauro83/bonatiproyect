//=======================================================================
// FECHA CREACIÓN: 27/10/09
// AUTOR:Jimmy Muñoz
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestreo caso, almacenando los datos de los usuarios, y recuperando datos.
//======================================================================

package PoliclinicoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import TransferObjects.Cliente;
import TransferObjects.ConfiguracionVacuna;
import TransferObjects.Vacunacion;
import TransferObjects.Mascota;



public class AddVacunacionBD {
	PreparedStatement add;
	PreparedStatement selectAll;
	PreparedStatement getAllClientes;
	PreparedStatement addEstadisticas;
	Connection conn;
	public int caduci=0;;
	
	/**
	 * Constructor de AddCirugiaBD
	 * En el cual se declaran las query, para realizar las diferentes acciones, 
	 * tanto de solicitud, como de insercion.
	 * @autor  Jimmy Muñoz
	 * @param connection Enlace para la conexion a la base de datos
	 */
	public AddVacunacionBD(Connection connection){
		conn = connection;
		try{
			
			String query="";	
			
			query = "INSERT INTO Vacunacion(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";			
			add = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado " +
					"FROM mascota;";			
			selectAll = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, apaterno, amaterno " +
					"FROM clientepresencial;";
			
			getAllClientes = connection.prepareStatement(query);
			
			query="INSERT INTO estadisticasclinica("+
            "tipo, fecha, area)"+
			" VALUES (?, ?, ?);";
			addEstadisticas = connection.prepareStatement(query);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que se comunica con la base de datos, en el cual se registra una nueva cirugia, 
	 * para esto primero se captura la hora del sistema, para realizar el registro, esto se 
	 * almacena en la variable t.
	 * Luego se prepara el statement addEstadisticas en el cual se le ingresan todos los datos para realizar
	 * la insercion en la cirugia.
	 * Una vez completada la insercion anterior, se procede a insertar los diagnosticos, y los 
	 * tipos de cirugia en la tabla diagnostico.
	 * @autor  Jimmy Muñoz
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado.
	 */
   
	public int addVacunacion(Vacunacion newVacuna, ArrayList vacunas){
    	int result2=0;
    	try{
    		
    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		Time t = new Time(hora, minutos, segundos);
			List ltv = newVacuna.getTiposVacunas();
			int n = ltv.size();
			for(int i=0;i<n;i++){
				String tipVac = (String) ltv.get(i);
				
				if(tipVac != null){
					String costo = getCosto(tipVac,vacunas);
					Date fecha = this.getFechaCaducidad(newVacuna.getFecha());
					add.setString(1, tipVac);
					add.setString(2, newVacuna.getClienteRut());
					add.setString(3, newVacuna.getMascotaNombre());
					add.setTime(4, t);
					add.setString(5, newVacuna.getVeterinario());
					add.setDate(6, newVacuna.getFecha());
					add.setString(7, costo);
					add.setDate(8, fecha);
					add.setString(9, newVacuna.getDescripcion());
					result2= add.executeUpdate();
					
					//agregando datos a estadisticas clincia
					addEstadisticas.setInt(1, 2);
					addEstadisticas.setDate(2, newVacuna.getFecha());
					addEstadisticas.setInt(3, 3);
					addEstadisticas.executeUpdate();

					//
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
	 * @autor  Jimmy Muñoz
	 * @param tc: el nombre de la vacuna que se quiere registrar. vacunas: listado de vacunas 
	 * registradas en el sistema.
	 * @return El costo de la vacuna, en formato String.
	 */
    public String getCosto(String tc, ArrayList vacunas){
    	int largo = vacunas.size();
    	String costo = "0";
    	for(int i=0;i<largo;i++){
    		if(tc.equals(((ConfiguracionVacuna) vacunas.get(i)).getNombre())){
    			this.caduci = (int)Integer.parseInt(((ConfiguracionVacuna) vacunas.get(i)).getCaducidad());
    			return ((ConfiguracionVacuna) vacunas.get(i)).getPrecio();
    		}
    	}
    	
    	return costo;
    }
    
    /**
	 * Metodo que genera la fecha de caducidad, que corresponde a cada vacuna.
	 * @autor  Jimmy Muñoz
	 * @param fechaHoy, que es la fecha que fue seleccionada en la capa 1.
	 * @return fechaCaducidad, que es la fecha que se obtuvo de agregarle la 
	 * caducidad de la vacuna a la fecha actual.
	 */

	public Date getFechaCaducidad(Date fechaHoy){
    	int mes = fechaHoy.getMonth();
    	int dia = fechaHoy.getDate();
    	int anhio = fechaHoy.getYear();

    	int nuevoMes = mes+caduci;
    	
    	mes = nuevoMes%12;
    	nuevoMes = nuevoMes/12;
    	anhio = anhio + nuevoMes;

    	Date fechaCaducidad = new Date(anhio,mes,dia);
    	return fechaCaducidad;
    }
	
    
    /**
	 * Metodo que se comunica con la base de datos, y que solicita todos los clientes existentes, y luego compara los rut,
	 * para verificar si el cliente existe.
	 * @autor  Jimmy Muñoz
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
	 * que pertenecen al cliente, del rut ingresado, los cuales va añadiendo a un objeto de tipos Mascota, para luego 
	 * se agregados a una lista del tipo Mascota.
	 * @autor  Jimmy Muñoz
	 * @param El rut del cliente del cual se quieren obtener las mascotas.
	 * @return Lista con las mascotas del sistema que pertenecen a este cliente, esto en una lista de objetos Mascota.
	 */
    public List getMascotas(String rutCliente){
    	List mascotas=new ArrayList();
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