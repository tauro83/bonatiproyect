//=======================================================================
// FECHA: CREACIÓN: 27-10-09
// AUTOR: Esteban Cruz
// Clase para anular o eliminar una vacunacion desde la base de datos, además, 
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package PoliclinicoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Vacunacion;
import TransferObjects.Cliente;
import TransferObjects.Mascota;

public class VacunacionBD {
	
	PreparedStatement selectAllVacunaciones;
	PreparedStatement selectAllClientes;
	PreparedStatement selectAllMascotas;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 * @author  "Esteban Cruz"
	 */
	public VacunacionBD(Connection connection)
	{
		try 
		{
			String query="", queryCliente="", queryMascota="";
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"descripcion, responsable, servicio, estado, fecha " +
					"FROM vacunacion " +
					"WHERE estado = 0;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			queryCliente = "SELECT nombre, apaterno "+
							"FROM clientepresencial "+
							"WHERE rut = ? ;";
			selectAllClientes = connection.prepareStatement(queryCliente);
			
			queryMascota = "SELECT raza, sexo "+
							"FROM mascota "+
							"WHERE nombre = ? AND rut = ? ;";
			selectAllMascotas = connection.prepareStatement(queryMascota);
			
			query = "UPDATE vacunacion " +
					"SET estado = ? " + 
					"WHERE mascotanombre=? and fecha=? and hora=? ;";
			setEstado = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Trata de obtener todos las vacunaciones registrados en la base de datos
	 * @return Lista con todas las vacunaciones registradas
	 * @author  "Esteban Cruz"
	 */
	 public List getAllVacunaciones()
	    {	
	    	List vacunaciones = new ArrayList();
	    	Vacunacion vacu;
	    	Cliente clie;
	    	Mascota masc;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new Vacunacion();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
	    			vacu.setClienteRut(result.getString(1).trim());
	    			vacu.setMascotaNombre(result.getString(2).trim());
	    			
	    			selectAllMascotas.setString(2, vacu.getClienteRut());
	    			selectAllMascotas.setString(1, vacu.getMascotaNombre());
	    			mascota = selectAllMascotas.executeQuery();
	    			while(mascota.next()){
	    				masc.setRaza(mascota.getString(1).trim());
	    				vacu.setMascotaRaza(masc.getRaza());
	    				masc.setSexo(mascota.getString(2).trim());
	    				vacu.setMascotaSexo(masc.getSexo());
	    			}
	    			
	    			selectAllClientes.setString(1, vacu.getClienteRut());
	    			cliente = selectAllClientes.executeQuery();
	    			while(cliente.next()){
	    				clie.setNombre(cliente.getString(1).trim());
	    				vacu.setClienteNombre(clie.getNombre());
	    				clie.setApellido(cliente.getString(2).trim());
	    				vacu.setClienteApellido(clie.getApellido());
	    			}
	    			
	    			vacunaciones.add(vacu);	
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	    }
	 
	 /**
	  * Trata de obtener todos las vacunaciones registrados en la base de datos
	  * de un cliente determinado
	  * @return Lista con todas las vacunaciones registradas
	  * @author  "Esteban Cruz"
	  */
	 public List getAllVacunacionesU(String rut, String nombre)
	 {
		 	List vacunaciones = new ArrayList();
		 	Vacunacion vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new Vacunacion();
	    			
	    			vacu.setClienteRut(result.getString(1).trim());
	    			vacu.setMascotaNombre(result.getString(2).trim());
	    			vacu.setHora(result.getString(3).trim());
	    			vacu.setDescripcion(result.getString(4).trim());
	    			vacu.setVeterinario(result.getString(5).trim());
	    			vacu.setServicio(result.getString(6).trim());
	    			vacu.setFechaS(result.getString(8).trim());

	    			String rut2 = vacu.getClienteRut();
	    			String nombre2 = vacu.getMascotaNombre();
	    			
	    			if(rut2.equals(rut) && nombre2.equals(nombre))
	    			{
	    				vacunaciones.add(vacu);
	    			}
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	 }
	 
	 /**
	  * Anula todas las vacunaciones solicitadas por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha anulado correctamente y 0 de lo contrario
	  * @author  "Esteban Cruz"
	  */
	 public int anular(String nombre, String fecha, String hora)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 2);
			setEstado.setString(2, nombre);
			setEstado.setString(3, fecha);
			setEstado.setString(4, hora);
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 /**
	  * Elimina todas las vacunaciones solicitadas por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha elimina correctamente y 0 de lo contrario
	  * @author  "Esteban Cruz"
	  */
	 public int eliminar(String nombre, String fecha, String hora)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 1);
			setEstado.setString(2, nombre);
			setEstado.setString(3, fecha);
			setEstado.setString(4, hora);
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
}
