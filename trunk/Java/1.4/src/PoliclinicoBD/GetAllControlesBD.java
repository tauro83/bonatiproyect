package PoliclinicoBD;
//=======================================================================
//FECHA CREACIÓN: 02/11/09 
//AUTOR: Andrés Garrido
//Clase que contecta la capa 2 con la 3
//=======================================================================

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Control;

/**
 * @author Andres Garrido
 * @version 1
 * Clase que obtiene todos los controles agendados que estan guardados
 * en la base de datos
 **/
public class GetAllControlesBD {

	PreparedStatement selectAll;
	/**
	 * Constructor de la clase que recibe una conexion creada a la BD
	 * y que prepara el statement para obtener todos los controles
	 * @param conn Conexion creada a partir de DBConnectionManager
	 */
	public GetAllControlesBD(Connection conn) throws SQLException{

		String query = "select * from atencioncontrol;";
		selectAll = conn.prepareStatement(query);
	}
	/**
	 * Este metodo ejecuta el statement preparado y obtiene todos los controles
	 * registrados en la base de datos, creando una lista con objetos Control
	 * @return Lista con los controles registrados.
	 */
	public List getAllControles() {
		List mascotas=new ArrayList();
		Control object;		
    	
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			object = new Control();
    			object.setCliente(result.getString(1).trim());
    			object.setMascota(result.getString(2).trim());
    			object.setDescripcion(result.getString(3).trim());
    			object.setFecha(result.getDate(4));
    			object.setHora(result.getString(5).trim());
    			object.setResponsable(result.getString(6).trim());
    			object.setServicio(result.getString(7).trim());
    			object.setCosto(result.getString(8).trim());
    			
    	
    			mascotas.add(object);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return mascotas;
		
	}

}
