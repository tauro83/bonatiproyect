//=======================================================================
// FECHA CREACIÓN: 16/11/09
// AUTOR: Nicolas Delgado 
// Clase encargada de declarar los scripts que luego serán
// ejecutados en la base de datos
//=======================================================================
package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import TransferObjects.anuPeluqueria;
import TransferObjects.anuPreoperatorio;

public class anularPreoperatorioBD {
	PreparedStatement selectAllVacunaciones;
	PreparedStatement setEstado;
	PreparedStatement setCliente;
	PreparedStatement setMascota;
	PreparedStatement selectAllPostoperatorio2;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public anularPreoperatorioBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT rut, " +
					"nombre, " +
					"hora, fecha, sintomas, estado, responsable, observaciones, motivo " +
					"FROM preoperatorio;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "SELECT preoperatorio.responsable, preoperatorio.sintomas, preoperatorio.observaciones " +
			"FROM preoperatorio " +
			"WHERE preoperatorio.nombre = ? and preoperatorio.rut = ? and preoperatorio.estado = 2;";
	
	        selectAllPostoperatorio2 = connection.prepareStatement(query);
			
			query = "SELECT nombre, aPaterno, rut " +
			"FROM clientepresencial;";
			
			setCliente = connection.prepareStatement(query);
			
			query ="SELECT nombre, raza, sexo,rut " +
			"FROM mascota;";
			
			setMascota = connection.prepareStatement(query);
			
