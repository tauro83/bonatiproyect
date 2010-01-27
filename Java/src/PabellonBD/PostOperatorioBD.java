//=======================================================================
// FECHA CREACIÓN: 14/10/09
// AUTOR: Erwin Díaz
// Clase que ejecuta las consultas a la base de datos
//=======================================================================

package PabellonBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.PostOperatorio;

public class PostOperatorioBD {
	
	PreparedStatement selectAllPostoperatorio;
	PreparedStatement selectAllElim;
	PreparedStatement selectAllPostoperatorio2;
	PreparedStatement selectAllPostNull;
	PreparedStatement elimReg;
	PreparedStatement anulReg;
	PreparedStatement insert;
	PreparedStatement selectAllVacunaciones;
	PreparedStatement addEstadisticas;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public PostOperatorioBD(Connection connection)
	{
		try 
		{
			String query="";

			query = "SELECT mascota.nombre, mascota.raza, mascota.sexo, " +
			"clientepresencial.nombre, clientepresencial.apaterno, clientepresencial.rut " +
			"FROM mascota, clientepresencial, atencionpostoperatorio " +
			"WHERE clientepresencial.rut = atencionpostoperatorio.rut and " +
			"mascota.rut = atencionpostoperatorio.rut and mascota.nombre = atencionpostoperatorio.nombremascota and " +
			"atencionpostoperatorio.estado = '2';";
	
			selectAllElim = connection.prepareStatement(query);
			
			query = "SELECT mascota.nombre, mascota.raza, mascota.sexo, " +
			"clientepresencial.nombre, clientepresencial.apaterno, clientepresencial.rut " +
			"FROM mascota, clientepresencial, atencionpostoperatorio " +
			"WHERE clientepresencial.rut = atencionpostoperatorio.rut and " +
			"mascota.rut = atencionpostoperatorio.rut and mascota.nombre = atencionpostoperatorio.nombremascota and " +
			"atencionpostoperatorio.estado = '0';";
			selectAllPostoperatorio = connection.prepareStatement(query);
			
			query = "SELECT atencionpostoperatorio.indicaciones, atencionpostoperatorio.hora, atencionpostoperatorio.fecha " +
					"FROM atencionpostoperatorio " +
					"WHERE atencionpostoperatorio.nombremascota = ? and atencionpostoperatorio.rut = ? and atencionpostoperatorio.estado = 2;";
			
			selectAllPostoperatorio2 = connection.prepareStatement(query);
			
			query = "SELECT atencionpostoperatorio.indicaciones, atencionpostoperatorio.hora, atencionpostoperatorio.fecha " +
			"FROM atencionpostoperatorio " +
			"WHERE atencionpostoperatorio.nombremascota = ? and atencionpostoperatorio.rut = ? and atencionpostoperatorio.estado = 0;";
	
			selectAllPostNull = connection.prepareStatement(query);
			
			query = "UPDATE atencionpostoperatorio "+
			   "SET estado = '1' " +
			   "WHERE atencionpostoperatorio.hora = ? and " +
			   "atencionpostoperatorio.rut = ? and atencionpostoperatorio.nombremascota = ?;";
			elimReg = connection.prepareStatement(query);
			
			query = "UPDATE atencionpostoperatorio "+
			   "SET estado = '2' " +
			   "WHERE atencionpostoperatorio.hora = ? and atencionpostoperatorio.fecha = ? and " +
			   "atencionpostoperatorio.rut = ? and atencionpostoperatorio.nombremascota = ?; " +
			   "INSERT INTO bitacorapost(clienterut, nombreMascota, fechaA, usuarioA, motivo, hora) "+
			   "VALUES (?,?,?,?,?,?);";
			anulReg = connection.prepareStatement(query);
		
			query = "INSERT INTO atencionpostoperatorio(hora, fecha, nombremascota, rut, costo, indicaciones) "+
			   "VALUES(?, ?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			query = "SELECT clienterut, nombremascota, fechaa, usuarioa, motivo, hora " +
			"FROM bitacorapost;";
	         selectAllVacunaciones = connection.prepareStatement(query);

	         	query="INSERT INTO estadisticasclinica("+
	            "tipo, fecha, area)"+
				" VALUES (?, ?, ?);";
			addEstadisticas = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public int AddPostOpeBD(PostOperatorio pos)
    {
		String result = null;
		try 
    	{
			insert.setString(1, pos.shora);
			insert.setString(2, pos.stfecha);
			insert.setString(3, pos.nombreMascota);
			insert.setString(4, pos.clienterut);
			insert.setString(5, pos.costo);
			insert.setString(6, pos.indicaciones);
			
			//agregando datos a estadisticas
			String[] l =pos.stfecha.split("/");
			Date date = new Date(Integer.parseInt(l[2])-1900, Integer.parseInt(l[1])-1, Integer.parseInt(l[0]));
			addEstadisticas.setInt(1, 1);
			addEstadisticas.setDate(2, date);
			addEstadisticas.setInt(3, 2);
			addEstadisticas.executeUpdate();
			
			//
			result=""+insert.executeUpdate();
			
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	if(result.length()==1){
    		return 1;
    		
    	}
    	else {
    		return   0;  	
		}
    	
    }
	
	
	
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	public int anulAtencionBD(String hora, String fecha, String rut, String nomMascota, String motivo)
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
    		
    		PostOperatorio vacu = new PostOperatorio();
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
			
			
			System.out.println("usuario: "+usuarioAA+" motivo: "+motivoAA);
   		
			anulReg.setString(1, hora);
    		anulReg.setString(2, fecha);    		
    		anulReg.setString(3, rut);
    		anulReg.setString(4, nomMascota);
    		anulReg.setString(5, rut);
    		anulReg.setString(6, nomMascota);
    		anulReg.setString(7, fecha2);
    		anulReg.setString(8, usuarioAA);
    		anulReg.setString(9, motivoAA);
    		anulReg.setString(10, h2);
    		anulReg.executeQuery();
    		
    		System.out.println("usuario: "+usuarioAA+" motivo: "+motivoAA);
       		
    		result= anulReg.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List getAllPostNullBD(String nombreMascota, String clienterut)
	    {	
	    	List postOperatorios = new ArrayList();
	    	PostOperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result;
	    		
	    		selectAllPostNull.setString(1, nombreMascota);
	    		selectAllPostNull.setString(2, clienterut);
	    		
	    		result = selectAllPostNull.executeQuery();
				
	    		while(result.next())
	    		{  
	    			postOperatorio = new PostOperatorio();
	    			postOperatorio.indicaciones = result.getString(1).trim();
	    			postOperatorio.shora = result.getString(2).trim();
	    			postOperatorio.stfecha = result.getString(3).trim();
	    			postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
	    }
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	public int elimAtencionBD(String hora, String rut, String nomMascota)
    {
    	int result=0;
    	try 
    	{
    		elimReg.setString(1, hora);
    		elimReg.setString(2, rut);
    		elimReg.setString(3, nomMascota);
    		elimReg.executeQuery();
    		result= elimReg.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List  getAllPostOperatorio2BD(String nombreMascota, String clienterut)
	    {	
	    	List postOperatorios = new ArrayList ();
	    	PostOperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result;
	    		
	    		selectAllPostoperatorio2.setString(1, nombreMascota);
	    		selectAllPostoperatorio2.setString(2, clienterut);
	    		
	    		result = selectAllPostoperatorio2.executeQuery();
				
	    		while(result.next())
	    		{  
	    			postOperatorio = new PostOperatorio();
	    			postOperatorio.indicaciones = result.getString(1).trim();
	    			postOperatorio.shora = result.getString(2).trim();
	    			postOperatorio.stfecha = result.getString(3).trim();
	    			postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
	    }
	
	 /**
		 * Trata de obtener todos las cirugías registrados en la base de datos
		 * @return Lista con todas las cirugías registradas
		 */
		 public List  getAllPostOperatorioAnulBD()
		    {	
		    	List  postOperatorios = new ArrayList();
		    	PostOperatorio postOperatorio;
		    	try 
		    	{
		    		ResultSet result = selectAllElim.executeQuery();
		    		while(result.next())
		    		{  
		    			postOperatorio = new PostOperatorio();
		    			postOperatorio.nombreMascota = result.getString(1).trim();
		    			postOperatorio.raza = result.getString(2).trim();
		    			postOperatorio.sexo = result.getString(3).trim();
		    			postOperatorio.nombreCliente = result.getString(4).trim();
		    			postOperatorio.apellido = result.getString(5).trim();
		    			postOperatorio.clienterut = result.getString(6).trim();
		    			if(!isInList(postOperatorios,postOperatorio))
		    				postOperatorios.add(postOperatorio);
		    			
		    		}
				} 
		    	catch (SQLException e) 
		    	{
					e.printStackTrace();
				}
		    	return postOperatorios;
		    }
	/**
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List getAllPostOperatorioBD()
	    {	
	    	List postOperatorios = new ArrayList();
	    	PostOperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result = selectAllPostoperatorio.executeQuery();
	    		while(result.next())
	    		{  
	    			postOperatorio = new PostOperatorio();
	    			postOperatorio.nombreMascota = result.getString(1).trim();
	    			postOperatorio.raza = result.getString(2).trim();
	    			postOperatorio.sexo = result.getString(3).trim();
	    			postOperatorio.nombreCliente = result.getString(4).trim();
	    			postOperatorio.apellido = result.getString(5).trim();
	    			postOperatorio.clienterut = result.getString(6).trim();
	    			if(!isInList(postOperatorios,postOperatorio))
	    				postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
	    }
	 
	 public boolean isInList(List lista, PostOperatorio pos){
			boolean value= false;
			PostOperatorio p;
			for (int i=0;i<lista.size();i++){
				p = (PostOperatorio)lista.get(i);
				//System.out.println(p.clienterut+" "+pos.clienterut+"  "+p.nombreMascota+" "+pos.nombreMascota);
				if(p.clienterut.compareTo(pos.clienterut)==0 && p.nombreMascota.compareTo(pos.nombreMascota)==0){
					value=true;
				}
					
			}
			
			return value;
		}


	public List getAllPostOperatorioActivoBD() {
		// TODO Auto-generated method stub
		return null;
	}

        public List getAllVacunacionesV()
	 {
		 	List vacunaciones = new ArrayList();
		 	PostOperatorio vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new PostOperatorio();
	    			vacu.clienterut = result.getString(1).trim();
	    			vacu.nombreMascota = result.getString(2).trim();
	    			vacu.fechaA = result.getString(3).trim();
	    			vacu.usuarioA = result.getString(4).trim();
	    			vacu.motivo = result.getString(5).trim();
	    			vacu.shora = result.getString(6).trim();
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
