//=======================================================================
// FECHA: CREACIÓN: 14-10-09
// AUTOR: Esteban Cruz
// Clase para anular una cirugía desde la base de datos, además, dentro
// de esta se puede buscar el listado de todas las cirugías existentes
//=======================================================================

package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.CirugiaPurg;

public class PurgCirugiaBD {
	
	PreparedStatement selectAllCirugias;
	PreparedStatement deleteCirugia;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public PurgCirugiaBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT nombreCliente, apellidoPaterno, rutCliente, " +
					"nombreMascota, tipo, veterinario, raza, sexo, servicio, " +
					"hora, fechaCirugia, ayudante, estado " +
					"FROM cirugia;";
			selectAllCirugias = connection.prepareStatement(query);
			
			query = "DELETE FROM cirugia " + 
					"WHERE tipo = ?;";
			deleteCirugia = connection.prepareStatement(query);
			
			query = "UPDATE cirugia " +
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
	 * Trata de obtener todos las cirugías registrados en la base de datos
	 * @return Lista con todas las cirugías registradas
	 */
	 public List<CirugiaPurg> getAllCirugias()
	    {	
	    	List<CirugiaPurg> cirugias = new ArrayList<CirugiaPurg>();
	    	CirugiaPurg cirugia;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugias.executeQuery();
	    		while(result.next())
	    		{  
	    			cirugia = new CirugiaPurg();
	    			
	    			cirugia.setNombreCliente(result.getString(1).trim());
	    			cirugia.setApellidoPaterno(result.getString(2).trim());
	    			cirugia.setRutCliente(result.getString(3).trim());
	    			cirugia.setNombreMascota(result.getString(4).trim());
	    			cirugia.setTipo(result.getString(5).trim());
	    			cirugia.setVeterinario(result.getString(6).trim());
	    			cirugia.setRaza(result.getString(7).trim());
	    			cirugia.setSexo(result.getString(8).trim());
	    			cirugia.setServicio(result.getString(9).trim());
	    			cirugia.setHora(result.getString(10).trim());
	    			cirugia.setFechaCirugia(result.getString(11).trim());
	    			cirugia.setAyudante(result.getString(12).trim());
	    			cirugia.setEstado(result.getString(13).trim());
	    			
	    			String rut2 = cirugia.getRutCliente().trim();
	    			//Verifica que no se repitan los clientes
	    			int bandera = 0;
	    			for(int i=0;i<cirugias.size();i++){
	    				if(rut2.equals(cirugias.get(i).getRutCliente()))
	    				{
	    					bandera=1;
	    				}
	    			}
	    			if(bandera==0)
	    			{
	    				cirugias.add(cirugia);
	    			}
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	    }
	 
	 /**
	  * Trata de obtener todos las cirugías registrados en la base de datos
	  * de un cliente determinado
	  * @return Lista con todas las cirugías registradas
	  */
	 public List<CirugiaPurg> getAllCirugiasU(String rut)
	 {
		 	List<CirugiaPurg> cirugias = new ArrayList<CirugiaPurg>();
	    	CirugiaPurg cirugia;
	    	try 
	    	{
	    		ResultSet result = selectAllCirugias.executeQuery();
	    		while(result.next())
	    		{  
	    			cirugia = new CirugiaPurg();
	    			
	    			cirugia.setNombreCliente(result.getString(1).trim());
	    			cirugia.setApellidoPaterno(result.getString(2).trim());
	    			cirugia.setRutCliente(result.getString(3).trim());
	    			cirugia.setNombreMascota(result.getString(4).trim());
	    			cirugia.setTipo(result.getString(5).trim());
	    			cirugia.setVeterinario(result.getString(6).trim());
	    			cirugia.setRaza(result.getString(7).trim());
	    			cirugia.setSexo(result.getString(8).trim());
	    			cirugia.setServicio(result.getString(9).trim());
	    			cirugia.setHora(result.getString(10).trim());
	    			cirugia.setFechaCirugia(result.getString(11).trim());
	    			cirugia.setAyudante(result.getString(12).trim());
	    			cirugia.setEstado(result.getString(13).trim());

	    			String rut2 = cirugia.getRutCliente().trim();
	    			String estado2 = cirugia.getEstado().trim();
	    			if(rut2.equals(rut) && estado2.equals("0"))
	    			{
	    				cirugias.add(cirugia);
	    			}
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return cirugias;
	 }
	 
	 /**
	  * Trata de purgar todas las cirugias solicitadas por el usuario
	  * de la base de datos
	  * @return 1 si ha purgado correctamente y 0 de lo contrario
	  */
	 public int purgCirugiaU(String tipo)
	 {
		 int result = 0;
		 try {
			deleteCirugia.setString(1, tipo);
			deleteCirugia.executeQuery();
			result= deleteCirugia.executeUpdate();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return result; 
	 }
	 
	 /**
	  * Anula todas las cirugias solicitadas por el usuario
	  * de la base de datos
	  * @param 0=activado, 1=desactivo, 2=anulado
	  * @return 1 si ha anulado correctamente y 0 de lo contrario
	  */
	 public int setEstado(String estado)
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
}
