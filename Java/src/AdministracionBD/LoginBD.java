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
	PreparedStatement selectAll;
	Connection c;
		
	/**
	 *  Se declaran las consultas hacia la base de datos
	 *  @author  "Esteban Cruz"
	 *  @param connection Conexión obtenida con la base de datos
	 **/
	public LoginBD(Connection connection)
	{
		
		this.c= connection;
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
	    	
	    		boolean estado = usuario.getEstado();	
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
	
	
	
	public Usuario getUsuario(String nombre, String contra)
	{
		
		Usuario u = new Usuario();
    	
    	String query = "SELECT nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar, estado, id FROM usuario WHERE usuario='"+nombre.trim()+"' AND contrasena='"+contra.trim()+"';";
	   	
    	try 
    	{
    		selectAll = c.prepareStatement(query);
			ResultSet result = selectAll.executeQuery();
			
    		while(result.next())
    		{
    			//u = new Usuario();
    			u.setNombre(result.getString(1));
    			u.setApellidoPaterno(result.getString(2));
    			u.setApellidoMaterno(result.getString(3));
    			u.setUsuario(result.getString(4));
    			u.setCargo(result.getString(5));
    			u.setContrasena(result.getString(6));
    			u.setServicio(result.getString(7));
    			u.setPermisoRegistrar(result.getBoolean(8));
    			u.setPermisoEditar(result.getBoolean(9));
    			u.setPermisoEliminar(result.getBoolean(10));
    			u.setPermisoPurgar(result.getBoolean(11));
    			u.setEstado(result.getBoolean(12));
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return u;
	}
}
