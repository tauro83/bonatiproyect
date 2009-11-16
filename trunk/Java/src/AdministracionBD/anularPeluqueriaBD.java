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
					"servicio, hora, fecha, costo, descripcion, estado " +
					"FROM peluqueria;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "SELECT nombre, aPaterno, rut " +
			"FROM clientepresencial;";
			
			setCliente = connection.prepareStatement(query);
			
			query ="SELECT nombre, raza, sexo " +
			"FROM mascota;";
			
			setMascota = connection.prepareStatement(query);
			
			query = "UPDATE peluqueria " +
					"SET estado = ? " + 
					"WHERE costo = ?;";
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
	    			vacu.setEstado(result.getString(8).trim());
	    			
	    			
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
	    			//System.out.println(rut4);
	    			String rut4=vacu.getNombreMascota().trim();
	    			if(rut2.equals(rut4)){
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
	  * Trata de obtener todos las vacunaciones registrados en la base de datos
	  * de un cliente determinado
	  * @return Lista con todas las vacunaciones registradas
	  */
	 public List<anuPeluqueria> getAllVacunacionesU(String nombreMascota)
	 {
		 List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
	    	anuPeluqueria vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		ResultSet result1 = setCliente.executeQuery();
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
	    			vacu.setEstado(result.getString(8).trim());
	    			//vacu.setApellido("mar");
	    			//vacu.setNombreCliente("ca");
	    			
	    			
	    			String rut2 = vacu.getNombreMascota().trim();
	    			String rut3 = vacu.getRutCliente().trim();
	    			int h=0;
	    			while(result1.next() && h==0)
		    		{ 
	    			vacu.setRutCliente(result1.getString(3).trim()); 
	    			String rut4=vacu.getRutCliente().trim();
	    			System.out.println(rut4);
	    			if(rut3.equals(rut4)){
	    				    System.out.println("Hola");
	    					vacu.setRutCliente(rut3);
	    					vacu.setNombreCliente(result1.getString(1).trim());
	    					vacu.setApellido(result1.getString(2).trim());
	    					h=1;
	    					
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
	  * Anula todas las vacunaciones solicitadas por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha anulado correctamente y 0 de lo contrario
	  */
	 public int anular(String estado)
	 {
		 int result = 0;
		 try {
			setEstado.setString(1, "2");
			setEstado.setString(2, estado);
			setEstado.executeQuery();
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
	  */
	 public int eliminar(String estado)
	 {
		 int result = 0;
		 try {
			setEstado.setString(1, "1");
			setEstado.setString(2, estado);
			setEstado.executeQuery();
			result = setEstado.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
}
