//=======================================================================
// FECHA CREACI�N: 20/11/09
// AUTOR: Erwin D�az
// Comentarios: Transfiere datos entre la base de datos hacia la
//				capa l�gica.
//=======================================================================
package Petshop;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import TransferObjects.Pago;
/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin D�az
 *
 */
public class ElimPagoBD {
	
	PreparedStatement selectAll;
	PreparedStatement selectAllE;
	PreparedStatement deletePago;
	PreparedStatement deletePagoH;
	
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexi�n obtenida con la base de datos
	 */
	public ElimPagoBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "SELECT pago.fecha, pago.hora, pago.total "+
			"FROM pago where pago.estado='0';";
			selectAll = connection.prepareStatement(query);
		
			query = "SELECT pago.fecha, pago.hora, pago.total "+
			"FROM pago where pago.estado='2';";
			selectAllE = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Elimina un usuario de la base de datos
	 * @param clave Nombre de usuario obtenido desde la capa de interf�z con el usuario
	 * @return 1 si se ha eliminado correctamente, -1 o 0 la eliminaci�n ha fallado
	 */
    public int deletePagoHBD(String fecha, String hora)
    {
    	int result=0;
    	try 
    	{
    		deletePagoH.setString(1, fecha);
    		deletePagoH.setString(2, hora);
    		deletePagoH.executeQuery();
			result= deletePagoH.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Elimina un usuario de la base de datos
	 * @param clave Nombre de usuario obtenido desde la capa de interf�z con el usuario
	 * @return 1 si se ha eliminado correctamente, -1 o 0 la eliminaci�n ha fallado
	 */
    public int deletePagoBD(Connection connection, String fecha, String hora)
    {
    	int result=0;
    	try{
    		String year = "";
        	String month = "";
        	String day = "";
        	
        	String hrs = "";
        	String min = "";
        	String sec = "";
        	
        	day = fecha.substring(0,2);
    		month = fecha.substring(3,5);
    		year = fecha.substring(6,10);
    		
    		hrs = hora.substring(0,2);
    		min = hora.substring(3,5);
    		sec = hora.substring(6,8);
    		
    		System.out.println(hrs+":"+min+":"+sec);
    		
    		String query="";	
    		query = "UPDATE pago "+
    		"SET estado='2' "+
    		"WHERE pago.fecha= '"+year+"-"+month+"-"+day+"' AND pago.hora='"+hrs+":"+min+":"+sec+"';";
    		deletePago= connection.prepareStatement(query);
    		deletePago.executeQuery();
			result= deletePago.executeUpdate();
		}
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
    	return result;
    }
    
	
	/**
     * Trata de obtener todos los usuarios registrados en la base de datos
     * @return Lista con todos los usuarios registrados
     */
	public List getAllPagosEBD()
    {
    	List persons=new ArrayList();
    	Pago person;
    	try 
    	{
    		ResultSet result = selectAllE.executeQuery();
    		while(result.next())
    		{
    			person= new Pago();
   
    			person.fecha = result.getString(1);
    			person.hora = result.getString(2);
    			person.total = result.getInt(3);
    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
	
	/**
     * Trata de obtener todos los usuarios registrados en la base de datos
     * @return Lista con todos los usuarios registrados
     */
	public List getAllPagosBD()
    {
    	List persons=new ArrayList();
    	Pago person;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			person= new Pago();
    			Date fecha;
				
/****************************/
    			fecha = result.getDate(1);
				String fechas;
				int diaN, mesN, anoN;
				diaN = fecha.getDate();
				mesN = fecha.getMonth()+1;
				anoN = fecha.getYear()+1900;
				
				if(diaN<10){
					if(mesN<10){
						fechas = "0"+diaN+"-0"+mesN+"-"+anoN;
					}
					else{
						fechas = "0"+diaN+"-"+mesN+"-"+anoN;
					}
					
				}
				else{
					if(mesN<10){
						fechas = ""+diaN+"-0"+mesN+"-"+anoN;
					}
					else{
						fechas = ""+diaN+"-"+mesN+"-"+anoN;
					}
				}
				
/****************************/    			
    			person.fecha = fechas;
    			Time t = result.getTime(2);
    			String hora;
    			String min = t.getMinutes()+"";
    			String sec = t.getSeconds()+"";
    			String hrs = t.getHours()+"";
    			
    			if(t.getMinutes()<10){
    				min = "0"+t.getMinutes();
    			}
    			if(t.getHours()<10){
    				hrs = "0"+t.getHours();
    			}
    			if(t.getSeconds()<10){
    				sec = "0"+t.getSeconds();
    			}
    			
    			hora = hrs+":"+min+":"+sec;
        		
    			person.hora = hora;
    			person.total = result.getInt(3);
    			persons.add(person);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return persons;
    }
}
