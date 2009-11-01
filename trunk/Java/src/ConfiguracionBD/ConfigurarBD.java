/**
 * @author Camilo Verdugo
 * @version 2
 */
package ConfiguracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import TransferObjects.Configuracion;

public class ConfigurarBD {
	PreparedStatement selectAll;
	Connection connection;

	public ConfigurarBD(Connection connection){
		this.connection = connection;
	}
	
	public ArrayList<Configuracion> getConfiguraciones(){
		ArrayList<Configuracion> configuraciones=new ArrayList<Configuracion>();
		Configuracion conf;
		String query = "SELECT nombre FROM servicio";
		
		try 
    	{
    		selectAll = connection.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			conf = new Configuracion();
    			conf.setNombre(result.getString(1));
    			configuraciones.add(conf);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return configuraciones;
		
	}
}





    	
   
	


