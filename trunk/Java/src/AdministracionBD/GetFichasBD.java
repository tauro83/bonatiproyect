//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo
// Descripcion:  Clase que gestiona la obtencion de las fichas, esta clase es llamada por la capa dos, retornando 
// las mascotas, el cliente y las atenciones
//=======================================================================
package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import TransferObjects.Atencion;
import TransferObjects.Mascota;
import TransferObjects.Cliente;

public class GetFichasBD {
	
	PreparedStatement selectAll;
	Connection connection;
		
	/**
	 * Constructor de la clase
	 * @param connection establece la conexion con la base de datos.
	 */
	public GetFichasBD(Connection connection)
	{
		this.connection = connection;
		
	}
	/**
	 * Obtiene un cliente a partir del RUT
	 * @param rut Parametro que permite identificar a un cliente en particular
	 * @return Un transfer Object Cliente, el cual fue recuperado desde la BD
	 * @throws SQLException Permite manejar errores en la sentencia sql
	 */
	public Cliente getCliente(String rut) throws SQLException{
		Cliente c = new Cliente();
		String query = "SELECT rut, telefono, celular, nombre, apaterno, amaterno, correo, estado, domicilio, comuna, region "+
	  " FROM clientepresencial WHERE rut='"+rut.trim()+"';";
		
		selectAll = connection.prepareStatement(query);
		ResultSet result = selectAll.executeQuery();
		
		while(result.next())
		{			
			c.setRut(result.getString(1).trim());
			c.setTelefono(result.getString(2));
			c.setTelefono2(result.getString(3));
			c.setNombre(result.getString(4).trim());
			c.setEmail(result.getString(5).trim());
			c.setEstado(result.getBoolean(6));
			c.setDireccion(result.getString(9).trim()+" "+result.getString(10).trim() +", "+result.getString(11).trim());
		}
		
		
		return c;
	}
	
