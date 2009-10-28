//=======================================================================
// FECHA: CREACIÓN: 27-10-09
// AUTOR: Esteban Cruz
// Clase para anular o eliminar una cirugía desde la base de datos, además, 
// dentro de esta se puede buscar el listado de todas las vacunaciones existentes
//=======================================================================

package PoliclinicoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.vacunacionesObj;

public class VacunacionBD {
	
	PreparedStatement selectAllVacunaciones;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public VacunacionBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT nombreCliente, apellidoPaterno, rutCliente, " +
					"nombreMascota, tipo, veterinario, raza, sexo, servicio, " +
					"hora, fechaCirugia, descripcion, estado " +
					"FROM vacunacion;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "UPDATE vacunacion " +
					"SET estado = ? " + 
					"WHERE tipo = ?;";
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
	 public List<vacunacionesObj> getAllVacunaciones()
	    {	
	    	List<vacunacionesObj> vacunaciones = new ArrayList<vacunacionesObj>();
	    	vacunacionesObj vacu;
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new vacunacionesObj();
	    			
	    			vacu.setNombreCliente(result.getString(1).trim());
	    			vacu.setApellidoPaterno(result.getString(2).trim());
	    			vacu.setRutCliente(result.getString(3).trim());
	    			vacu.setNombreMascota(result.getString(4).trim());
	    			vacu.setTipo(result.getString(5).trim());
	    			vacu.setVeterinario(result.getString(6).trim());
	    			vacu.setRaza(result.getString(7).trim());
	    			vacu.setSexo(result.getString(8).trim());
	    			vacu.setServicio(result.getString(9).trim());
	    			vacu.setHora(result.getString(10).trim());
	    			vacu.setFechaVacu(result.getString(11).trim());
	    			vacu.setDescripcion(result.getString(12).trim());
	    			vacu.setEstado(result.getString(13).trim());
	    			
	    			String rut2 = vacu.getRutCliente().trim();
	    			//Verifica que no se repitan los clientes
	    			int bandera = 0;
	    			for(int i=0;i<vacunaciones.size();i++){
	    				if(rut2.equals(vacunaciones.get(i).getRutCliente()))
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
	 public List<vacunacionesObj> getAllVacunacionesU(String rut)
	 {
		 	List<vacunacionesObj> vacunaciones = new ArrayList<vacunacionesObj>();
		 	vacunacionesObj vacu;
		 	
	    	try 
	    	{
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new vacunacionesObj();
	    			
	    			vacu.setNombreCliente(result.getString(1).trim());
	    			vacu.setApellidoPaterno(result.getString(2).trim());
	    			vacu.setRutCliente(result.getString(3).trim());
	    			vacu.setNombreMascota(result.getString(4).trim());
	    			vacu.setTipo(result.getString(5).trim());
	    			vacu.setVeterinario(result.getString(6).trim());
	    			vacu.setRaza(result.getString(7).trim());
	    			vacu.setSexo(result.getString(8).trim());
	    			vacu.setServicio(result.getString(9).trim());
	    			vacu.setHora(result.getString(10).trim());
	    			vacu.setFechaVacu(result.getString(11).trim());
	    			vacu.setDescripcion(result.getString(12).trim());
	    			vacu.setEstado(result.getString(13).trim());

	    			String rut2 = vacu.getRutCliente().trim();
	    			String estado2 = vacu.getEstado().trim();
	    			
	    			if(rut2.equals(rut) && estado2.equals("0"))
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
	  * Elimina todas las cirugias solicitadas por el usuario
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
