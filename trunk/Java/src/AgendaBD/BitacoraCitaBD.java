//=======================================================================
// AUTOR: Sebastian Arancibia
// Descripcion: Clase entidad DiaAgendaDB de sistema, que se comunica con la base de datos 
//				Solo contiene los metodos para hacer get/set de los atributos en la base de datos.
//=======================================================================

package AgendaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.io.StringReader; 

import TransferObjects.Mascota;
import Agenda.BitacoraCita;
/**
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class BitacoraCitaBD
{

	PreparedStatement selectAll, insert, eliminar, ocultar, eliminarAll;
	Connection conn;
	
	
	/**
	 * 
	 * @langversion Java
	 * @author Sebastian Arancibia
	 * @version 1 05/10/2009
	 */
	public BitacoraCitaBD(Connection connection)
	{
		conn = connection;
		try 
		{	//Declaraciones de consultas para la base de datos
			String query="";			
			query = "SELECT usuario, accion, fechaaccion, horaaccion, fechaacita, horacita, cliente, mascota, servicio  FROM bitacora WHERE estado = 'TRUE';";
			selectAll = connection.prepareStatement(query);
			
			
			query = "INSERT INTO bitacora(usuario, accion, fechaaccion, horaaccion, fechaacita, horacita,cliente, mascota, servicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
			
			query = "UPDATE bitacora " +
			   		"SET estado='FALSE' " +
			   		"WHERE fechaaccion = ?;";

			ocultar = connection.prepareStatement(query);
			
			query = "DELETE FROM bitacora WHERE estado = 'FALSE';";
			
			eliminar = connection.prepareStatement(query);
			
			query = "truncate bitacora;";
			
			eliminarAll = connection.prepareStatement(query);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * @param fecha
	 * @return Lista de DiaAgenda pertenecientes a la fecha
	 */
    public List getBitacoraCitaBD()
    {
    		
    	List bitacoras=new ArrayList();
    	BitacoraCita bitacora;
    	try 
    	{
			Calendar c = Calendar.getInstance();
    		int dia = c.get(Calendar.DATE);
    		int mes = c.get(Calendar.MONTH);
    		int ano = c.get(Calendar.YEAR);
    		
    		
    		String actualfech = "";
    		
    		actualfech += (ano + "");
			
    		if(mes < 10){
				actualfech += "0";
			}
			actualfech += (mes+1);
			
			if(dia < 10){
				actualfech += "0";
			}
			actualfech += dia;
    		
    		
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			bitacora= new BitacoraCita();
    			
    			bitacora.usuario = result.getString(1).trim();
    			bitacora.accion = result.getString(2).trim();
    			bitacora.fechaAccion = result.getString(3).trim();
    			bitacora.horaAccion = result.getString(4).trim();
    			bitacora.fechaCita = result.getString(5).trim();
    			bitacora.horaCita = result.getString(6).trim();
    			bitacora.cliente = result.getString(7).trim();
    			bitacora.mascota = result.getString(8).trim();
    			bitacora.servicio = result.getString(9).trim();
    			
    			bitacoras.add(bitacora);
    			
    			//System.out.println(bitacora.fechaAccion + "--");
    			String [] datos = bitacora.fechaAccion.split("/");
    			String fech = "";
    			
    			for(int i = datos.length-1; i >= 0; i--){
    				//System.out.print(datos[i]);
    				
    				if(i<=1 && Integer.parseInt(datos[i]) < 10){
    					fech += "0" + datos[i];
    				}
    				else{
    					fech += datos[i];
    				}
    			}
    			
    			
    			/*if(Integer.parseInt(actualfech) - Integer.parseInt(fech) > 20000){// 2 Anios 
    				ocultar.setString(1, bitacora.fechaAccion);
        			ocultar.executeUpdate();
        	
    			}
    		
    			//Funcion para eliminar pero no funciona
    			if(Integer.parseInt(actualfech) - Integer.parseInt(fech) > 20000){// 5 Anios 
    				eliminar.executeUpdate();

    			}*/
    		

    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return bitacoras;
    	
    	
    }
	/**
	 * Ingresa a una nueva BitacoraCita a la base de datos
	 * @autor Sebastian Arancibia
	 * @param bc contiene los datos de la bitacoraCita que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int addBitacoraCitaBD(BitacoraCita bc){
    	int result=0;
    	try{

			insert.setString(1, bc.usuario);
			insert.setString(2, bc.accion);
			insert.setString(3, bc.getFechaAccion());
			insert.setString(4, bc.horaAccion);
			insert.setString(5, bc.getFechaCita());
			insert.setString(6, bc.horaCita);
			insert.setString(7, bc.getCliente());
			insert.setString(8, bc.getMascota());
			insert.setString(9, bc.getServicio());
			
			result = insert.executeUpdate();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
        
	public int respaldarBitacora(int anos){
    	BitacoraCita b;
    	int resultado = 0;

    	try 
    	{
			Calendar c = Calendar.getInstance();
    		int dia = c.get(Calendar.DATE);
    		int mes = c.get(Calendar.MONTH);
    		int ano = c.get(Calendar.YEAR);
    		
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int min = c.get(Calendar.MINUTE);
    		int seg = c.get(Calendar.SECOND);
    		
    		
    		String actualfech = "";
    		
    		actualfech += (ano + "");
			
    		if(mes < 10){
				actualfech += "0";
			}
			actualfech += (mes+1);
			
			if(dia < 10){
				actualfech += "0";
			}
			actualfech += dia;

	    	String d = "c:/RespaldoBD/BitacoraAgenda";
	    	String sFichero = d + "/"+ actualfech+" "+hora+min+seg+ ".txt";
	    	
	    	File directorio = new File(d);
	    	if (directorio.mkdirs()) 
	    		System.out.println("Se ha creado directorio");

			
			ResultSet result = selectAll.executeQuery();
			
			try{
				BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
				bw.write(" FechaAccion - Hora Accion - Usuario - Accion - FechaCita - HoraCita - Cliente - Mascota - Servicio\n\n");
		    	while(result.next()){
		    			b= new BitacoraCita();
		    			
		    			b.usuario = result.getString(1).trim();
		    			b.accion = result.getString(2).trim();
		    			b.fechaAccion = result.getString(3).trim();
		    			b.horaAccion = result.getString(4).trim();
		    			b.fechaCita = result.getString(5).trim();
		    			b.horaCita = result.getString(6).trim();
		    			b.cliente = result.getString(7).trim();
		    			b.mascota = result.getString(8).trim();
		    			b.servicio = result.getString(9).trim();
		    			
		    			
		    			
		    			String [] datos = b.fechaAccion.split("/");
		    			String fech = "";
		    			
		    			for(int i = datos.length-1; i >= 0; i--){
		    				//System.out.print(datos[i]);
		    				
		    				if(i<=1 && Integer.parseInt(datos[i]) < 10){
		    					fech += "0" + datos[i];
		    				}
		    				else{
		    					fech += datos[i];
		    				}
		    			}
		    			
		    			
		    			if(Integer.parseInt(actualfech) - Integer.parseInt(fech) > (anos * 10000)){// 2 Anios 
		    				ocultar.setString(1, b.fechaAccion);
		        			ocultar.executeUpdate();
		        	
		    			}
		    		
		    			//Funcion para eliminar pero no funciona
		    			if(Integer.parseInt(actualfech) - Integer.parseInt(fech) > (anos * 10000)){// 5 Anios 
		    				eliminar.executeUpdate();
		    				resultado = eliminar.executeUpdate();
		    				
			    	    	bw.write(b.fechaAccion 	+ " - " + 
			    					b.horaAccion 	+ " - " +
			    					b.usuario 	 	+ " - " +
			    					b.accion 	    + " - " +
			    					b.fechaCita	 	+ " - " +
			    					b.horaCita	 	+ " - " +
			    					b.cliente		+ " - " +
			    					b.mascota		+ " - " +
			    					b.servicio	    +
			    					"\n");

		    			}
		    			
		    		}
				  bw.close();
				  
				  
	    		//eliminarAll.executeQuery();
	    			
	    		//resultado = eliminarAll.executeUpdate();
				  
			} catch (IOException ioe){
			ioe.printStackTrace();
			}
    	}
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return resultado;
    } 	
}