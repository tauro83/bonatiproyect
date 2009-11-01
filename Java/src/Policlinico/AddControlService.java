package Policlinico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import PoliclinicoBD.AddControlBD;
import TransferObjects.Cita;
import TransferObjects.Control;
import Bd.DBConnectionManager;


public class AddControlService {
		
		/**
		 * Crea la conexion a la base de datos para registrar una cita
		 * @param cita contiene los datos de la cita que se quiere ingresar
		 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
		 */
		public int addProxControl(Cita cita){
			//System.out.println(cita.cliente+"|");
			//System.out.println(cita.fecha+"|");
			//System.out.println(cita.hora+"|");
			//System.out.println(cita.mascota+"|");
			//System.out.println(cita.servicio+"|");
			//System.out.println(cita.usuario+"|");
			
			int result=0;
			try{
				Connection connection=DBConnectionManager.getConnection();
				AddControlBD addControlBD= new AddControlBD(connection);
				result= addControlBD.addProximoControl(cita);		
				connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * Crea la conexion a la base de datos para registrar una cita
		 * @param cita contiene los datos de la cita que se quiere ingresar
		 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
		 */
		public int addActualControl(Control control){
			int result=0;
			try{
				Connection connection=DBConnectionManager.getConnection();
				AddControlBD addControlBD= new AddControlBD(connection);
				
	    		Calendar c = Calendar.getInstance();
	    		int hora = c.get(Calendar.HOUR_OF_DAY);
	    		int minutos = c.get(Calendar.MINUTE);
	    		int segundos = c.get(Calendar.SECOND);
	    		
	    		control.setHora(hora+":"+minutos+":"+segundos);
				
				result= addControlBD.addActualControl(control);		
				connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			return result;
		}
		
}
