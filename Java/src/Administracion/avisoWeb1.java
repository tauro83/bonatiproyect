package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.anularPreoperatorioBD;
import AdministracionBD.avisoWebBD;
import Bd.DBConnectionManager;
import TransferObjects.aviWeb;;

public class avisoWeb1 {
		/**
		 * Este metodo obteniene todos los registros de peluquería que se encuentran
		 * en la base de datos del sistema.
		 * @return Lista con todos los registros de peluquería.
		 */
		
		public List<aviWeb> getAllVacunacionesA()
	    {
			List<aviWeb> vacunaciones = new ArrayList<aviWeb>();
	    	try 
			{
				Connection connection=DBConnectionManager.getConnection();
				avisoWebBD vacunacionBD= new avisoWebBD(connection);
				vacunaciones = vacunacionBD.getAllVacunacionesA();
				connection.close();
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
		public int anular(Integer estado)
	    {
			int result = 0;
	    	try 
			{
				Connection connection=DBConnectionManager.getConnection();
				avisoWebBD vacunacionBD= new avisoWebBD(connection);
				result = vacunacionBD.anular(estado);
				connection.close();
			} 
	    	catch (SQLException e) 
			{
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
		public int eliminar(Integer estado)
	    {
			int result = 0;
	    	try 
			{
				Connection connection=DBConnectionManager.getConnection();
				anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
				result = vacunacionBD.eliminar(estado);
				connection.close();
			} 
	    	catch (SQLException e) 
			{
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
		public int deseliminar(Integer estado)
	    {
			int result = 0;
	    	try 
			{
				Connection connection=DBConnectionManager.getConnection();
				anularPreoperatorioBD vacunacionBD= new anularPreoperatorioBD(connection);
				result = vacunacionBD.deseliminar(estado);
				connection.close();
		
		} 
	    	catch (SQLException e) 
			{
				e.printStackTrace();
			}
	    	return result;
	    }

}
