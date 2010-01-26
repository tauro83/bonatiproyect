//=======================================================================
// FECHA CREACI�N: 20/11/09
// AUTOR: Erwin D�az
// Comentarios: Transfiere datos entre la base de datos hacia la
//				capa l�gica.
//=======================================================================
package Petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Producto;
/**
 * Clase en la que se declaran las consultas hacia la base de datos
 * @author Erwin D�az
 *
 */
public class PetshopBD {
	
	PreparedStatement insert;
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexi�n obtenida con la base de datos
	 */
	public PetshopBD(Connection connection)
	{
		try 
		{
			String query="";			
			query = "INSERT INTO producto(nombre, precio, categoria, codigo, descripcion) "+
			"VALUES (?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	public int regProductoBD(Producto person)
    {
		String result = null;
		
		//Formateando parametros
		
		person.nombre = person.nombre.toUpperCase();
		String codigo = "";
		for(int i=0;i<13-person.codigo.length();i++){
			codigo+="0";
		}
		codigo += person.codigo;
		
		String nombre =person.nombre.trim();
		for(int j=0;j<15-person.nombre.length();j++){
			nombre+=" ";
		}
		nombre+="A";
		
		try 
    	{
			String prec =  person.precio.replace(".", "");
			prec = prec.replace("$", "");
			insert.setString(1, nombre);
			insert.setString(2, prec);
			insert.setString(3, person.categoria);
			insert.setString(4, codigo);
			insert.setString(5, person.descripcion);
			
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	if(result.length()==1){
    		return 1;
    		
    	}
    	else {
    		return   0;  	
		}
    	
    }
}
