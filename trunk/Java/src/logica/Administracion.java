//=======================================================================
// FECHA CREACIÓN: 21 Septiembre 2009
// AUTOR: Camilo Verdugo G.
// DESCRIPCION: Clase de control que gestiona mantener: usuario,
// agenda, citas, cliente, mascotas, fichas y aviso
//=======================================================================

package logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import transferObjects.Mascota;
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
		return mu.addUsuario(u);		
	}
	/**
	 * @descripcion Recibe un objeto Mascota para insertarlo en la BD 
	 * @author Andres Garrido
	 * @fechaCreacion 22 Septiembre
	 * @fechaModificacion 
	 * @autorModificacion 
	 * @param mascota Mascota a ser insertada
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	*/
	public int insertMascota(Mascota mascota){
		return MascotaService.insertMascota(mascota);
    }
	/**
	 * @descripcion Elimina una mascota con el id ingresado
	 * @author Andres Garrido
	 * @fechaCreacion 22 Septiembre
	 * @fechaModificacion 
	 * @autorModificacion 
	 * @param id identificador de la mascota a ser eliminada
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	*/
	public int deleteMascota(int id){
		return MascotaService.deleteMascota(id);
    }
	public int purgarMascota(int id){
		return MascotaService.purgarMascota(id);
	}
	/**
	 * @descripcion Obtiene una lista de objetos Mascota de la 
	 * base de datos
	 * @author Andres Garrido
	 * @fechaCreacion 22 Septiembre
	 * @fechaModificacion 
	 * @autorModificacion 
	 * @param no tiene
	 * @return una lista de Mascotas
	*/
    public List<Mascota> getAllMascotas(){
		return MascotaService.getAllMascotas();
    }
	
}
