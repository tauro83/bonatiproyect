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
import java.util.ArrayList;
import java.util.List;

import TransferObjects.anuPeluqueria;

public class anularPeluqueriaBD {
	PreparedStatement selectAllVacunaciones;
	PreparedStatement setEstado;
	PreparedStatement setCliente;
	PreparedStatement setMascota;
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
					"servicio, hora, fecha, costo, descripcion, estado, responsable,nombre " +
					"FROM serviciospeluqueria;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "SELECT nombre, aPaterno, rut " +
			"FROM clientepresencial;";
			
			setCliente = connection.prepareStatement(query);
			
			query ="SELECT nombre, raza, sexo,rut " +
			"FROM mascota;";
			
			setMascota = connection.prepareStatement(query);
			
			query = "UPDATE serviciospeluqueria " +
					"SET estado = ? " + 
					"WHERE estado = ? AND mascotanombre= ? AND hora= ?;";
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
	 public List<anuPeluqueria> getAllVacunaciones()
	    {	
		 List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
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
	    			vacu.setCosto(result.getString(6).trim());
	    			vacu.setDescripcion(result.getString(7).trim());
	    			vacu.setEstado(result.getInt(8));
	    			vacu.setResponsable(result.getString(9).trim());
	    			vacu.setNombreCatalogo(result.getString(10).trim());
	    			
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			String rut3=vacu.getRutCliente().trim();
	    			int h=0;
	    			while(result1.next() && h==0)
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
	    			while(result2.next() && g==0)
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
	    				if(rut2.equals(vacunaciones.get(i).getNombreMascota()))
	    				{
	    					bandera=1;
	    				}
	    			}
	    			if(bandera==0)
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
	 public List<anuPeluqueria> getAllVacunacionesU(String nombreMascota)
	 {
		 	List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
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
	    			vacu.setCosto(result.getString(6).trim());
	    			vacu.setDescripcion(result.getString(7).trim());
	    			vacu.setEstado(result.getInt(8));
	    			vacu.setResponsable(result.getString(9).trim());
	    			vacu.setNombreCatalogo(result.getString(10).trim());
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			Integer estado2 = vacu.getEstado();
	    			
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
	 public List<anuPeluqueria> getAllVacunacionesA()
	 {
		 	List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
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
	    			vacu.setCosto(result.getString(6).trim());
	    			vacu.setDescripcion(result.getString(7).trim());
	    			vacu.setEstado(result.getInt(8));
	    			vacu.setResponsable(result.getString(9).trim());
	    			vacu.setNombreCatalogo(result.getString(10).trim());
	    			
	    			Integer estado2 = vacu.getEstado();
	    			
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
	 public int anular(Integer estado,String nombreMascota,String hora)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 2);
			setEstado.setInt(2, estado);
			setEstado.setString(3, nombreMascota);
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
	* Elimina todos los registros de peluquería solicitados por el usuario
	* de la base de datos.
	* @param 0=activado, 1=desactivo, 2=anulado
	* @return 1 si ha eliminado correctamente y 0 de lo contrario
	*/
	 public int eliminar(Integer estado,String nombreMascota,String hora)
	 {
		 int result = 0;
		 try {
				setEstado.setInt(1, 1);
				setEstado.setInt(2, estado);
				setEstado.setString(3, nombreMascota);
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
	* Deselimina todos los registros de peluquería solicitados por el usuario
	* de la base de datos.
	* @param 0=activado, 1=desactivo, 2=anulado
	* @return 0 si ha deseliminado correctamente y 1 de lo contrario.
	*/
	 
	 public int deseliminar(Integer estado,String nombreMascota,String hora)
	 {
		 int result = 0;
		 try {
				setEstado.setInt(1, 0);
				setEstado.setInt(2, estado);
				setEstado.setString(3, nombreMascota);
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
