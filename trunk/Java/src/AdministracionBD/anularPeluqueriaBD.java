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

import Bd.DBConnectionManager;
import PabellonBD.PostOperatorioBD;
import TransferObjects.PostOperatorio;
import TransferObjects.anuPeluqueria;
import TransferObjects.anuPreoperatorio;

public class anularPeluqueriaBD {
	PreparedStatement selectAllVacunaciones;
	PreparedStatement setEstado;
	PreparedStatement setEstado1;
	PreparedStatement setCliente;
	PreparedStatement setMascota;
	PreparedStatement selectAllPostoperatorio2;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public anularPeluqueriaBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT clienterut, " +
					"mascotanombre, " +
					"servicio, hora, fecha, descripcion, estado, responsable,nombre, motivo " +
					"FROM serviciospeluqueria;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "SELECT nombre, aPaterno, rut " +
			"FROM clientepresencial;";
			
			setCliente = connection.prepareStatement(query);
			
			query ="SELECT nombre, raza, sexo,rut " +
			"FROM mascota;";
			
			setMascota = connection.prepareStatement(query);
			
			query = "UPDATE serviciospeluqueria " +
					"SET estado = ?, motivo = ?  " + 
					"WHERE estado = ? AND mascotanombre= ? AND hora= ? AND nombre= ? ;";
			setEstado = connection.prepareStatement(query);
			
			query = "SELECT serviciospeluqueria.responsable, serviciospeluqueria.nombre, serviciospeluqueria.descripcion " +
			"FROM serviciospeluqueria " +
			"WHERE serviciospeluqueria.mascotanombre = ? and serviciospeluqueria.clienterut = ? and serviciospeluqueria.estado = 2;";
	
	        selectAllPostoperatorio2 = connection.prepareStatement(query);
			
			query = "UPDATE serviciospeluqueria " +
			"SET estado = ? " + 
			"WHERE estado = ? AND mascotanombre= ? AND hora= ? AND nombre= ? ;";
			setEstado1 = connection.prepareStatement(query);
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
	
