package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TransferObjects.Usuario;

public class LoginBD {
	
	PreparedStatement selectAllUsuarios;
	
	/**
	 * Se declaran las consultas hacia la base de datos
	 * @param connection Conexión obtenida con la base de datos
	 */
	public LoginBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT usuario, contrasena " +
					"FROM usuario;";
			selectAllUsuarios = connection.prepareStatement(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Obtiene los usuarios existentes en la base de datos, 
	 * y verifica que el login ingresado sea correcto
	 * @return 1 si el login ingresado es correcto, de lo 
	 * contrario 0
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
	    		usuario.setContrasena(result.getString(1));
	    		usuario.setUsuario(result.getString(2));
	    	
	    		String name = usuario.getUsuario();
	    		String pass = usuario.getContrasena();
	    		String passNew;
	    		String nameNew;
	    		passNew = pass.trim();
	    		nameNew = name.trim();
	    		if(passNew.equals(passLogin) && nameNew.equals(nameLogin)){
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

}
