//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo
// Descripcion:   Clase que es llamada desde la capa de presentacion, en particular del action Script 
//=======================================================================
package ConfiguracionBD;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Configuracion;
import TransferObjects.ConfiguracionVacuna;
import TransferObjects.Mascota;
import TransferObjects.Usuario;

public class ConfigurarBD {
	PreparedStatement selectAll;
	PreparedStatement selectRazas;
	Connection connection;
	
	/**
	 * constructor de la clase, establece la conexion
	 * @param connection establece la conexion con la base de datos.
	 */
	public ConfigurarBD(Connection connection){
		this.connection = connection;
	}
	
	/**
	 * obtiene la configuraciones 
	 * @param tipo es la diferencia entre las distintas configuraciones registradas en el sistema
	 * especificament es especie
	 * @return una lista de configuraciones segun el tipo del argumento
	 * @throws SQLException 
	 */
	public ArrayList getRazas(String especie) throws SQLException{
    	ArrayList  razas=new ArrayList();
    	Configuracion configuracion;

		String query="";	
		/**Consulta a la base de datos, Selecciona todas las mascotas registradas en la base de datos*/
		query = "SELECT nombre " +
				"FROM raza " +
				"WHERE especie = ?;";
		selectRazas = connection.prepareStatement(query);

    	try{
    		selectRazas.setString(1, especie.trim());
    		ResultSet result = selectRazas.executeQuery();
    		while(result.next()){
    			configuracion = new Configuracion();
    			configuracion.setNombre(result.getString(1));
    			razas.add(configuracion);
    		}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return razas;
		
	}
	
	/**
	 * obtiene la configuraciones 
	 * @param tipo es la diferencia entre las distintas configuraciones registradas en el sistema
	 * las configuraciones pueden ser: Servicio, Especie, Cargo
	 * @return una lista de configuraciones segun el tipo del argumento
	 * @throws SQLException 
	 */
	public ArrayList getConfiguraciones(String tipo) throws SQLException{
		ArrayList configuraciones=new ArrayList();
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
				
		try 
    	{
    		selectAll = connection.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			conf = new Configuracion();
    			conf.setNombre(result.getString(1).trim());
    			configuraciones.add(conf);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	connection.close(); 
    	return configuraciones;
		
	}
	/**
	 * obtiene la vacunas
	 * @return una lista de configuraciones de vacunas, esta lista es del tipo COnfiguracionVacuna
	 * @throws SQLException 
	 */
	public ArrayList getConfiguracionesVacunas() throws SQLException {
		ArrayList configuraciones=new ArrayList();
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
    			conf.setPrecio(result.getString(2));
    			conf.setCaducidad(result.getString(3));
    			conf.setDescripcion(result.getString(4));
    			
    			configuraciones.add(conf);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	connection.close();  
    	return configuraciones;
	}
	
	/**
	 * registra una nueva configuracion especificando el tipo
	 * @param tipo es la diferencia entre las distintas configuraciones registradas en el sistema
	 * las configuraciones pueden ser: Servicio, Especie, Cargo
	 * @param nombre es el valor de la configuracion segun el tipo.
	 */
	public void regConfiguracion(String tipo, String nombre) throws SQLException
	{
		String query = "";
		tipo = tipo.trim();
		nombre = nombre.trim();
		if(tipo.equals("Servicio")){
			query = "INSERT INTO Servicio VALUES (?);";
		}
		if(tipo.equals("Especie")){
			query = "INSERT INTO Especie VALUES (?);";
		}
		if(tipo.equals("Cargo")){
			query = "INSERT INTO Cargo VALUES (?);";
		}		
		
				
		PreparedStatement insert;
		insert = connection.prepareStatement(query);
		
		insert.setString(1, nombre);
		
		try 
    	{
			insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	connection.close(); 
	}
	/**
	 * registra una nueva configuracion especificando el tipo
	 * @param especie que se quiere asociar la raza
	 * @param raza que se quiere registrar
	 */
	public void regRaza(String especie, String raza) throws SQLException
	{
		String query = "";
		
		query = "INSERT INTO raza(especie, nombre) VALUES (?, ?);";

				
		PreparedStatement insert;
		insert = connection.prepareStatement(query);
		
		insert.setString(1, especie.trim());
		insert.setString(2, raza);
		
		try 
    	{
			insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	connection.close(); 
	}
	
	/**
	 * Elimina la configuracion indicada por el tipo y el nombre
	 * @param tipo es la diferencia entre las distintas configuraciones registradas en el sistema
	 * las configuraciones pueden ser: Servicio, Especie, Cargo
	 * @param nombre es el valor de la configuracion segun el tipo.
	 */
	public void elimConfiguracion(String tipo, String nombre) throws SQLException
	{
		String query = "";
		tipo = tipo.trim();
		nombre = nombre.trim();
		if(tipo.equals("Servicio")){
			query = "DELETE FROM Servicio WHERE nombre = ?";
		}
		if(tipo.equals("Especie")){
			query = "DELETE FROM Especie WHERE nombre = ?";
		}
		if(tipo.equals("Cargo")){
			query = "DELETE FROM Cargo WHERE nombre = ?";
		}		
		 	
		PreparedStatement insert;
		insert = connection.prepareStatement(query);		
		insert.setString(1, nombre);
		
		try 
    	{
			insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	connection.close(); 
	}
	
	/**
	 * Elimina la configuracion de la vacuna
	 * @param nombre es el valor de la vacuna que sera eliminada
	 */
	public String elimConfiguracionVacuna(String nombre) throws SQLException
	{
		String query = "";
		nombre = nombre.trim();		
		query = "DELETE FROM Vacuna WHERE nombre = ?";
		String out = "1";
		
		PreparedStatement insert;
		insert = connection.prepareStatement(query);
		insert.setString(1, nombre);
		
		try 
    	{
			insert.executeUpdate();
			
		} 
    	catch (SQLException e) 
    	{
			out = "0";
		}
    	connection.close(); 
    	
    	
    	return out;
	}
	
	/**
	 * Elimina la configuracion de la vacuna
	 * @param nombre es el valor de la vacuna que sera eliminada
	 */
	public String elimRaza(String especie, String raza) throws SQLException
	{
		String query = "";
		query = "DELETE FROM Raza WHERE especie = ? AND nombre = ?;";
		String out = "1";
		
		PreparedStatement insert;
		insert = connection.prepareStatement(query);
		
		insert.setString(1, especie);
		insert.setString(2, raza);
		
		try 
    	{
			insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			out = "0";
		}
    	connection.close(); 
    	return out;
	}
	
	/**
	 * Registra la configuracion
	 * @param cv corresponde a un obtejo que encapsula los datos de una vacuna
	 * los cuales seran registrados en la base de datos. 
	 */
	public String regConfiguracionVacuna(ConfiguracionVacuna cv) throws SQLException
	{
		String query = "";
		String out = "";
		
		query = "INSERT INTO Vacuna(nombre,precio,caducidad,descripcion) VALUES(?,?,?,?);";
							
		PreparedStatement insert;
		insert = connection.prepareStatement(query);
		
		insert.setString(1, cv.nombre.trim());
		insert.setInt(2,Integer.parseInt(cv.precio.trim()));
		insert.setInt(3,Integer.parseInt(cv.caducidad.trim()));
		insert.setString(4,cv.descripcion.trim());		
		try 
    	{
			
			insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			out = e.toString();
		}
    	connection.close(); 
    	
    	return out;
    	
	}
	
	/**
	 * Registra la configuracion
	 * @param cv corresponde a un obtejo que encapsula los datos de una vacuna
	 * los cuales seran registrados en la base de datos. 
	 */
	public List getAsuntos() throws SQLException
	{
		List out = new ArrayList();
		String query = "";
		
		query = "SELECT nombre "+
			"FROM asuntowebaviso;"; 
		try 
    	{
    		selectAll = connection.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			
    			out.add(result.getString(1).trim());
    			
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	connection.close(); 
		
    	return out;
    	
	}
	
}





    	
   
	


