//=======================================================================
// FECHA CREACI�N: 15/09/09 
// AUTOR: Andr�s Garrido
// Clase de la capa 2
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import TransferObjects.Mascota;

import AdministracionBD.GetAllMascotasDB;
import Bd.DBConnectionManager;
/**
 * Clase que obtiene todas las mascotas registradas en el sistema
 * obteni�ndolas de la capa 3
 * @author Andr�s Garrido 
 * @version 1.0 15/09/09
*/

public class GetAllMascotas {
	Connection connection;
	
    /**
     * Constructor de la clase que obtiene una nueva conexion para la
     * base de datos
     */
	public GetAllMascotas(){
		try{    		
			connection=DBConnectionManager.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
     * M�todo que obtiene las mascotas, enviando la conexion creada como
     * par�metro
     * @return retorna una lista con todas las mascotas
     */
	public List getAllMascotas() throws SQLException{
		GetAllMascotasDB object= new GetAllMascotasDB(connection);
		return object.getAllMascotas();
	}

}
