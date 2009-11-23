package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import AdministracionBD.AddConsultaBD;
import Bd.DBConnectionManager;
import PoliclinicoBD.AddVacunacionBD;
import TransferObjects.Cliente;
import TransferObjects.Consulta;
import TransferObjects.Mascota;

/**
 * @author Nicolas Delgado
 *  Clase entidad Consulta de una atencion, encapsula informacion de una consulta.
 *  Solo contiene los metodos para hacer get/set de los atributos.
 *  		
 **/

public class AddConsultaService {

	/**
	 * 
	 * @return Este metodo retorna un int, que indica que la consulta fue registrada
	 * al interior de la base de datos.
	 */
	public static int addConsulta(Consulta consult2) throws SQLException
    {		
			
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddConsultaBD con = new AddConsultaBD(connection);
			result = con.addConsulta(consult2);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
			return result ;
		
    }
	/**
	 * Este metodo se encarga de recibir el rut del cliente que fue enviado desde la capa uno, por el
	 * cual se realiza la busqueda al interior de la base de datos.	  
	 *  
	 * @return Este metodo retorna un lista, el cual nos muestra a todo los clientes que se encuentran
	 * con ese rut en base de datos.
	 */
	
	public Cliente getCliente(String rutCliente){
    	Cliente cliente = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddConsultaBD vacunaBd = new AddConsultaBD(connection);
			cliente = vacunaBd.getCliente(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/**
	 * Este metodo se encarga de mostrar todas las mascotas que se encuentran asociado a un 
	 * cliente seleccionado anteriormente.  
	 *  
	 * @return Este metodo retorna un lista, con todas las mascotas que corresponden al cliente
	 * que fue seleccionado anteriormente.
	 */
	public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddConsultaBD vacunaBd = new AddConsultaBD(connection);
			mascotas= vacunaBd.getAllMascotas();		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
    
	/**
	 * Este metodo se encarga de mostrar todas las mascotas que se encuentran asociado a un 
	 * cliente seleccionado anteriormente.  
	 *  
	 * @return Este metodo retorna un lista, con todas las mascotas que corresponden al cliente
	 * que fue seleccionado anteriormente.
	 */
	public List<Mascota> getMascotas(String rutCliente){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddVacunacionBD vacunaBd = new AddVacunacionBD(connection);
			mascotas= vacunaBd.getMascotas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
}
