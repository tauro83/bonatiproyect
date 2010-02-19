//=======================================================================
// FECHA: CREACIÓN: 10-11-09
// AUTOR: Esteban Cruz
// Script para anular o eliminar un catálogo desde la base de datos, además,
// dentro de esta se puede buscar el listado de todos los catálogos existentes
//=======================================================================

package PeluqueriaBD;

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
import TransferObjects.PostOperatorio;

public class AECatPeluqueriaBD {
	
	PreparedStatement bitacora;
	PreparedStatement selectAllCatalogos;
	PreparedStatement selectAllCatalogosAnul;
	PreparedStatement selectAllCatalogosTodo;
	PreparedStatement selectAllDatos;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 * @author "Esteban Cruz"
	 */
	public AECatPeluqueriaBD(Connection connection)
	{
		try 
		{
			String query="";
			query = "INSERT INTO bitacoracatpel(nombre, servicio, fechaA, usuarioA, motivo, hora) "+
			   		"VALUES (?,?,?,?,?,?);";
			bitacora = connection.prepareStatement(query);
			
			query = "SELECT nombre, servicio, fechaA, usuarioA, motivo, hora " +
					"FROM bitacoracatpel;";
			selectAllDatos = connection.prepareStatement(query);
			
			query = "SELECT nombre, servicio, precio, descripcion, estado " +
					"FROM catpeluqueria " +
					"WHERE estado = 0;";
			selectAllCatalogos = connection.prepareStatement(query);
			
			query = "SELECT nombre, servicio, precio, descripcion, estado " +
					"FROM catpeluqueria " +
					"WHERE estado = 2;";
			selectAllCatalogosAnul = connection.prepareStatement(query);
			
			query = "SELECT nombre, servicio, precio, descripcion, estado " +
					"FROM catpeluqueria " +
					"WHERE estado != 1;";
			selectAllCatalogosTodo = connection.prepareStatement(query);
			
			query = "UPDATE catpeluqueria " +
					"SET estado = ?, motivo = ? " + 
					"WHERE nombre = ? AND servicio = ?;";
			setEstado = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Trata de obtener todos los catalogos registrados en la base de datos
	 * @return Lista con todos los catalogos registrados
	 * @author "Esteban Cruz"
	 */
	 public List getAllCatalogos()
	    {	
	    	List catalogos = new ArrayList();
	    	CatPeluqueria cata;
	    	try 
	    	{
	    		ResultSet result = selectAllCatalogos.executeQuery();
	    		while(result.next())
	    		{  
	    			cata = new CatPeluqueria();
	    			
	    			cata.setNombre(result.getString(1).trim());
	    			cata.setServicio(result.getString(2).trim());
	    			cata.setPrecio(result.getString(3).trim());
	    			cata.setDescripcion(result.getString(4).trim());
	    				
	    			catalogos.add(cata);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return catalogos;
	    }
	 
	 public List getAllCatalogosAnul()
	    {	
	    	List catalogos = new ArrayList();
	    	CatPeluqueria cata;
	    	try 
	    	{
	    		ResultSet result = selectAllCatalogosAnul.executeQuery();
	    		while(result.next())
	    		{  
	    			cata = new CatPeluqueria();
	    			
	    			cata.setNombre(result.getString(1).trim());
	    			cata.setServicio(result.getString(2).trim());
	    			cata.setPrecio(result.getString(3).trim());
	    			cata.setDescripcion(result.getString(4).trim());
	    				
	    			catalogos.add(cata);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return catalogos;
	    }
	 
	 public List getAllCatalogosTodo()
	    {	
	    	List catalogos = new ArrayList();
	    	CatPeluqueria cata;
	    	try 
	    	{
	    		ResultSet result = selectAllCatalogosTodo.executeQuery();
	    		while(result.next())
	    		{  
	    			cata = new CatPeluqueria();
	    			
	    			cata.setNombre(result.getString(1).trim());
	    			cata.setServicio(result.getString(2).trim());
	    			cata.setPrecio(result.getString(3).trim());
	    			cata.setDescripcion(result.getString(4).trim());
	    			
	    			cata.setEstado(result.getString(5).trim());
	    			String estado = cata.getEstado();
	    			
	    			if(cata.getEstado().compareTo("0")==0){
	    				cata.setEstado("Válido");
	    			}
	    			if(cata.getEstado().compareTo("2")==0){
	    				cata.setEstado("Nulo");
	    			}
	    			
	    			catalogos.add(cata);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return catalogos;
	    }
	 
	 /**
	  * Anula todos los catalogos solicitados por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha anulado correctamente y 0 de lo contrario
	  * @author "Esteban Cruz"
	  */
	 public int anular(CatPeluqueria cata)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 2);
			setEstado.setString(2, cata.getMotivo());
			setEstado.setString(3, cata.getNombre());
			setEstado.setString(4, cata.getServicio());
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 /**
	  * Elimina todos los catalogos solicitados por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha elimina correctamente y 0 de lo contrario
	  * @author "Esteban Cruz"
	  */
	 public int eliminar(CatPeluqueria cata)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 1);
			setEstado.setString(2, cata.getNombre());
			setEstado.setString(3, cata.getServicio());
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 public int regBit(String nombre, String servicio, String motivo)
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
	    		bitacora.setString(2, servicio);    		
	    		bitacora.setString(3, fecha2);
	    		bitacora.setString(4, usuarioAA);
	    		bitacora.setString(5, motivoAA);
	    		bitacora.setString(6, h2);
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
	    	List catalogos = new ArrayList();
	    	CatPeluqueria cata;
	    	try 
	    	{
	    		ResultSet result = selectAllDatos.executeQuery();
	    		while(result.next())
	    		{  
	    			cata = new CatPeluqueria();
	    			
	    			cata.setNombre(result.getString(1).trim());
	    			cata.setServicio(result.getString(2).trim());
	    			cata.setFechaA(result.getString(3).trim());
	    			cata.setUsuarioA(result.getString(4).trim());
	    			cata.setMotivo(result.getString(5).trim());
	    			cata.setHora(result.getString(6).trim());
	    				
	    			catalogos.add(cata);
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return catalogos;
	    }
}