	public List getTodas()
    {
		 List vacunaciones = new ArrayList();
	    	anuPeluqueria vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		
	    		while(result.next())
	    		{  
	    			
	    			ResultSet result1 = setCliente.executeQuery();
	    			ResultSet result2 = setMascota.executeQuery();
	    			
	    			vacu = new anuPeluqueria();
	    			vacu.setRutCliente(result.getString(1).trim());	
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    			
	    			
	    			vacunaciones.add(vacu);
	    			
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return vacunaciones;
    }
	
	
	
	 public List getAllPeluqueria()
	    {	
		 List vacunaciones = new ArrayList();
	    	anuPeluqueria vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		
	    		while(result.next())
	    		{  
	    			
	    			ResultSet result1 = setCliente.executeQuery();
	    			ResultSet result2 = setMascota.executeQuery();
	    			
	    			vacu = new anuPeluqueria();
	    			vacu.setRutCliente(result.getString(1).trim());	
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    				    			
	    			int estado1=vacu.getEstado();
	    			
	    		
	    			if(estado1==0)
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
	 
	
	 
	 public List  getAllPeluqueriaR2(String nombreMascota, String clienterut)
	    {	
	    	List postOperatorios = new ArrayList ();
	    	anuPeluqueria postOperatorio;
	    	try 
	    	{
	    		ResultSet result;
	    		
	    		selectAllPostoperatorio2.setString(1, nombreMascota);
	    		selectAllPostoperatorio2.setString(2, clienterut);
	    		
	    		result = selectAllPostoperatorio2.executeQuery();
				
	    		while(result.next())
	    		{  
	    			postOperatorio = new anuPeluqueria();
	    			postOperatorio.responsable = result.getString(1).trim();
	    			postOperatorio.nombreCatalogo = result.getString(2).trim();
	    			postOperatorio.descripcion = result.getString(3).trim();
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
	* Este metodo obteniene todos los registros de peluquería que se encuentran
	* en la base de datos del sistema, este metodo se encarga de filtrar por el costo,
	* decripcion,servicio, responsable, hora, fecha, responsable y nombre del catalogo que 
	* seran mostrados en el segundo panel.
	* @return Lista con todos los registros de peluquería.
	*/
	 public List getAllPeluqueriaU(String nombreMascota)
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPeluqueria vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new anuPeluqueria();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    			
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
	 public List getAllPeluqueriaA()
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPeluqueria vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new anuPeluqueria();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    			
	    			int estado2 = vacu.getEstado();
	    			
	    			/**
	    			 * Esta condicción se encarga de buscar todos los registro de peluquería 
	    			 * que posean estado 1.
	    			 */
	    			if(estado2==1)
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
	* Anula todos los registros de peluquería solicitados por el usuario
	* de la base de datos.
	* @param 0=activado, 1=desactivo, 2=anulado
	* @return 2 si ha anulado correctamente y 0 de lo contrario
	*/
	 public int anular(int estado,String nombreMascota,String hora,String nombreCatalogo,String motivo)
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
			setEstado.setString(2, fecha+" "+motivo);
			setEstado.setInt(3, estado);
			setEstado.setString(4, nombreMascota);
			setEstado.setString(5, hora);
			setEstado.setString(6, nombreCatalogo);
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
	 public int eliminar(int estado,String nombreMascota,String hora, String nombreCatalogo)
	 {
		 int result = 0;
		 try {
				setEstado1.setInt(1, 1);
				setEstado1.setInt(2, estado);
				setEstado1.setString(3, nombreMascota);
				setEstado1.setString(4, hora);
				setEstado1.setString(5, nombreCatalogo);
				setEstado1.executeQuery();
				result = setEstado1.executeUpdate();
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
	 
	 public int deseliminar(int estado,String nombreMascota,String hora,String nombreCatalogo)
	 {
		 int result = 0;
		 try {
				setEstado1.setInt(1, 0);
				setEstado1.setInt(2, estado);
				setEstado1.setString(3, nombreMascota);
				setEstado1.setString(4, hora);
				setEstado1.setString(5, nombreCatalogo);
				setEstado1.executeQuery();
				result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 public List getAllPeluqueriaV()
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPeluqueria vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			if(!result.getString(10).trim().equals("0")){
	    				
	    			
	    			vacu = new anuPeluqueria();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    			
	    			String v=result.getString(10).trim();
	    			int i=0;
	    			String h=v.substring(0,1);
	    			String palabra="";
	    			
	    			while(!h.equals(" ")){
	    				palabra=palabra+h;
	    				i++;
	    				h=v.substring(i,i+1);
	    			}
	    			
	    			vacu.setFechaA(palabra);
	    			
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
	    			
	    			int estado2 = vacu.getEstado();
	    			
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
	 
	 
	 public List getAllPeluqueriaR(String nombreMascota)
	 {
		 List vacunaciones = new ArrayList();
		 	anuPeluqueria vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new anuPeluqueria();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			int estado2 = vacu.getEstado();
	    			
	    			/**
	    			 * Esta condicción se encarga de buscar todos los registro de peluquería 
	    			 * que posean estado 0 y posean el mismo nombre.
	    			 */
	    			if(rut2.equals(nombreMascota) && estado2==2)
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
	 
	 public List getAllPeluqueriaV1()
	 {
		 	List vacunaciones = new ArrayList();
		 	anuPeluqueria vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		
	    		
	    		while(result.next())
	    		{  
	    			
	    			if(!result.getString(10).trim().equals("0")){
	    				
	    			
	    			vacu = new anuPeluqueria();
	    			
	    			vacu.setRutCliente(result.getString(1).trim());
	    			vacu.setNombreMascota(result.getString(2).trim());
	    			vacu.setServicio(result.getString(3).trim());
	    			vacu.setHora(result.getString(4).trim());
	    			vacu.setFecha(result.getString(5).trim());
	    			vacu.setDescripcion(result.getString(6).trim());
	    			vacu.setEstado(result.getInt(7));
	    			vacu.setResponsable(result.getString(8).trim());
	    			vacu.setNombreCatalogo(result.getString(9).trim());
	    			
	    			int estado1=vacu.getEstado();
	    			
	    	
	    			if(estado1==2)
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
