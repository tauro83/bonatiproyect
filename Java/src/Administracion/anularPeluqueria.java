package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.anularPeluqueriaBD;
import Bd.DBConnectionManager;
import PoliclinicoBD.VacunacionBD;
import TransferObjects.anuPeluqueria;
import TransferObjects.vacunacionesObj;

public class anularPeluqueria {
	/**
	 * Trata de obtener todos las vacunaciones registrados en la base de datos
	 * @return Lista con todos las vacunaciones registrados
	 */
	public List<anuPeluqueria> getAllVacunaciones()
    {
		List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllVacunaciones();	
			connection.close();
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
	 * @return Lista con todos las vacunaciones registrados
	 */
	public List<anuPeluqueria> getAllVacunacionesU(String rut)
    {
		List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			vacunaciones = vacunacionBD.getAllVacunacionesU(rut);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public List<anuPeluqueria> getAllVacunacionesA()
    {
		List<anuPeluqueria> vacunaciones = new ArrayList<anuPeluqueria>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
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
	 * Anula todas las vacunaciones solicitadas por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha anulado correctamente y 0 de lo contrario
	 */
	public int anular(String estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
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
	 * Elimina todas las vacunaciones solicitadas por el usuario
	 * de la base de datos
	 * @param 0=activado, 1=desactivo, 2=anulado
	 * @return 1 si ha eliminado correctamente y 0 de lo contrario
	 */
	public int eliminar(String estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
			result = vacunacionBD.eliminar(estado);
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return result;
    }
	
	public int deseliminar(String estado)
    {
		int result = 0;
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			anularPeluqueriaBD vacunacionBD= new anularPeluqueriaBD(connection);
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
