//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo
// Descripcion:  Clase entidad Usuario de sistema, encapsula informacion de un
//				Usuario y el privilegio de acceso al sistema.
//				Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================
package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import TransferObjects.Usuario;

public class AddUsuarioBD {

	Connection connection;
	/**
	 * Constructor de la conexion
	 * @param connection es el enlace a la BD
	 */
	public AddUsuarioBD(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * Registra el usuario en la BD
	 * @param u transferobject usuario
	 */
	public String addUsuario(Usuario u) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";			
		query = "INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar) "+
				"VALUES (?, ?, ?, ?,?,? ,?,?,? ,?,?);";			
		insert = connection.prepareStatement(query);
		
		insert.setString(1, u.nombre);
		insert.setString(2, u.apellidoPaterno);
		insert.setString(3, u.apellidoMaterno);
		insert.setString(4, u.usuario);
		insert.setString(5, u.cargo);
		insert.setString(6, u.contrasena);
		insert.setString(7, u.servicio);		
		insert.setBoolean(8, u.permisoRegistrar);
		insert.setBoolean(9, u.permisoEditar);
		insert.setBoolean(10, u.permisoEliminar);
		insert.setBoolean(11, u.permisoPurgar);	
		
		try 
    	{
			result=""+insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+e.toString(); 
			
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
	}
	
}