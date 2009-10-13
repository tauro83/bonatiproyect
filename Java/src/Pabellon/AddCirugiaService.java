package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.AddMascotaBD;
import PabellonBD.AddCirugiaBD;
import AdministracionBD.UsuarioEditBD;
import AdministracionBD.UsuarioElimBD;
import TransferObjects.Mascota;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;

public class AddCirugiaService {

	/**
	 * Autor: Jimmy Mu�oz
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Usuario contiene los datos de la persona que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserci�n ha fallado
	 */
	public int AddCirugia(Usuario person)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	
	public String getCliente(String rutCliente){
    	String cliente = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD addCirugiaBD = new AddCirugiaBD(connection);
			cliente = addCirugiaBD.getCliente(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/**
	 * Crea la conexion a la base de datos para retornar todas las mascotas
	 * @return Lista de todas las mascotas
	 */
	public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBD = new AddCirugiaBD(connection);
			mascotas= cirugiaBD.getAllMascotas();		
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
			AddCirugiaBD cirugiaBD= new AddCirugiaBD(connection);
			mascotas= cirugiaBD.getMascotas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
	
}
