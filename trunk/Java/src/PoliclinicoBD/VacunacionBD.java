//=======================================================================
// FECHA: CREACIÓN: 27-10-09
// AUTOR: Esteban Cruz
// Clase para anular o eliminar una vacunacion desde la base de datos, además, 
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package PoliclinicoBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.CatPeluqueria;
import TransferObjects.Vacunacion;
import TransferObjects.Cliente;
import TransferObjects.Mascota;

public class VacunacionBD {
	
	PreparedStatement selectAllDatos;
	PreparedStatement bitacora;
	PreparedStatement selectAllVacunacionesTodo;
	PreparedStatement selectAllVacunacionesAnul;
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
			
			query = "INSERT INTO bitacoravac(nombre, rut, horai, fechaA, usuarioA, motivo, hora) " +
					"VALUES (?,?,?,?,?,?,?);";
			bitacora = connection.prepareStatement(query);

			query = "SELECT nombre, rut, fechaA, usuarioA, motivo, hora " +
					"FROM bitacoravac;";
			selectAllDatos = connection.prepareStatement(query);
	
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"descripcion, responsable, servicio, estado, fecha " +
					"FROM vacunacion " +
					"WHERE estado = 0;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"descripcion, responsable, servicio, estado, fecha " +
					"FROM vacunacion " +
					"WHERE estado = 2;";
			selectAllVacunacionesAnul = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"descripcion, responsable, servicio, estado, fecha " +
					"FROM vacunacion " +
					"WHERE estado != 1;";
			selectAllVacunacionesTodo = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"descripcion, responsable, servicio, estado, fecha " +
					"FROM vacunacion " +
					"WHERE estado = 0;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			queryCliente = "SELECT nombre, apaterno, rut "+
							"FROM clientepresencial "+
							"WHERE rut = ? ;";
			selectAllClientes = connection.prepareStatement(queryCliente);
			
			queryMascota = "SELECT raza, sexo "+
							"FROM mascota "+
							"WHERE nombre = ? AND rut = ? ;";
			selectAllMascotas = connection.prepareStatement(queryMascota);
			
