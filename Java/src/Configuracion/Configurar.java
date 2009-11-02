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

	public static ArrayList<Configuracion> getConfiguracion(String tipo) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);			
		return conBD.getConfiguraciones(tipo);
	}
	
	public static ArrayList<ConfiguracionVacuna> getConfiguracionVacuna() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		return conBD.getConfiguracionesVacunas();
	}
	
	public static void regConfiguracion(String tipo, String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.regConfiguracion(tipo,nombre);
	}
	
	public static void elimConfiguracion(String tipo, String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.elimConfiguracion(tipo,nombre);
	}
	public static void elimConfiguracionVacuna(String nombre) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		conBD.elimConfiguracionVacuna(nombre);
	}
	
	public static String regConfiguracionVacuna(ConfiguracionVacuna cv) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		return conBD.regConfiguracionVacuna(cv);
	}
	
}
