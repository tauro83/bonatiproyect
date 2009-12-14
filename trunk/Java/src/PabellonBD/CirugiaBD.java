//=======================================================================
// FECHA: CREACI�N: 14-10-09
// AUTOR: Esteban Cruz
// Clase para anular o eliminar una cirug�a desde la base de datos, adem�s, 
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cirugia;
import TransferObjects.Cliente;
import TransferObjects.Mascota;

public class CirugiaBD {
	
	PreparedStatement selectAllCirugias;
	PreparedStatement selectAllClientes;
	PreparedStatement selectAllMascotas;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexi�n obtenida con la base de datos
	 * @author  "Esteban Cruz"
	 */
	public CirugiaBD(Connection connection)
	{
		try 
		{
			String query="", queryCliente="", queryMascota="";
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"diagnostico, responsable, servicio, estado, fecha " +
					"FROM cirugia " +
					"WHERE estado = 0;";
			selectAllCirugias = connection.prepareStatement(query);
			
			queryCliente = "SELECT nombre, apaterno "+
							"FROM clientepresencial "+
							"WHERE rut = ? ;";
			selectAllClientes = connection.prepareStatement(queryCliente);
			
			queryMascota = "SELECT raza, sexo "+
							"FROM mascota "+
							"WHERE nombre = ? AND rut = ? ;";
			selectAllMascotas = connection.prepareStatement(queryMascota);
			
			query = "UPDATE cirugia " +
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
	 * Trata de obtener todos las cirugias registrados en la base de datos
	 * @return Lista con todas las cirugias registradas
	 * @author  "Esteban Cruz"
	 */
	 public List<Cirugia> getAllCirugias()
	    {	
	    	List<Cirugia> cirugias = new ArrayList<Cirugia>();
	    	Cirugia ciru;
	    	Cliente clie;
	    	Mascota masc;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugias.executeQuery();
	    		while(result.next())
	    		{  
	    			ciru = new Cirugia();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
		    		ciru.setClienteRut(result.getString(1).trim());
		    		ciru.setMascotaNombre(result.getString(2).trim());
	    			
	    			selectAllMascotas.setString(2, ciru.getClienteRut());
	    			selectAllMascotas.setString(1, ciru.getMascotaNombre());
	    			mascota = selectAllMascotas.executeQuery();
	    			while(mascota.next()){
	    				masc.setRaza(mascota.getString(1).trim());
	    				ciru.setMascotaRaza(masc.getRaza());
	    				masc.setSexo(mascota.getString(2).trim());
	    				ciru.setMascotaSexo(masc.getSexo());
	    			}
	    			
	    			selectAllClientes.setString(1, ciru.getClienteRut());
	    			cliente = selectAllClientes.executeQuery();
	    			while(cliente.next()){
	    				clie.setNombre(cliente.getString(1).trim());
	    				ciru.setClienteNombre(clie.getNombre());
	    				clie.setApellido(cliente.getString(2).trim());
	    				ciru.setClienteApellido(clie.getApellido());
	    			}

	    			cirugias.add(ciru);	
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	    }
	 
	 /**
	  * Trata de obtener todos las cirugias registrados en la base de datos
	  * de un cliente determinado
	  * @return Lista con todas las cirugias registradas
	  * @author  "Esteban Cruz"
	  */
	 public List<Cirugia> getAllCirugiasU(String rut, String nombre)
	 {
		 	List<Cirugia> cirugias = new ArrayList<Cirugia>();
		 	Cirugia ciru;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugias.executeQuery();
	    		while(result.next())
	    		{  
	    			ciru = new Cirugia();
	    			
	    			ciru.setClienteRut(result.getString(1).trim());
	    			ciru.setMascotaNombre(result.getString(2).trim());
	    			ciru.setHora(result.getString(3).trim());
	    			ciru.setDiagnostico(result.getString(4).trim());
	    			ciru.setVeterinario(result.getString(5).trim());
	    			ciru.setServicio(result.getString(6).trim());
	    			ciru.setFecha(result.getString(8).trim());

	    			String rut2 = ciru.getClienteRut();
	    			String nombre2 = ciru.getMascotaNombre();
	    			
	    			if(rut2.equals(rut) && nombre2.equals(nombre))
	    			{
	    				cirugias.add(ciru);
	    			}
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	 }
	 
	 /**
	  * Anula todas las cirugias solicitadas por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha anulado correctamente y 0 de lo contrario
	  * @author  "Esteban Cruz"
	  */
	 public int anularCirugia(String nombre, String fecha, String hora)
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
	  * Elimina todas las cirugias solicitadas por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha elimina correctamente y 0 de lo contrario
	  * @author  "Esteban Cruz"
	  */
	 public int eliminarCirugia(String nombre, String fecha, String hora)
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