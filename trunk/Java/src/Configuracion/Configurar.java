//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo
// Descripcion:  obtiene las nuevas configuraciones y obtiene las nuevas configuraciones de configuracionBD
//=======================================================================
package Configuracion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.Configuracion;
import TransferObjects.ConfiguracionVacuna;
import ConfiguracionBD.ConfigurarBD;
import TransferObjects.configCirugia;

public class Configurar { 

	/**
	 * Obtiene las configuraciones para el tipo enviado
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public static ArrayList getConfiguracion(String tipo) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);	
		return conBD.getConfiguraciones(tipo);
		
	}
	/**
	 * Obtiene las configuraciones para el tipo enviado
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @return especie una lista con todas las tuplas del tipo enviado como parametro
	 */
	public static ArrayList getRazas(String especie) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);		
		return conBD.getRazas(especie);
		
	}
	
	/**
	 * Obtiene una lista de todas las vacunas
	 * @param tipo obtiene las configuraciones que corresponden a las vacunas, desde de 
	 * la capa ConfiguracionBD
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public static ArrayList getConfiguracionVacuna() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		return conBD.getConfiguracionesVacunas();
	}
	
	/**
	 * Registrar la configuracion
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
	 * Registrar la configuracion
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @param especie corresponde al dato segun el tipo que se desea registrar
	 * @param raza corresponde al dato tipo raza que se quiere registrar
	 */
	public static void regRaza(String especie, String raza) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.regRaza(especie,raza);
	}
	/**
	 * Eliminar la configuracion especificando el nombre de la configuracion y el nombre del dato
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
	 * Eliminar la configuracion especificando el nombre de la configuracion y el nombre del dato
	 * @param tipo obtiene las configuraciones de la capa ConfiguracionBD, los tipos pueden ser
	 * Especies, Servicios, Cargos
	 * @param nombre corresponde al dato segun el tipo que se desea eliminar
	 */
	public static void elimRaza(String especie, String raza) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.elimRaza(especie,raza);
	}
	
	/**
	 * Elimina una configuracion de vacuna
	 * @param corresponde al nombre de la vacuna que se desea eliminar
	 */
	public static String elimConfiguracionVacuna(String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		return conBD.elimConfiguracionVacuna(nombre);
	}
	/**
	 * registra la configuraicon de vacuna
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
	
	/**
	 * Solicita a la base de datos los asuntos de web aviso
	 * @author  Jimmy Muñoz
	 * @return el listado de los asuntos de web aviso
	 */
	public static List getAsuntos() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		List lss = conBD.getAsuntos();
		connection.close();
		return lss;
	}
	
	/**
	 * Obtiene una lista de todas las Cirugias
	 * @param tipo obtiene las configuraciones que corresponden a las Cirugias, desde de 
	 * la capa ConfiguracionBD
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public static ArrayList getConfiguracionCirugias() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		ArrayList ar = conBD.getConfiguracionesCirugias();
		connection.close();
		return ar;
	}
	
	/**
	 * Elimina una configuracion de Cirugia
	 * @param corresponde al nombre de la Cirugia que se desea eliminar
	 */
	public static String elimConfiguracionCirugia(String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		String ars = conBD.elimConfiguracionCirugia(nombre);
		connection.close();
		return ars;
	}
	/**
	 * registra la configuraicon de Cirugia
	 * @param cv es un objeto del tipo configuracionCirugia, el cual es enviado a la capa 3
	 * para registrarse en la BD, este objeto contiene informacion de la Cirugia, tal como:
	 * nombre, descripcion, precio, fecha de caducidad.
	 * @return un mensaje si el registro fue exitoso
	 */
	public static String regConfiguracionCirugia(configCirugia cv) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		String ars = conBD.regConfiguracionCirugia(cv);
		connection.close();
		return ars;
		
	}
	
	
}
