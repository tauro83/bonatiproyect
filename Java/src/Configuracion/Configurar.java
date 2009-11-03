/**
 * @author Camilo Verdugo
 * @version 1	
 **/
package Configuracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Bd.DBConnectionManager;
import TransferObjects.Configuracion;
import TransferObjects.ConfiguracionVacuna;
import ConfiguracionBD.ConfigurarBD;

public class Configurar {

	/**
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public static ArrayList<Configuracion> getConfiguracion(String tipo) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);			
		return conBD.getConfiguraciones(tipo);
	}
	
	/**
	 * @param tipo obtiene las configuraciones que corresponden a las vacunas, desde de 
	 * la capa ConfiguracionBD
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public static ArrayList<ConfiguracionVacuna> getConfiguracionVacuna() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		return conBD.getConfiguracionesVacunas();
	}
	
	/**
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @param nombre corresponde al dato segun el tipo que se desea registrar
	 */
	public static void regConfiguracion(String tipo, String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.regConfiguracion(tipo,nombre);
	}
	/**
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @param nombre corresponde al dato segun el tipo que se desea eliminar
	 */
	public static void elimConfiguracion(String tipo, String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.elimConfiguracion(tipo,nombre);
	}
	/**
	 * @param corresponde al nombre de la vacuna que se desea eliminar
	 */
	public static void elimConfiguracionVacuna(String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.elimConfiguracionVacuna(nombre);
	}
	/**
	 * @param cv es un objeto del tipo configuracionVacuna, el cual es enviado a la capa 3
	 * para registrarse en la BD, este objeto contiene informacion de la vacuna, tal como:
	 * nombre, descripcion, precio, fecha de caducidad.
	 * @return un mensaje si el registro fue exitoso
	 */
	public static String regConfiguracionVacuna(ConfiguracionVacuna cv) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		return conBD.regConfiguracionVacuna(cv);
	}
	
}
