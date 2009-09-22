package logica;

import java.sql.Connection;
import java.sql.SQLException;

import transferObjects.Usuario;
import bd.DBConnectionManager;
import bd.MantenerUsuario;

public class Administracion {

	
	public String toString(Usuario u) throws SQLException{	
		
		//return u.permisoEditar.toString();
		Connection connection=DBConnectionManager.getConnection();
		MantenerUsuario mu = new MantenerUsuario(connection);
		return mu.getUsuarios();
		
	}
	
	public String addUsuario(Usuario u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		MantenerUsuario mu = new MantenerUsuario(connection);
		
		return "Retorno:"+mu.addUsuario(u);
		
		
	}
	
}
