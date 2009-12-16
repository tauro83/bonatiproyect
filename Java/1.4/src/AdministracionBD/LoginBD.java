//=======================================================================
// FECHA CREACIÓN: 15/09/09
// AUTOR: Esteban Cruz
// Clase de login del sistema, dentro de esta se puede realizar 
// comprobacion para el login, haciendo de la funcion que hace
// la consulta a la base de datos 
//=======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TransferObjects.Usuario;

public class LoginBD {
	
	PreparedStatement selectAllUsuarios;
	PreparedStatement selectUsuario;
	
	/**
	 *  Se declaran las consultas hacia la base de datos
	 *  @author  "Esteban Cruz"
	 *  @param connection Conexión obtenida con la base de datos
	 **/
	public LoginBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT usuario, contrasena, estado " +
					"FROM usuario;";
			selectAllUsuarios = connection.prepareStatement(query);
			
			query = "SELECT pregistrar, peditar, peliminar, ppurgar "+
					"FROM usuario "+
					"WHERE usuario = ? AND contrasena = ? ;";
			selectUsuario = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  Obtiene los usuarios existentes en la base de datos, 
	 *  y verifica que el login ingresado sea correcto
	 *  @author  "Esteban Cruz"
	 *  @return 1 si el login ingresado es correcto, de lo 
	 *  contrario 0
	 */
	public int existLogin(Usuario login){
	    Usuario usuario;
	    String nameLogin=login.getUsuario();
	    String passLogin=login.getContrasena();
	    try 
	    {
	    	ResultSet result = selectAllUsuarios.executeQuery();
	    	while(result.next())
	    	{
	    		usuario = new Usuario();
	    		usuario.setContrasena(result.getString(2));
	    		usuario.setUsuario(result.getString(1));
	    		usuario.setEstado(result.getBoolean(3));
	    	
	    		Boolean estado = usuario.getEstado();	
	    		String name = usuario.getUsuario();
	    		String pass = usuario.getContrasena();
	    		pass = pass.trim();
	    		name = name.trim();
	    		if(pass.equals(passLogin) && name.equals(nameLogin) && estado==true){
	    			return 1;
	    		}
	    	}
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    return 0;
	 }
	public boolean pRegistrar(Usuario login){
	    try 
	    {
	    	Usuario usuario = new Usuario();
		    boolean registrar=false;
		    ResultSet user; 
		    String nameLogin=login.getUsuario();
		    String passLogin=login.getContrasena();
	    	selectUsuario.setString(1, nameLogin);
	    	selectUsuario.setString(2, passLogin);
	    	user = selectUsuario.executeQuery();
			while(user.next()){
				usuario.setPermisoRegistrar(user.getBoolean(1));
				registrar = usuario.getPermisoRegistrar();
			}
	    			return registrar;
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    return false;
	 }
	
	public boolean pEditar(Usuario login){
	    try 
	    {
	    	Usuario usuario = new Usuario();
		    boolean editar=false;
		    ResultSet user; 
		    String nameLogin=login.getUsuario();
		    String passLogin=login.getContrasena();
	    	selectUsuario.setString(1, nameLogin);
	    	selectUsuario.setString(2, passLogin);
	    	user = selectUsuario.executeQuery();
			while(user.next()){
				usuario.setPermisoEditar(user.getBoolean(2));
				editar = usuario.getPermisoEditar();

			}
	    	return editar;
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    return false;
	 }
	
	public boolean pEliminar(Usuario login){
	    try 
	    {
	    	Usuario usuario = new Usuario();
		    boolean eliminar=false;
		    ResultSet user; 
		    String nameLogin=login.getUsuario();
		    String passLogin=login.getContrasena();
	    	selectUsuario.setString(1, nameLogin);
	    	selectUsuario.setString(2, passLogin);
	    	user = selectUsuario.executeQuery();
			while(user.next()){
				usuario.setPermisoEliminar(user.getBoolean(1));
				eliminar = usuario.getPermisoEliminar();

			}
	    	return eliminar;
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    return false;
	 }
	
	public boolean pPurgar(Usuario login){
	    try 
	    {
	    	Usuario usuario = new Usuario();
		    boolean purgar=false;
		    ResultSet user; 
		    String nameLogin=login.getUsuario();
		    String passLogin=login.getContrasena();
	    	selectUsuario.setString(1, nameLogin);
	    	selectUsuario.setString(2, passLogin);
	    	user = selectUsuario.executeQuery();
			while(user.next()){
				usuario.setPermisoPurgar(user.getBoolean(1));
				purgar = usuario.getPermisoPurgar();

			}
	    	return purgar;
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    return false;
	 }
}
