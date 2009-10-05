//=======================================================================
// FECHA CREACIÓN: 10 de Septiembre de 2009
// AUTOR: Sebastian Arancibia
// …. Clase para la comunicacion entre flex y java 
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import AdministracionBD.AddMascotaBD;
import TransferObjects.Mascota;


/**
 * Clase utilizada para la comunicacion entre capa 1 y 2 (Flex y Java)
 *
 * @author  Sebastian Arancibia
 * @version 0.1, 22/09/09
 */
public class AddMascotaService{
	public String getCliente(String rutCliente){
    	String cliente = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddMascotaBD addMascotaBD = new AddMascotaBD(connection);
			cliente = addMascotaBD.getCliente(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/**
	 * Crea la conexion a la base de datos para registrar una mascota
	 * @param mascota contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int addMascota(Mascota mascota){
		int result=0;
		try{
			Connection connection=DBConnectionManager.getConnection();
			AddMascotaBD mascotaBD= new AddMascotaBD(connection);
			result= mascotaBD.addMascota(mascota);		
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
    }
	

	/**
	 * Crea la conexion a la base de datos para retornar todas las mascotas
	 * @return Lista de todas las mascotas
	 */
	public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddMascotaBD mascotaBD = new AddMascotaBD(connection);
			mascotas= mascotaBD.getAllMascotas();		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
    
	/**
	 * Crea la conexion a la base de datos para retornar las mascotas de @param
	 * @param rutCliente Rut de Cliente que se quiere retornar sus mascotas
	 * @return Lista de mascotas
	 */
	public List<Mascota> getMascotas(String rutCliente){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddMascotaBD mascotaBD= new AddMascotaBD(connection);
			mascotas= mascotaBD.getMascotas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
}
