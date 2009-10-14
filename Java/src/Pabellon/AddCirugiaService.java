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
	 * Autor: Jimmy Muñoz
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Usuario contiene los datos de la persona que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
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
	
	public List<String> getTiposCirugias(){
		List<String> cirus=new ArrayList<String>();
		
		cirus.add("");
		cirus.add("Amputación");
		cirus.add("De Apéndice");
		cirus.add("De los aparatos respiratorio");
		cirus.add("De los aparatos cardiovascular");
		cirus.add("De ojo");
		cirus.add("De todo tipo de fractura");
		cirus.add("Del sistema digestivo");
		cirus.add("Del sistema tegumentario");
		cirus.add("Del sistema reproductor");
		cirus.add("Del sistema urinario");
		cirus.add("Dental");
		cirus.add("Estenosis traqueal");
		cirus.add("Ortopédica");
		cirus.add("Partos y cesaria");
		cirus.add("Tiroidectomía (por tumores)");
		cirus.add("De tumor");

		return cirus;	
	}
	
	
	public List<String> getTiposVeterinarios(){
		List<String> cirus=new ArrayList<String>();
		
		cirus.add("");
		cirus.add("Claudio Bonati");
		cirus.add("Patricio Castro");

		return cirus;	
	}
	
	public List<String> getTiposAyudantes(){
		List<String> cirus=new ArrayList<String>();
		
		cirus.add("");
		cirus.add("Claudio Bonati");
		cirus.add("Patricio Castro");
		cirus.add("Sebastian Lopez");
		cirus.add("Juan Bravo");
		cirus.add("Esteban Rodriguez");

		return cirus;	
	}
}
