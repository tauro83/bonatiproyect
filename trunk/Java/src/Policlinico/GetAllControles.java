package Policlinico;
//=======================================================================
//FECHA CREACIÓN: 02/11/09 
//AUTOR: Andrés Garrido
//Clase que contecta la capa 2 con la 3
//=======================================================================

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import PoliclinicoBD.GetAllControlesBD;
import TransferObjects.Control;

/**
 * @author Andres Garrido
 * @version 1
 * Clase que conecta la capa 2 con la 3, en este caso con la clase
 * GetAllControlBD
 */
public class GetAllControles {
	Connection connection;
	/**
	 * Este metodo hace el llamado a la clase equivalente en la capa de BD.
	 * Crea una nueva conexion a la base de datos, y ejecuta el método getAllControles
	 * de la clase GetAllControles BD
	 */
	public List<Control> getAllControles(){		
		List<Control> Atenciones=new ArrayList<Control>();
    	try{
    		connection=DBConnectionManager.getConnection();
    		GetAllControlesBD object= new GetAllControlesBD(connection);
			Atenciones	= object.getAllControles();
			connection.close();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
		return Atenciones;
	}

}
