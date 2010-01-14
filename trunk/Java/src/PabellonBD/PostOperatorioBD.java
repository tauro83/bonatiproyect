//=======================================================================
// FECHA CREACI�N: 14/10/09
// AUTOR: Erwin D�az
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
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexi�n obtenida con la base de datos
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
			"atencionpostoperatorio.estado = '0';";
	
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
					"WHERE atencionpostoperatorio.nombremascota = ? and atencionpostoperatorio.rut = ? and atencionpostoperatorio.estado = 0;";
			
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
			   "SET estado = '1', motivo = ? " +
			   "WHERE atencionpostoperatorio.hora = ? and " +
			   "atencionpostoperatorio.rut = ? and atencionpostoperatorio.nombremascota = ?;";
			anulReg = connection.prepareStatement(query);
		
			query = "INSERT INTO atencionpostoperatorio(hora, fecha, nombremascota, rut, costo, indicaciones) "+
			   "VALUES(?, ?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			query = "SELECT rut, " +
			"nombremascota, " +
			"motivo, estado " +
			"FROM atencionpostoperatorio;";
	         	selectAllVacunaciones = connection.prepareStatement(query);

			
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
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
	 */
	public int anulAtencionBD(String hora, String rut, String nomMascota, String motivo)
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
			String fecha = formatter.format(date); 
    		
			anulReg.setString(1,fecha+" "+motivo);
    		anulReg.setString(2, hora);    		
    		anulReg.setString(3, rut);
    		anulReg.setString(4, nomMascota);
    		anulReg.executeQuery();
    		result= anulReg.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	/**
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
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
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
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
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
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
		 * Trata de obtener todos las cirug�as registrados en la base de datos
		 * @return Lista con todas las cirug�as registradas
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
	 * Trata de obtener todos las cirug�as registrados en la base de datos
	 * @return Lista con todas las cirug�as registradas
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
	    			postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
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
	    		 * Inicializa la consulta sql de la tabla de peluquer�a.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new PostOperatorio();
	    			
	    			vacu.setRut(result.getString(1).trim());	
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			
	    			String v=result.getString(3).trim();
	    			vacu.setEstado(result.getInt(4));
	    			int i=0;
	    			String h=v.substring(0,1);
	    			String palabra="";
	    			
	    			while(!h.equals(" ")){
	    				palabra=palabra+h;
	    				i++;
	    				h=v.substring(i,i+1);
	    			}
	    			//System.out.println("F: "+palabra);
	    			vacu.setFechaA(palabra);
	    			
	    			h=v.substring(i+1,i+2);
	    			//System.out.println("P: "+h);
	    			palabra="";
	    			i++;
	    			int bandera=2;
	    			
	    			while(!h.equals("") && bandera!=1 && i<v.length()){
	    				//System.out.println("Xaoooo");
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
	    			
	    			
	    			//System.out.println("U: "+palabra);
	    			vacu.setUsuarioA(palabra);
	    			
	    			
	    			int estado2 = vacu.getEstado();
	    			
	    			
	    			/**
	    			 * Esta condicci�n se encarga de buscar todos los registro de peluquer�a 
	    			 * que posean estado 1.
	    			 */
	    			if(estado2==1)
	    			{
	    				System.out.println("hola ");
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
	 
}