			query = "UPDATE preoperatorio " +
					"SET estado = ?, motivo = ? " + 
					"WHERE estado = ? AND nombre= ? AND hora= ?;";
			setEstado = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Este metodo obteniene todos los registros de peluquería que se encuentran
	 * en la base de datos del sistema, este metodo se encarga de filtrar por el nombre
	 * apelido, rut , nombre de la mascota,raza y sexo para arrojar esto datos en el primer
	 * panel.
	 * @return Lista con todos los registros de peluquería.
	 */
	 public List getAllVacunaciones()
	    {	
		 List vacunaciones = new ArrayList();
		 	anuPreoperatorio vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		
	    		while(result.next())
	    		{  
	    			
	    			ResultSet result1 = setCliente.executeQuery();
	    			ResultSet result2 = setMascota.executeQuery();
	    			
	    			vacu = new anuPreoperatorio();
	    			vacu.setRutCliente(result.getString(1).trim());	
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setHora(result.getString(3).trim());
	    			vacu.setFecha(result.getString(4).trim());
	    			vacu.setSintomas(result.getString(5).trim());
	    			vacu.setEstado(result.getInt(6));
	    			vacu.setResponsable(result.getString(7).trim());
	    			vacu.setObservaciones(result.getString(8).trim());
	    			vacu.setMotivo(result.getString(9).trim());
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			String rut3=vacu.getRutCliente().trim();
	    			
	    			int estado1=vacu.getEstado();
	    			
	    			int h=0;
	    			while(result1.next() && h==0 && estado1==0)
		    		{ 
	    			//System.out.println("ar" + " "+result1);
	    			
	    			vacu.setRutCliente(result1.getString(3).trim()); 
	    			String rut4=vacu.getRutCliente().trim();
	    			//System.out.println(rut4);
	    			if(rut3.equals(rut4)){
	    				    //System.out.println("Hola"+rut3);
	    					vacu.setRutCliente(rut3);
	    					vacu.setNombreCliente(result1.getString(1).trim());
	    					vacu.setApellido(result1.getString(2).trim());
	    					h=1;
	    					
	    				}
		    		}
	    			
	    			int g=0;
	    			while(result2.next() && g==0 && estado1==0)
		    		{ 
	    			//System.out.println("ar" + " "+result1);
	    			
	    			vacu.setNombreMascota(result2.getString(1).trim()); 
	    			vacu.setRutCliente(result2.getString(4).trim()); 
	    			//System.out.println(rut4);
	    			String rut4=vacu.getNombreMascota().trim();
	    			String rut5=vacu.getRutCliente().trim();
	    			if(rut2.equals(rut4) && rut3.equals(rut5) ){
	    				    //System.out.println("Hola"+rut3);
	    					vacu.setRutCliente(rut3);
	    					vacu.setRaza(result2.getString(2).trim());
	    					vacu.setSexo(result2.getString(3).trim());
	    					g=1;
	    					
	    				}
		    		}
	    			
	    			//Verifica que no se repitan los clientes
	    			int bandera = 0;
	    			for(int i=0;i<vacunaciones.size();i++){
	    				if(rut2.equals(((anuPreoperatorio) vacunaciones.get(i)).getNombreMascota()))
	    				{
	    					bandera=1;
	    				}
	    			}
	    			if(bandera==0 && estado1==0)
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
	* Este metodo obteniene todos los registros de peluquería que se encuentran
	* en la base de datos del sistema, este metodo se encarga de filtrar por el costo,
	* decripcion,servicio, responsable, hora, fecha, responsable y nombre del catalogo que 
	* seran mostrados en el segundo panel.
	* @return Lista con todos los registros de peluquería.
	*/
	 
	 public List  getAllVacunacionesR2(String nombreMascota, String clienterut)
	    {	
	    	List postOperatorios = new ArrayList ();
	    	anuPreoperatorio postOperatorio;
	    	try 
	    	{
	    		ResultSet result;
	    		
	    		selectAllPostoperatorio2.setString(1, nombreMascota);
	    		selectAllPostoperatorio2.setString(2, clienterut);
	    		
	    		result = selectAllPostoperatorio2.executeQuery();
				
	    		while(result.next())
	    		{  
	    			postOperatorio = new anuPreoperatorio();
	    			postOperatorio.responsable = result.getString(1).trim();
	    			postOperatorio.sintomas= result.getString(2).trim();
	    			postOperatorio.observaciones = result.getString(3).trim();
	    			postOperatorios.add(postOperatorio);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return postOperatorios;
	    }
	 
	 
	 
	 public List getAllVacunacionesU(String nombreMascota)
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPreoperatorio vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new anuPreoperatorio();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());	
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setHora(result.getString(3).trim());
	    			vacu.setFecha(result.getString(4).trim());
	    			vacu.setSintomas(result.getString(5).trim());
	    			vacu.setEstado(result.getInt(6));
	    			vacu.setResponsable(result.getString(7).trim());
	    			vacu.setObservaciones(result.getString(8).trim());
	    			vacu.setMotivo(result.getString(9).trim());
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			int estado2 = vacu.getEstado();
	    			
	    			/**
	    			 * Esta condicción se encarga de buscar todos los registro de peluquería 
	    			 * que posean estado 0 y posean el mismo nombre.
	    			 */
	    			if(rut2.equals(nombreMascota) && estado2==0)
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
	* Este metodo obteniene todos los registros de peluquería que se encuentran
	* en la base de datos del sistema, este metodo se encarga de filtrar por el costo,
	* decripcion,servicio, responsable, hora, fecha, responsable y nombre del catalogo que 
	* seran mostrados en el panel de deseliminar y se encarga de bucar todos los registro 
	* que posean estado 1.
	* @return Lista con todos los registros de peluquería.
	*/
	 public List getAllVacunacionesV()
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPreoperatorio vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			if(!result.getString(9).trim().equals("0")){
	    				
	    			
	    			vacu = new anuPreoperatorio();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());	
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setHora(result.getString(3).trim());
	    			vacu.setFecha(result.getString(4).trim());
	    			vacu.setSintomas(result.getString(5).trim());
	    			vacu.setEstado(result.getInt(6));
	    			vacu.setResponsable(result.getString(7).trim());
	    			vacu.setObservaciones(result.getString(8).trim());
	    			vacu.setMotivo(result.getString(9).trim());
	    			
	    			String v=result.getString(9).trim();
	    			int i=0;
	    			String h=v.substring(0,1);
	    			String palabra="";
	    			
	    			while(!h.equals(" ")){
	    				palabra=palabra+h;
	    				i++;
	    				h=v.substring(i,i+1);
	    			}
	    			
	    			int estado2 = vacu.getEstado();
	    			
	    			if(estado2==2){
	    				vacu.setFechaA(palabra);	
	    			}
	    			
	    			
	    			h=v.substring(i+1,i+2);
	    			palabra="";
	    			i++;
	    			
	    			while(!h.equals(" ")){
	    				palabra=palabra+h;
	    				i++;
	    				h=v.substring(i,i+1);
	    			}
	    			
	    			vacu.setUsuarioA(palabra);
	    			h=v.substring(i,i+1);
	    			palabra="";
	    			
	    			while(i<v.length() && i+1<v.length()){
	    				palabra=palabra+h;
	    				i++;
	    				h=v.substring(i,i+1);
	    			}
	    			h=v.substring(i,i+1);
	    			palabra=palabra+h;
	    			vacu.setMotivo(palabra);
	    			
	    			estado2 = vacu.getEstado();
	    			
	    			/**
	    			 * Esta condicción se encarga de buscar todos los registro de peluquería 
	    			 * que posean estado 1.
	    			 */
	    			if(estado2==2)
	    			{
	    				
	    				vacunaciones.add(vacu);
	    			}
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
	* Anula todos los registros de peluquería solicitados por el usuario
	* de la base de datos.
	* @param 0=activado, 1=desactivo, 2=anulado
	* @return 2 si ha anulado correctamente y 0 de lo contrario
	*/
	 public int anular(int estado, String nombreMascota,String hora, String motivo)
	 {
		 int result = 0;
		 try {
			
	    	Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900;
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			Date date = new Date(year,month, day);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formatter.format(date); 
			 
			setEstado.setInt(1, 2);
			setEstado.setString(2,fecha+" "+motivo);
			setEstado.setInt(3, estado);
			setEstado.setString(4, nombreMascota);
			setEstado.setString(5, hora);
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	/**
	* Elimina todos los registros de peluquería solicitados por el usuario
	* de la base de datos.
	* @param 0=activado, 1=desactivo, 2=anulado
	* @return 1 si ha eliminado correctamente y 0 de lo contrario
	*/
	 public int eliminar(int estado)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 1);
			setEstado.setInt(2, estado);
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }

	/**
	* Deselimina todos los registros de peluquería solicitados por el usuario
	* de la base de datos.
	* @param 0=activado, 1=desactivo, 2=anulado
	* @return 0 si ha deseliminado correctamente y 1 de lo contrario.
	*/
	 
	 public int deseliminar(int estado)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 0);
			setEstado.setInt(2, estado);
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 public List getAllVacunacionesV2()
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPreoperatorio vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		
	    		
	    		while(result.next())
	    		{  
	    			ResultSet result1 = setCliente.executeQuery();
	    			ResultSet result2 = setMascota.executeQuery();
	    			
	    			if(!result.getString(9).trim().equals("0")){
	    				
	    			
	    			vacu = new anuPreoperatorio();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());
	    			vacu.setNombreMascota(result.getString(2).trim());	    			
	    			vacu.setHora(result.getString(3).trim());
	    			vacu.setFecha(result.getString(4).trim());
	    			vacu.setSintomas(result.getString(5).trim());
	    			vacu.setEstado(result.getInt(6));
	    			vacu.setResponsable(result.getString(7).trim());	    			
	    			vacu.setObservaciones(result.getString(8).trim());
	    			vacu.setMotivo(result.getString(9).trim());
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			String rut3=vacu.getRutCliente().trim();
	    			int h=0;
	    			int estado1=vacu.getEstado();
	    			
	    			while(result1.next() && h==0 && estado1==2)
		    		{ 
	    			//System.out.println("ar" + " "+result1);
	    			
	    			vacu.setRutCliente(result1.getString(3).trim()); 
	    			String rut4=vacu.getRutCliente().trim();
	    			//System.out.println(rut4);
	    			if(rut3.equals(rut4)){
	    				    //System.out.println("Hola"+rut3);
	    					vacu.setRutCliente(rut3);
	    					vacu.setNombreCliente(result1.getString(1).trim());
	    					vacu.setApellido(result1.getString(2).trim());
	    					h=1;
	    					
	    				}
		    		}
	    			
	    			int g=0;
	    			
	    			while(result2.next() && g==0 && estado1==2)
		    		{ 
	    			//System.out.println("ar" + " "+result1);
	    			
	    			vacu.setNombreMascota(result2.getString(1).trim()); 
	    			vacu.setRutCliente(result2.getString(4).trim()); 
	    			//System.out.println(rut4);
	    			String rut4=vacu.getNombreMascota().trim();
	    			String rut5=vacu.getRutCliente().trim();
	    			if(rut2.equals(rut4) && rut3.equals(rut5) ){
	    				    //System.out.println("Hola"+rut3);
	    					vacu.setRutCliente(rut3);
	    					vacu.setRaza(result2.getString(2).trim());
	    					vacu.setSexo(result2.getString(3).trim());
	    					g=1;
	    					
	    				}
		    		}
	    			
	    			//Verifica que no se repitan los clientes
	    			int bandera = 0;
	    			for(int i=0;i<vacunaciones.size();i++){
	    				if(rut2.equals(((anuPreoperatorio) vacunaciones.get(i)).getNombreMascota()))
	    				{
	    					bandera=1;
	    				}
	    			}
	    			if(bandera==0 && estado1==2)
	    			{
	    				vacunaciones.add(vacu);
	    			}
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
