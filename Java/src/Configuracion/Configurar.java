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
import ConfiguracionBD.ConfigurarBD;
import TransferObjects.ConfiguracionVacuna;

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
	
	
	
}
