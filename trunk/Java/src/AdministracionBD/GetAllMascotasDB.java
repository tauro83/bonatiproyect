//=======================================================================
// FECHA CREACIÓN: 15/09/09 
// AUTOR: Andrés Garrido
// Clase de la capa 3
//=======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;
/**
 * Clase que obtiene todas las mascotas registradas en el sistema
 * desde la base de datos
 * @author Andrés Garrido 
 * @version 1.0 15/09/09
*/
public class GetAllMascotasDB{
	PreparedStatement selectAll;
	Connection connection;

	/**
     * Constructor de la clase que a partir de una conexion a la BD establecida,
     * prepara la sentencia SQl a ejecutar
     * @param connection Conexion a la base de datos a partir de DBConnectionManager
     */
	public GetAllMascotasDB(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "SELECT *"+
		"FROM mascota;";

		selectAll = connection.prepareStatement(query);
	}

	/**
	 * Método que ejecuta la sentencia SQL preparada anteriormente,
	 * y obtiene cada tupla, creando una nueva clase Mascota
	 * y agregándola a una lista
	 * @return Lista con todas las mascotas en la Base de Datos
	 */
	public List<Mascota> getAllMascotas()
    {
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mas;		
    	
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			mas = new Mascota();
    			mas.setRutCliente(result.getString(1));
    			mas.setNombre(result.getString(2));
    			mas.setFechaNacimiento(result.getString(3));
    			mas.setClaseAnimal(result.getString(4));
    			mas.setRaza(result.getString(5));
    			mas.setSexo(result.getString(6));
    			mas.setEstado(result.getBoolean(7));
    			mascotas.add(mas);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return mascotas;
    }
}