			query = "UPDATE vacunacion " +
					"SET estado = ?, motivo = ? " + 
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
	    	List ruts = new ArrayList();
	    	List names = new ArrayList();
	    	Vacunacion vacu;
	    	Cliente clie;
	    	Mascota masc;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			String rut=null, name=null;
	    			vacu = new Vacunacion();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
	    			vacu.setClienteRut(result.getString(1).trim());
	    			rut = vacu.getClienteRut();
	    			vacu.setMascotaNombre(result.getString(2).trim());
	    			name = vacu.getMascotaNombre();
	    			
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
	    			if(!ruts.contains(rut) || !names.contains(name) ){
	    				vacunaciones.add(vacu);	
	    			}
	    			names.add(name);
	    			ruts.add(rut);
	    		}
	    		
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	    }
	 
	 public List getAllVacunacionesAnul()
	    {	
	    	List vacunaciones = new ArrayList();
	    	List ruts = new ArrayList();
	    	List names = new ArrayList();
	    	Vacunacion vacu;
	    	Cliente clie;
	    	Mascota masc;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunacionesAnul.executeQuery();
	    		while(result.next())
	    		{  
	    			String rut=null, name=null;
	    			vacu = new Vacunacion();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
	    			vacu.setClienteRut(result.getString(1).trim());
	    			rut = vacu.getClienteRut();
	    			vacu.setMascotaNombre(result.getString(2).trim());
	    			name = vacu.getMascotaNombre();
	    			
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
	    			if(!ruts.contains(rut) || !names.contains(name) ){
	    				vacunaciones.add(vacu);	
	    			}
	    			names.add(name);
	    			ruts.add(rut);
	    		}
	    		
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	    }
	 
	 public List getAllVacunacionesTodo()
	    {	
	    	List vacunaciones = new ArrayList();
	    	List ruts = new ArrayList();
	    	List names = new ArrayList();
	    	List estados = new ArrayList();
	    	Vacunacion vacu;
	    	Cliente clie;
	    	Mascota masc;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunacionesTodo.executeQuery();
	    		while(result.next())
	    		{  
	    			String rut=null, name=null;
	    			vacu = new Vacunacion();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
	    			vacu.setClienteRut(result.getString(1).trim());
	    			rut = vacu.getClienteRut();
	    			vacu.setMascotaNombre(result.getString(2).trim());
	    			name = vacu.getMascotaNombre();
	    			
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
	    			
	    			vacu.setEstado(result.getString(7).trim());
	    			String estado = vacu.getEstado();
	    			
	    			if(!ruts.contains(rut) || !names.contains(name) || !estados.contains(estado)){
	    				vacunaciones.add(vacu);	
	    				names.add(name);
		    			ruts.add(rut);
		    			estados.add(estado);
	    			}
	    			
	    			if(vacu.getEstado().compareTo("0")==0){
	    				vacu.setEstado("Válido");
	    			}
	    			if(vacu.getEstado().compareTo("2")==0){
	    				vacu.setEstado("Nulo");
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
	 
	 public List getAllVacunacionesU2(String rut, String nombre)
	 {
		 	List vacunaciones = new ArrayList();
		 	Vacunacion vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunacionesAnul.executeQuery();
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
	 public int anular(String nombre, String fecha, String hora, String motivo)
	 {
		 int result = 0;
		 try {
			 System.out.println("MOTIVO=== "+motivo);
			setEstado.setInt(1, 2);
			setEstado.setString(2, motivo);
			setEstado.setString(3, nombre);
			setEstado.setString(4, fecha);
			setEstado.setString(5, hora);
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
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 public int regBit(String nombre, String rut, String id, String motivo)
	    {
	    	int result=0;
	    	try 
	    	{
	    		Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR)-1900;
				int month = c.get(Calendar.MONTH);
				int day = c.get(Calendar.DAY_OF_MONTH);
				Date date = new Date(year,month, day);
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String fecha2 = formatter.format(date); 
				int hora2 = c.get(Calendar.HOUR_OF_DAY);
	    		int minutos = c.get(Calendar.MINUTE);
	    		int segundos = c.get(Calendar.SECOND);
	    		
	    		String h2 = "";
	    		String horastring, minstring, secstring;
	    		horastring = hora2+"";
	    		minstring = minutos+"";
	    		secstring = segundos+"";
	    		
	    		if (hora2<10){
	    			horastring = "0"+hora2;
	    		}
	    		if(minutos<10){
	    			minstring = "0"+minutos;
	    		}
	    		if(segundos<10){
	    			secstring = "0"+segundos;
	    		}
	    		
	    		h2 =horastring+":"+minstring+":"+secstring;
	    		
	    		int i=0;
	    		String v = motivo;
	    		String h = v.substring(i,i+1);
				String palabra="";
				int bandera=2;
				while(!h.equals(" ") && bandera!=1 && i<v.length()){
					palabra=palabra+h;
					if(i+1<v.length() && i<v.length()){
						i++;
	    				h=v.substring(i,i+1);
	    				bandera=0;
					}
					else{
						bandera=1;
					}
				}
				
				if(bandera==2){
					palabra=palabra+h;
				}
				String usuarioAA= palabra;
				
				h = v.substring(i,i+1);
				palabra="";
				
				while(i<v.length() && i+1<v.length()){
					palabra=palabra+h;
					i++;
					h=v.substring(i,i+1);
				}
				h=v.substring(i,i+1);
				palabra=palabra+h;
				String motivoAA = palabra;
				
				bitacora.setString(1, nombre);
	    		bitacora.setString(2, rut);    		
	    		bitacora.setString(3, id);
	    		bitacora.setString(4, fecha2);
	    		bitacora.setString(5, usuarioAA);
	    		bitacora.setString(6, motivoAA);
	    		bitacora.setString(7, h2);
	    		bitacora.executeQuery();
	       		
	    		result= bitacora.executeUpdate();
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return result;
	    }
	 
	 public List getAllDatos()
	    {	
	    	List vacunaciones = new ArrayList();
	    	Vacunacion vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllDatos.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new Vacunacion();
	    			
	    			vacu.setMascotaNombre(result.getString(1).trim());
	    			vacu.setClienteRut(result.getString(2).trim());
	    			vacu.setFechaA(result.getString(3).trim());
	    			vacu.setUsuarioA(result.getString(4).trim());
	    			vacu.setMotivo(result.getString(5).trim());
	    			vacu.setHora(result.getString(6).trim());
	    				
	    			vacunaciones.add(vacu);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
	    }
}