	/**
	 * Obtiene un listado de mascotas
	 * @return retorna un listad de mascotas, las cuales seran mostradas en la capa de presencion
	 * Este metodo es llamado desde la capa 2
	 * 
	 */
	public List getAllMascotas()
    {
    	List mascotas=new ArrayList();
    	Mascota mas;
    	
    	String query = "SELECT rut, nombre,fechanacimiento,claseanimal,raza,sexo,estado FROM mascota";
		
	   	try 
    	{
    		selectAll = connection.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			mas = new Mascota();
    			mas.setRutCliente(result.getString(1));
    			mas.setNombre(result.getString(2));
    			mas.setFechaNacimiento(result.getString(3));
    			mas.setClaseAnimal(result.getString(4));
    			mas.setRaza(result.getString(5));
    			mas.setSexo(result.getString(6));
    			mas.setEstado(result.getBoolean(7));
    			
    			mascotas.add(mas);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return mascotas;
    }
	
	
	/**
	 * Obtiene las atenciones
	 * @param rut Parametro que permite identificar las atenciones de una mascota en particular
	 * @param nombre Segundo parametro necesario para identificar las atenciones
	 * @return una lista de atenciones, las cuales seran mostradas en la ficha.
	 */ 
	public List getAllAtenciones(String rut, String nombre)
    {
    	List atenciones = new ArrayList();
    	Atencion at;
    	String queryAtencion = "SELECT clienterut, mascotaNombre,servicio,hora,fecha,costo FROM atencion" +
    			" WHERE mascotaNombre='"+nombre.trim()+"' AND clienterut='" +rut.trim() +"'";
    	try 
    	{
    		selectAll = connection.prepareStatement(queryAtencion);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			at = new Atencion();
    			at.setClienteRut(result.getString(6));
    			at.setMascotaNombre(result.getString(7));
    			at.setServicio("Alojamiento");
    			at.setHora(result.getString(2));
    			at.setSfecha(""+result.getString(3));
    			at.setCosto("$"+result.getString(4));
    			if(result.getString(4)==null){
					at.setCosto("");
				}
    			atenciones.add(at);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	    	
    	
    	    	
//    	String queryBanio = "	SELECT rutcliente, nombremascota, servicio, hora, fecha, costo, comentario "+
//    	  							" FROM atencionbanio WHERE rutcliente='"+ rut.trim()+"' AND nombremascota='" +nombre.trim() +"'";	 
//    	try 
//    	{
//    		selectAll = connection.prepareStatement(queryBanio);
//			ResultSet result = selectAll.executeQuery();
//    		while(result.next())
//    		{
//    			at = new Atencion();
//    			at.setClienteRut(result.getString(1));
//    			at.setMascotaNombre(result.getString(2));
//    			at.setServicio(result.getString(3));
//    			at.setHora(result.getString(4));
//    			at.setSfecha(""+result.getString(5));
//    			at.setCosto("$"+result.getString(6));
//    			atenciones.add(at);
//    		}
//		} 
//    	catch (SQLException e) 
//    	{
//			e.printStackTrace();
//		}
    	
//    	String querypedicure = "SELECT rutcliente, nombremascota, servicio, hora, fecha, costo, descripcion, "+
//    	"nombre  FROM atencionpedicure WHERE rutcliente='"+ rut.trim()+"' AND nombremascota='" +nombre.trim() +"'";	 
//    	
//		try 
//		{
//			selectAll = connection.prepareStatement(querypedicure);
//			ResultSet result = selectAll.executeQuery();
//			while(result.next())
//			{
//				at = new Atencion();
//				at.setClienteRut(result.getString(1));
//				at.setMascotaNombre(result.getString(2));
//				at.setServicio(result.getString(3));
//				at.setHora(result.getString(4));
//				at.setSfecha(""+result.getString(5));
//				at.setCosto("$"+result.getString(6));
//				atenciones.add(at);
//			}
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
    	
    	String queryPeluqueria= "SELECT clienterut, mascotanombre, hora, responsable, fecha, estado, servicio FROM atencionpeluqueria  WHERE clienterut='"+ rut.trim()+"' AND mascotanombre='" +nombre.trim() +"'";	    	
		try 
		{
			selectAll = connection.prepareStatement(queryPeluqueria);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(1));
				at.setMascotaNombre(result.getString(2));
				at.setServicio("Peluqueria");
				at.setHora(result.getString(3));
				at.setSfecha(""+result.getString(5));
				
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		    	
    	
    	 
    	String queryAlojamiento = "SELECT servicio, hora, fechaingreso, costo, responsable, cliente, mascota, "+
    								"canil, fechasalida, comentario, diasestadia, eliminado "+
    								" FROM atencionalojamiento WHERE cliente='"+ rut.trim()+"' AND mascota='" +nombre.trim() +"'";	    	
    	try 
    	{
    		selectAll = connection.prepareStatement(queryAlojamiento);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			at = new Atencion();
    			at.setClienteRut(result.getString(6));
    			at.setMascotaNombre(result.getString(7));
    			at.setServicio("Alojamiento");
    			at.setHora(result.getString(2));
    			at.setSfecha(""+result.getString(3));
    			at.setCosto("$"+result.getString(4));
    			if(result.getString(4)==null){
					at.setCosto("");
				}
    			atenciones.add(at);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	
    	
		String queryPostoperatorio = "SELECT medicamentos, alimentos, indicaciones, servicio, hora, fecha,"+ 
	       	"costo, nombremascota, rut, apellido, nombrecliente FROM atencionpostoperatorio "+
	       	"WHERE rut='"+ rut.trim()+"' AND nombremascota='" +nombre.trim() +"'";	

		try 
		{
			selectAll = connection.prepareStatement(queryPostoperatorio);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(9));
				at.setMascotaNombre(result.getString(8));
				at.setServicio("PostOperatorio");
				at.setHora(result.getString(5));
				at.setSfecha(""+result.getString(6));
				at.setCosto("$"+result.getString(7));
				if(result.getString(7)==null){
					at.setCosto("");
				}
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	
		String queryvacunacion = "SELECT vacuna, clienterut, mascotanombre, hora, responsable, fecha, "+
	       "costo, fechacaducidad, descripcion, servicio FROM vacunacion WHERE clienterut='"+ rut.trim()+"' AND mascotanombre='" +nombre.trim() +"'";	

		try 
		{
			selectAll = connection.prepareStatement(queryvacunacion);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(2));
				at.setMascotaNombre(result.getString(3));
				at.setServicio("Vacunacion");
				at.setHora(result.getString(4));
				at.setSfecha(""+result.getString(6));
				at.setCosto("$"+result.getString(7));
				if(result.getString(7)==null){
					at.setCosto("");
				}
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
    	
		
		String querycontrol = "SELECT cliente, mascota, descripcion, fecha, hora, responsable, servicio, costo  FROM atencioncontrol WHERE cliente='"+ rut.trim()+"' AND mascota='" +nombre.trim() +"'";	

		try 
		{
			selectAll = connection.prepareStatement(querycontrol);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(1));
				at.setMascotaNombre(result.getString(2));
				at.setServicio("Control");
				at.setHora(""+result.getString(5));
				at.setSfecha(""+result.getString(4));
				at.setCosto("$"+result.getString(8));
				if(result.getString(8)==null){
					at.setCosto("");
				}
				
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		String queryCIRUGIA = "SELECT clienterut, mascotanombre, hora, responsable, ayudante, fecha, costo, estado, servicio FROM cirugia WHERE clienterut='"+ rut.trim()+"' AND mascotanombre='" +nombre.trim() +"'";	

		try 
		{
			selectAll = connection.prepareStatement(queryCIRUGIA);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(1));
				at.setMascotaNombre(result.getString(2));
				at.setServicio("Cirugia");
				at.setHora(""+result.getString(3));
				at.setSfecha(""+result.getString(6));
				at.setCosto("$"+result.getString(7));
				if(result.getString(7)==null){
					at.setCosto("");
				}
				
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		

		String queryconsulta = "SELECT anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado FROM consulta WHERE rut='"+ rut.trim()+"' AND nombre='" +nombre.trim() +"'";	

		try 
		{
			selectAll = connection.prepareStatement(queryconsulta);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(6));
				at.setMascotaNombre(result.getString(7));
				at.setServicio("Consulta");
				at.setHora(""+result.getString(3));
				at.setSfecha(""+result.getString(4));
				at.setCosto("$"+result.getString(5));
				if(result.getString(5)==null){
					at.setCosto("");
				}
				
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		String queryPreoperatorio = "SELECT rut, nombre, observaciones, sintomas, diagnostico, fecha, hora, "+ 
        "responsable, ayudante, estado, motivo  FROM preoperatorio  WHERE rut='"+ rut.trim()+"' AND nombre='" +nombre.trim() +"'";	

		try 
		{
			selectAll = connection.prepareStatement(queryPreoperatorio);
			ResultSet result = selectAll.executeQuery();
			while(result.next())
			{
				at = new Atencion();
				at.setClienteRut(result.getString(1));
				at.setMascotaNombre(result.getString(2));
				at.setServicio("Preoperatorio");
				at.setHora(""+result.getString(7));
				at.setSfecha(""+result.getString(6));
				at.setCosto("$");
				
				atenciones.add(at);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		
		
		return atenciones;
    }
	
}
