//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR:Nicolas Delgado
// Comentario: Esta Clase desarrolla para la obtencion de los datos desde la
// la capa de interfaz del usuario.
//======================================================================

package Cliente;

import java.sql.Connection;
import java.sql.SQLException;

import Bd.DBConnectionManager;
import TransferObjects.ClienteTO;
import clienteBD.ClienteDB;




public class Clients {

	
	/*public String toString(String nombre,String apellido,String apellido2,String rut,String rut2,String telefono,String telefono2,String celular, String celular2,String direccion,String region,String comuna, String email, String email2 ) throws SQLException{
		
		Connection connection=DBConnectionManager.getConnection();
		ClienteDB cl = new ClienteDB(connection);
		return cl.getCliente();		
	}*/
	
      public String toString(ClienteTO client) throws SQLException{
		
		Connection connection=DBConnectionManager.getConnection();
		ClienteDB cl = new ClienteDB(connection);
		return cl.getCliente();		
	}
	
	/*public String addCliente(String nombre,String apellido,String apellido2,String rut,String rut2,String telefono,String telefono2,String celular, String celular2,String direccion,String region,String comuna, String email, String email2) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ClienteDB cl = new ClienteDB(connection);
		
		return "Retorno:"+cl.addCliente(nombre, apellido, apellido2, rut, rut2, telefono, telefono2, celular, celular2, direccion, region, comuna, email, email2);
		
		
	}*/
      
      public String addCliente(ClienteTO clients) throws SQLException{
  		Connection connection=DBConnectionManager.getConnection();
  		ClienteDB cl = new ClienteDB(connection);
  		
  		return "Retorno:"+cl.addCliente(clients);
  		
  		
  	}
}
