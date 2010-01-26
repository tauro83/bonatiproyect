//=======================================================================
//FECHA CREACIÓN: 27 de Octubre de 2009
//AUTOR: Sebastian Arancibia
//…. Clase Control
//=======================================================================


package PoliclinicoBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Cita;
import TransferObjects.Control;

/**
* Clase utilizada para la comunicacion entre capa 2 y 3 (Java y PostgreSQL)
*
* @author  Sebastian Arancibia
* @version 0.1, 22/09/09
*/


public class AddControlBD{
	PreparedStatement addProxControl;
	PreparedStatement addActuControl;
	PreparedStatement addEstadisticas;
	/**
	 * Constructor de MascotaBD
	 * @param connection Enlace para la conexion a la base de datos
	 */
	public AddControlBD(Connection connection){
		
		try{
			
			String query="";	
			
			query = "INSERT INTO cita(rutcliente, nombremascota, fecha, hora, servicio, responsable) "+
					"VALUES (?, ?, ?, ?, ?, ?);";			
			addProxControl = connection.prepareStatement(query);
			
			query="";	
			
			query = "INSERT INTO atencioncontrol(cliente, mascota, descripcion, fecha, hora, responsable, servicio, costo) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";			
			addActuControl = connection.prepareStatement(query);
			
			query="INSERT INTO estadisticasclinica("+
            "tipo, fecha, area)"+
			" VALUES (?, ?, ?);";
			addEstadisticas = connection.prepareStatement(query);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ingresa a una nueva Mascota a la base de datos
	 * @param mascota contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int addProximoControl(Cita cita){
	 	int result=0;
	 	try{
	
				addProxControl.setString(1, cita.cliente);
				addProxControl.setString(2, cita.mascota);
				addProxControl.setString(3, cita.fecha);
				addProxControl.setString(4, cita.hora);
				addProxControl.setString(5, cita.servicio);
				addProxControl.setString(6, cita.usuario);
				
				result= addProxControl.executeUpdate();
				//agregando datos a estadisticas clinica
				String[] l =cita.fecha.split("/");
				Date date = new Date(Integer.parseInt(l[2])-1900, Integer.parseInt(l[1])-1, Integer.parseInt(l[0]));
				addEstadisticas.setInt(1, 2);
				addEstadisticas.setDate(2, date);
				addEstadisticas.setInt(3, 2);
				addEstadisticas.executeUpdate();
				//
			} 
	 	catch (SQLException e) {
				e.printStackTrace();
			}
	 	
	 	return result;
	}
	
	/**
	 * Ingresa a una nueva Mascota a la base de datos
	 * @param mascota contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int addActualControl(Control control){
	 	int result=0;
	 	try{
	
				addActuControl.setString(1, control.getCliente());
				addActuControl.setString(2, control.getMascota());
				addActuControl.setString(3, control.getDescripcion());
				addActuControl.setDate(4, control.getFecha());
				addActuControl.setString(5, control.getHora());
				addActuControl.setString(6, control.getResponsable());
				addActuControl.setString(7, control.getServicio());
				addActuControl.setString(8, control.getCosto());
				
				result= addActuControl.executeUpdate();
			} 
	 	catch (SQLException e) {
				e.printStackTrace();
			}
	 	
	 	return result;
	}
 
}
