package PoliclinicoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Control;
import TransferObjects.Mascota;

/**
 * @author Andres Garrido
 * @version 1
 * Clase que obtiene todos los controles agendados que estan guardados
 * en la base de datos
 **/
public class GetAllControlesBD {

	PreparedStatement selectAll;
	public GetAllControlesBD(Connection conn) throws SQLException{

		String query = "select * from atencioncontrol;";
		selectAll = conn.prepareStatement(query);
	}
	public List<Control> getAllControles() {
		List<Control> mascotas=new ArrayList<Control>();
		Control object;		
    	
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			object = new Control();
    			object.setDescripcion(result.getString(1));
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
