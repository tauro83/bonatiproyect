package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.aviWeb;;

public class avisoWebBD {
	PreparedStatement selectAllVacunaciones;
	PreparedStatement setEstado;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public avisoWebBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT id, nombre, apaterno, telefono0, telefono, celular0, celular, asunto, descripcion, estado " +
					"FROM avisoweb;";
			selectAllVacunaciones = connection.prepareStatement(query);
			
			query = "UPDATE avisoweb " +
					"SET estado = ? " + 
					"WHERE id= ?;";
			setEstado = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	

	 
	/**
	* Este metodo obteniene todos los registros de peluquería que se encuentran
	* en la base de datos del sistema, este metodo se encarga de filtrar por el costo,
	* decripcion,servicio, responsable, hora, fecha, responsable y nombre del catalogo que 
	* seran mostrados en el panel de deseliminar y se encarga de bucar todos los registro 
	* que posean estado 1.
	* @return Lista con todos los registros de peluquería.
	*/
	 public List getAllVacunacionesA()
	 {
		 	List vacunaciones = new ArrayList();
		 	aviWeb vacu;
		 	
	    	try 
	    	{
	    		/**
	    		 * Inicializa la consulta sql de la tabla de peluquería.
	    		 */
	    		ResultSet result = selectAllVacunaciones.executeQuery();
	    		while(result.next())
	    		{  
	    			vacu = new aviWeb();
	    			
	    			vacu.setId(result.getInt(1));	
	    			vacu.setNombre(result.getString(2).trim());
	    			vacu.setApaterno(result.getString(3).trim());
	    			vacu.setTelefono0(result.getString(4).trim());
	    			vacu.setTelefono(result.getString(5).trim());
	    			vacu.setCelular0(result.getString(6).trim());
	    			vacu.setCelular(result.getString(7).trim());
	    			vacu.setAsunto(result.getString(8).trim());
	    			vacu.setDescripcion(result.getString(9).trim());
	    			vacu.setEstado(result.getInt(10));
	    			
	    			int estado2 = vacu.getEstado();
	    			
	    			/**
	    			 * Esta condicción se encarga de buscar todos los registro de peluquería 
	    			 * que posean estado 1.
	    			 */
	    			if(estado2==0)
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
	 public int anular(int estado)
	 {
		 int result = 0;
		 try {
			setEstado.setInt(1, 2);
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
}
