//=======================================================================
// FECHA CREACIÓN: 21 Septiembre 2009
// AUTOR: Camilo Verdugo G.
// DESCRIPCION: Clase de control que gestiona mantener usuario,
// agenda, citas, cliente, mascotas, fichas y aviso
//=======================================================================

package logica;

import java.sql.Connection;
import java.sql.SQLException;

import transferObjects.Usuario;
import bd.DBConnectionManager;
import bd.MantenerUsuario;

public class Administracion {
	
	/**
	 * @descripcion Metodo para probar la conexion
	 * @author Camilo Verdguo G.
	 * @version 1 
	 * @fechaCreacion 22 Septiembre
	 * @fechaModificacion 
	 * @autorModificacion 
	*/
	public String toString(Usuario u) throws SQLException{	
		
		//return u.permisoEditar.toString();
		Connection connection=DBConnectionManager.getConnection();
		MantenerUsuario mu = new MantenerUsuario(connection);
		return mu.getUsuarios();
		
	}
	
	/**
	 * @descripcion Recive un usuario  de la capa de interfaz y crea la conexion 
	 * con la capa de BD y pasa el usuario a una clase de la capa de BD
	 * @author Camilo Verdguo G.
	 * @fechaCreacion 22 Septiembre
	 * @fechaModificacion 
	 * @autorModificacion 
	 * @param u Descripción del parámetro.
	 * @pre precondición uno
	 * @return valor a retornar
	*/
	public String addUsuario(Usuario u) throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		MantenerUsuario mu = new MantenerUsuario(connection);		
		return "Retorno:"+mu.addUsuario(u);		
	}
	
}
