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
import TransferObjects.ConfiguracionVacuna;

public class ConfigurarBD {
	PreparedStatement selectAll;
	Connection connection;

	public ConfigurarBD(Connection connection){
		this.connection = connection;
	}
	
	public ArrayList<Configuracion> getConfiguraciones(String tipo){
		ArrayList<Configuracion> configuraciones=new ArrayList<Configuracion>();
		Configuracion conf;
		String query = "";
		tipo = tipo.trim();
		if(tipo.equals("Servicio")){
			query = "SELECT nombre FROM Servicio";
		}
		if(tipo.equals("Especie")){
			query = "SELECT nombre FROM Especie";
		}
		if(tipo.equals("Cargo")){
			query = "SELECT nombre FROM Cargo";
		}		
		else{
			System.out.println("ninguno!!!!!!!!!!!");
		}
		
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

	public ArrayList<ConfiguracionVacuna> getConfiguracionesVacunas() {
		ArrayList<ConfiguracionVacuna> configuraciones=new ArrayList<ConfiguracionVacuna>();
		ConfiguracionVacuna conf;
		String query = "SELECT nombre,precio,caducidad,descripcion FROM vacuna";
		
		try 
    	{
    		selectAll = connection.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			conf = new ConfiguracionVacuna();
    			conf.setNombre(result.getString(1));
    			conf.setPrecio(result.getInt(2));
    			conf.setCaducidad(result.getInt(3));
    			conf.setDescripcion(result.getString(4));
    			
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





    	
   
	


