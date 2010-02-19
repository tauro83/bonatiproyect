//=======================================================================
// FECHA: CREACIÓN: 14-10-09
// AUTOR: Esteban Cruz
// Clase para anular o eliminar una cirugía desde la base de datos, además, 
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package PabellonBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.CatPeluqueria;
import TransferObjects.Cirugia;
import TransferObjects.Cliente;
import TransferObjects.Mascota;

public class CirugiaBD {
	
	PreparedStatement selectAllDatos;
	PreparedStatement bitacora;
	PreparedStatement selectAllCirugiasTodo;
	PreparedStatement selectAllCirugiasAnul;
	PreparedStatement selectAllCirugiasU;
	PreparedStatement selectAllCirugias;
	PreparedStatement selectAllClientes;
	PreparedStatement selectAllMascotas;
	PreparedStatement setEstado;
	String query="";
	Connection connection2;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 * @author  "Esteban Cruz"
	 */
	public CirugiaBD(Connection connection)
	{
		try 
		{
			String queryCliente="", queryMascota="";
			connection2 = connection;
			
			query = "INSERT INTO bitacoracir(nombre, rut, horai, fechaA, usuarioA, motivo, hora) " +
	   				"VALUES (?,?,?,?,?,?,?);";
			bitacora = connection.prepareStatement(query);
	
			query = "SELECT nombre, rut, fechaA, usuarioA, motivo, hora " +
					"FROM bitacoracir;";
			selectAllDatos = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"ayudante, responsable, servicio, estado, fecha " +
					"FROM cirugia " +
					"WHERE estado = 0;";
			selectAllCirugias = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"ayudante, responsable, servicio, estado, fecha " +
					"FROM cirugia " +
					"WHERE estado = 2;";
			selectAllCirugiasAnul = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"ayudante, responsable, servicio, estado, fecha " +
					"FROM cirugia " +
					"WHERE estado = 0;";
			selectAllCirugiasU = connection.prepareStatement(query);
			
			query = "SELECT clienterut, mascotanombre, hora, " +
					"ayudante, responsable, servicio, estado, fecha " +
					"FROM cirugia " +
					"WHERE estado != 1;";
			selectAllCirugiasTodo = connection.prepareStatement(query);
			
			queryCliente = "SELECT nombre, apaterno "+
							"FROM clientepresencial "+
							"WHERE rut = ? ;";
			selectAllClientes = connection.prepareStatement(queryCliente);
			
			queryMascota = "SELECT raza, sexo "+
							"FROM mascota "+
							"WHERE nombre = ? AND rut = ? ;";
			selectAllMascotas = connection.prepareStatement(queryMascota);
			
			
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
	 public List getAllCirugias()
	    {	
	    	List cirugias = new ArrayList();
	    	Cirugia ciru;
	    	Cliente clie;
	    	Mascota masc;
	    	List ruts = new ArrayList();
	    	List names = new ArrayList();
	    	try 
	    	{
	    		ResultSet result = selectAllCirugias.executeQuery();
	    		while(result.next())
	    		{  
	    			String rut=null, name=null;
	    			ciru = new Cirugia();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
		    		ciru.setClienteRut(result.getString(1).trim());
		    		rut = ciru.getClienteRut();
		    		ciru.setMascotaNombre(result.getString(2).trim());
		    		name = ciru.getMascotaNombre();
	    			
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
	    			if(!ruts.contains(rut) || !names.contains(name) ){
	    				cirugias.add(ciru);	
	    			}
	    			names.add(name);
	    			ruts.add(rut);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	    }
	 
	 public List getAllCirugiasAnul()
	    {	
	    	List cirugias = new ArrayList();
	    	Cirugia ciru;
	    	Cliente clie;
	    	Mascota masc;
	    	List ruts = new ArrayList();
	    	List names = new ArrayList();
	    	try 
	    	{
	    		ResultSet result = selectAllCirugiasAnul.executeQuery();
	    		while(result.next())
	    		{  
	    			String rut=null, name=null;
	    			ciru = new Cirugia();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
		    		ciru.setClienteRut(result.getString(1).trim());
		    		rut = ciru.getClienteRut();
		    		ciru.setMascotaNombre(result.getString(2).trim());
		    		name = ciru.getMascotaNombre();
	    			
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
	    			if(!ruts.contains(rut) || !names.contains(name) ){
	    				cirugias.add(ciru);	
	    			}
	    			names.add(name);
	    			ruts.add(rut);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	    }
	 
	 public List getAllCirugiasTodo()
	    {	
	    	List cirugias = new ArrayList();
	    	Cirugia ciru;
	    	Cliente clie;
	    	Mascota masc;
	    	List ruts = new ArrayList();
	    	List names = new ArrayList();
	    	List estados = new ArrayList();
	    	try 
	    	{
	    		ResultSet result = selectAllCirugiasTodo.executeQuery();
	    		while(result.next())
	    		{  
	    			String rut=null, name=null;
	    			ciru = new Cirugia();
	    			clie = new Cliente();
	    			masc = new Mascota();
	    			ResultSet cliente; 
		    		ResultSet mascota; 
	    			
		    		ciru.setClienteRut(result.getString(1).trim());
		    		rut = ciru.getClienteRut();
		    		ciru.setMascotaNombre(result.getString(2).trim());
		    		name = ciru.getMascotaNombre();
	    			
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
	    			
	    			ciru.setEstado(result.getString(7).trim());
	    			String estado = ciru.getEstado();
	    			
	    			if(!ruts.contains(rut) || !names.contains(name) || !estados.contains(estado) ){
	    				cirugias.add(ciru);
	    				names.add(name);
		    			ruts.add(rut);
		    			estados.add(estado);
	    			}
	    			
	    			if(ciru.getEstado().compareTo("0")==0){
	    				ciru.setEstado("Válido");
	    			}
	    			if(ciru.getEstado().compareTo("2")==0){
	    				ciru.setEstado("Nulo");
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
	  * Trata de obtener todos las cirugias registrados en la base de datos
	  * de un cliente determinado
	  * @return Lista con todas las cirugias registradas
	  * @author  "Esteban Cruz"
	  */
	 public ArrayList<Cirugia> getAllCirugiasU(String rut, String nombre)
	 {
		 	ArrayList <Cirugia> cirugias = new ArrayList();
		 	Cirugia ciru;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugiasU.executeQuery();
	    		while(result.next())
	    		{  
	    			ciru = new Cirugia();
	    			
	    			ciru.setClienteRut(result.getString(1).trim());
	    			ciru.setMascotaNombre(result.getString(2).trim());
	    			ciru.setHora(result.getString(3).trim());
	    			ciru.setAyudante(result.getString(4));
	    			if(ciru.getAyudante()==null){
	    				ciru.setAyudante(" ");
	    			}
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
	 
	 public ArrayList<Cirugia> getAllCirugiasU2(String rut, String nombre)
	 {
		 	ArrayList <Cirugia> cirugias = new ArrayList();
		 	Cirugia ciru;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugiasAnul.executeQuery();
	    		while(result.next())
	    		{  
	    			ciru = new Cirugia();
	    			
	    			ciru.setClienteRut(result.getString(1).trim());
	    			ciru.setMascotaNombre(result.getString(2).trim());
	    			ciru.setHora(result.getString(3).trim());
	    			ciru.setAyudante(result.getString(4));
	    			if(ciru.getAyudante()==null){
	    				ciru.setAyudante(" ");
	    			}
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
	 * @throws SQLException 
	  */
	 public int anularCirugia(String nombre, String fecha, String hora, String motivo) throws SQLException
	 {
		 //estado, nombre, fecha, hora
		 query = "UPDATE cirugia " +
			"SET estado = '2', motivo=? " + 
			"WHERE mascotanombre='"+nombre +"' and fecha='"+fecha+"' and hora='"+hora+"';";
		 setEstado = connection2.prepareStatement(query);
		 
		 int result = 0;
		 try {
			setEstado.setString(1, motivo);
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
	    	List cirugias = new ArrayList();
	    	Cirugia ciru;
	    	try 
	    	{
	    		ResultSet result = selectAllDatos.executeQuery();
	    		while(result.next())
	    		{  
	    			ciru = new Cirugia();
	    			
	    			ciru.setMascotaNombre(result.getString(1).trim());
	    			ciru.setClienteRut(result.getString(2).trim());
	    			ciru.setFechaA(result.getString(3).trim());
	    			ciru.setUsuarioA(result.getString(4).trim());
	    			ciru.setMotivo(result.getString(5).trim());
	    			ciru.setHora(result.getString(6).trim());
	    				
	    			cirugias.add(ciru);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	    }
}
